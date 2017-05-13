package com.dav.lazada.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Hibernate;

import com.dav.lazada.connect.DBService;
import com.dav.lazada.connect.SERVER;
import com.dav.lazada.dao.ProductDAO;
import com.dav.lazada.entity.Product;

public class ProductDAOImpl extends DBService implements ProductDAO {

	EntityManager em;
	EntityManagerFactory factory;

	public String getProducts() {
		factory = Persistence.createEntityManagerFactory("lazada");
		em = factory.createEntityManager();

		TypedQuery<Product> query = em.createQuery("from Product", Product.class);
				
		
		List<Product> products = query.setFirstResult(0)
									.setMaxResults(3)
									.getResultList();
		JSONArray array = new JSONArray();
		try {
			for (Product product : products) {
				JSONObject object = new JSONObject();
				object.put("id", product.getId())
						.put("name", product.getName())
						.put("unitPrice", product.getUnitPrice())
						.put("bigImage", SERVER.SERVER +":"+ SERVER.IP +"/"+ SERVER.HOME +"/imgs/imgProduct/"+ product.getBigImage())
						.put("smallImage", product.getSmallImage())
						.put("description", product.getDescription())
						.put("quantity", product.getQuantity())
						.put("supplierId", product.getSupplier().getId())
						.put("categoryId", product.getCategory().getId());
				HashMap<String, JSONObject>map=new HashMap<String, JSONObject>();
				map.put("Product", object);
				array.put(map);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
		factory.close();
		return array.toString();
	}

}
