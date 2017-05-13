package com.dav.lazada.dao;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.dav.lazada.entity.Category;


public interface CategoryDAO {
	public String getCategories();
	public String findCategoryById(Integer id) throws JSONException;
	public String findCategoriesByParentId(Integer id) throws JSONException;
	
}
