package com.dav.lazada.api;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

import com.dav.lazada.dao.impl.EmployeeDAOImpl;
import com.dav.lazada.entity.Employee;

@Path("/employee")
public class EmployeeService {

	String result = "";

	@GET
	@Path("/")
	public String hello() {
		return "hello";
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/check/{email}/{password}")
	public String testCheckPass(@PathParam("email") String email, @PathParam("password") String password) {
		EmployeeDAOImpl daoImpl = new EmployeeDAOImpl();
		result = daoImpl.checkLogin(email, password);
		return result;
	}

	@POST
	@Path("/check")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String checkPass(JSONObject object) {
		String email;
		try {
			email = object.getString("tendangnhap");
			String password = object.getString("matkhau");
			EmployeeDAOImpl daoImpl = new EmployeeDAOImpl();

			result = daoImpl.checkLogin(email, password);
			System.out.println(result);
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

/*	@GET
	@Path("/insert/{username}/{name}/{password}/{categoryId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String testInsertEmployee(@PathParam("username") String username, @PathParam("name") String name,
			@PathParam("password") String password, @PathParam("categoryId") String categoryId) {
		String result;

		EmployeeDAOImpl daoImpl = new EmployeeDAOImpl();

		if (!daoImpl.checkEmail(username)) {

			daoImpl.insertEmployee(username, name, password, categoryId);
			return "insert success";
		} else {
			return "insert false";
		}

		
	}*/

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertEmployee(JSONObject jsonObject) {
		String username, name, password, emailExclusive, categoryId, result;
		System.out.println(jsonObject);
		try {
			EmployeeDAOImpl daoImpl = new EmployeeDAOImpl();
			username = jsonObject.getString("tenDangNhap");
			if (!daoImpl.checkEmail(username)) {
				name = jsonObject.getString("tenNV");
				password = jsonObject.getString("password");
				emailExclusive = jsonObject.getString("emailDocQuyen");						
				categoryId = jsonObject.getString("maLoaiNV");

				daoImpl.insertEmployee(username, name, password, emailExclusive,categoryId);
				System.out.println("Insert is success");
			} else {
				System.out.println("Insert is not success");
				return "";
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
