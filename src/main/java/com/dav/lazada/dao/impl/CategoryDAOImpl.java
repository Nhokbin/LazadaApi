package com.dav.lazada.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.dav.lazada.connect.DBService;
import com.dav.lazada.dao.CategoryDAO;
import com.dav.lazada.entity.Category;

public class CategoryDAOImpl extends DBService implements CategoryDAO {

	EntityManager em;
	EntityManagerFactory factory;

	public String getCategories() {
		factory = Persistence.createEntityManagerFactory("lazada");
		em = factory.createEntityManager();

		String sql = "Select cate FROM Category cate";
		Query query = em.createQuery(sql);
		List<Category> categories = query.getResultList();
		
		JSONArray array = new JSONArray();
		JSONObject result=new JSONObject();
		for (Category category : categories) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", category.getId())
					.put("name", category.getName())
					.put("parentId",category.getParentId().getId());
				HashMap<String, JSONObject>map=new HashMap<String, JSONObject>();
				map.put("Category", object);
				array.put(map);
				System.out.println(category.getName());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			result.put("Categories", array);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
		factory.close();
		return result.toString();
	}

	public String findCategoryById(Integer id) throws JSONException {
		factory = Persistence.createEntityManagerFactory("lazada");
		em = factory.createEntityManager();

		Category category = em.find(Category.class, id);

		
		JSONObject object = new JSONObject();
		JSONObject jcategory = new JSONObject();

		jcategory.put("id", category.getId());
		jcategory.put("name", category.getName());
		jcategory.put("parentId", category.getParentId().getId());
		object.put("Category", jcategory);
		em.close();
		factory.close();
		return object.toString();
	}

	public String findCategoriesByParentId(Integer id) throws JSONException {
		factory = Persistence.createEntityManagerFactory("lazada");
		em = factory.createEntityManager();

		String sql = "Select cate From Category cate Where cate.parentId=:id";
		Query query = em.createQuery(sql);

		query.setParameter("id", em.find(Category.class, id));
		List<Category> categories = query.getResultList();
		
		
		JSONArray array = new JSONArray();
		JSONObject result=new JSONObject();
		for (Category category : categories) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", category.getId())
					.put("name", category.getName())
					.put("parentId",category.getParentId().getId());
				HashMap<String, JSONObject>map=new HashMap<String, JSONObject>();
				map.put("Category", object);
				array.put(map);
				System.out.println(category.getName());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		result.put("Categories", array);

		em.close();
		factory.close();
		return result.toString();
	}

}
