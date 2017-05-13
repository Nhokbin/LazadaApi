package com.dav.lazada.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.dav.lazada.dao.impl.CategoryDAOImpl;
import com.dav.lazada.dao.impl.ProductDAOImpl;
import com.dav.lazada.entity.Category;
import com.dav.lazada.entity.Product;


@Path("/category")
public class CategoryService {

	@GET
	@Path("/")
	public String hello(){
		return "Hello";
	}
	
	@GET
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategories(){
		CategoryDAOImpl categoryDAOImpl=new CategoryDAOImpl();
		
		return categoryDAOImpl.getCategories().toString();
	}
	
	@GET
	@Path("/listcategory/{parentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoriesById(@PathParam("parentId") Integer parentId) throws JSONException{
		CategoryDAOImpl categoryDAOImpl=new CategoryDAOImpl();
		String categories=categoryDAOImpl.findCategoriesByParentId(parentId);
		
		return categories;
	}
	
	@POST
	@Path("/find")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String findCategory(JSONObject jsonObject) throws JSONException{
		CategoryDAOImpl categoryDAOImpl=new CategoryDAOImpl();
		System.out.println(jsonObject.get("id"));
		String result=categoryDAOImpl.findCategoryById(Integer.parseInt((String) jsonObject.get("id")));
		
		return result;
	}
	
	@POST
	@Path("/parent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String findCategoriesByParentId(JSONObject jsonObject) throws NumberFormatException, JSONException {
		
		CategoryDAOImpl categoryDAOImpl=new CategoryDAOImpl();
		return categoryDAOImpl.findCategoriesByParentId(Integer.parseInt((String) jsonObject.get("id")));
		
		
	}
}
