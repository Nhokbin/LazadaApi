package com.dav.lazada.dao;

public interface EmployeeDAO {
	String checkLogin(String email, String password);
	
	boolean checkEmail(String email);
	
	boolean insertEmployee(String email, String name, String password, String emailExclusive,String categoryId);
}
