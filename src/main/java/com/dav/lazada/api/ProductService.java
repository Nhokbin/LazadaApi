package com.dav.lazada.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dav.lazada.dao.impl.ProductDAOImpl;
import com.dav.lazada.entity.Product;


@Path("/product")
public class ProductService {

	@GET
	@Path("/")
	public String hello(){
		return "Hello";
	}
	
	@GET
	@Path("/products")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getProducts(){
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		String products=productDAOImpl.getProducts().toString();
		
		return products;
	}
}
