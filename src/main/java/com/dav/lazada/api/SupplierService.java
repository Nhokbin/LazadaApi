package com.dav.lazada.api;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.dav.lazada.dao.impl.SupplierDAOImpl;

@Path("/supplier")
public class SupplierService {
	
	
	
	@GET
	@Path("/")
	public String hello(){
		return "hello";
	}
	
	@GET
	@Path("/suppliers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getSuppliers(){
		SupplierDAOImpl supplierDAOImpl = new SupplierDAOImpl();
		return supplierDAOImpl.getListSuppliers().toString();
	}
}
