package com.dav.lazada.dao.impl;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


import com.dav.lazada.connect.DBService;
import com.dav.lazada.connect.SERVER;
import com.dav.lazada.dao.SupplierDAO;
import com.dav.lazada.entity.Supplier;

public class SupplierDAOImpl extends DBService implements SupplierDAO{

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	
	public String getListSuppliers() {
		entityManagerFactory = Persistence.createEntityManagerFactory("lazada");
		entityManager = entityManagerFactory.createEntityManager();
		
		TypedQuery<Supplier> query = entityManager.createQuery("from Supplier",Supplier.class);
		List<Supplier> suppliers = query.getResultList();
		JSONArray array = new JSONArray();
		try{
			
			for (Supplier supplier : suppliers) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", supplier.getId())
				.put("name", supplier.getName())
				.put("img",	 SERVER.SERVER +":"+ SERVER.IP +"/" +SERVER.HOME +"/imgs/"+supplier.getLogo())
				.put("buys", supplier.getBuys());
				HashMap<String, JSONObject>map = new HashMap<String, JSONObject>();
				map.put("Supplier", jsonObject);
				array.put(map);
			}
		}catch(JSONException e){
			e.printStackTrace();
		}
		entityManager.close();
		entityManagerFactory.close();
		return array.toString();
	}

}
