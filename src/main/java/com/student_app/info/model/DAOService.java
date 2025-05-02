package com.student_app.info.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyLogin(String email, String password);
	public void createInquiry(String name, String email, String mobile);
	public void deleteInquiry(String email);
	public void updateInquiry(String email, String mobile);
	public ResultSet listInquiry();	
}
