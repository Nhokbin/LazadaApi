package com.dav.lazada.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.dav.lazada.connect.DBService;
import com.dav.lazada.dao.EmployeeDAO;
import com.dav.lazada.entity.Category;
import com.dav.lazada.entity.CategoryEmployee;
import com.dav.lazada.entity.Employee;

public class EmployeeDAOImpl extends DBService implements EmployeeDAO {

	EntityManager em;
	EntityManagerFactory factory;

	public String checkLogin(String email, String password) {
		if (!email.equals("")) {
			factory = Persistence.createEntityManagerFactory("lazada");
			em = factory.createEntityManager();

			String sql = "Select empl FROM Employee empl Where empl.userName=:email and empl.password=:password";
			Query query = em.createQuery(sql);
			query.setParameter("email", email);
			query.setParameter("password", password);

			String result = "";
			String name = "";
			List<Employee> employees = query.getResultList();

			JSONObject object = new JSONObject();
			if (employees.size() != 0) {
				result = "true";
				name = employees.get(0).getName();
			} else {
				result = "false";
			}
			try {
				object.put("result", result);
				object.put("tennv", name);
			} catch (JSONException e) {

				e.printStackTrace();
			}

			em.close();
			factory.close();
			return object.toString();
		}

		return null;
	}

	public boolean checkEmail(String email) {
		if (!email.equals("")) {
			factory = Persistence.createEntityManagerFactory("lazada");
			em = factory.createEntityManager();

			String sql = "Select empl FROM Employee empl Where empl.userName=:email";
			Query query = em.createQuery(sql);
			query.setParameter("email", email);

			boolean flag = false;
			List<Employee> employees = query.getResultList();
			if (employees.size() > 0) {
				flag = true;
			}
			em.close();
			factory.close();
			return flag;
		}
		return false;
	}

	public boolean insertEmployee(String email, String name, String password, String emailExclusive,String categoryId) {
		boolean flag = false;
		if (!email.equals("") && !name.equals("") && !password.equals("") && !categoryId.equals("")) {
			factory = Persistence.createEntityManagerFactory("lazada");
			em = factory.createEntityManager();
			EntityTransaction entityTransaction = em.getTransaction();
			entityTransaction.begin();
			try {
				
				
				  Query query = em.createNativeQuery(
				  "INSERT INTO employees(name, password, username, emailexclusive,categoryeid) VALUES (?,?,?,?,?)"); 
				  query.setParameter(1, name);
				  query.setParameter(2, password); 
				  query.setParameter(3,email); 
				  query.setParameter(4, Boolean.parseBoolean(emailExclusive));
				  query.setParameter(5, Integer.parseInt(categoryId));
				  query.executeUpdate();
				 

				entityTransaction.commit();
				flag = true;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				entityTransaction.rollback();
			} finally {
				em.clear();
				em.close();
				factory.close();
				
			}

		}

		return flag;
	}

	public CategoryEmployee getCategoryEpl(Integer id) {

		factory = Persistence.createEntityManagerFactory("lazada");
		em = factory.createEntityManager();

		String sql = "Select empl FROM CategoryEmployee empl Where empl.id=:id";
		Query query = em.createQuery(sql);
		query.setParameter("id", id);

		List<CategoryEmployee> employees = query.getResultList();

		em.close();
		factory.close();
		return employees.get(0);
	}

}
