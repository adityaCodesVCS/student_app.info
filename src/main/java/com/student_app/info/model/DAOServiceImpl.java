package com.student_app.info.model;
import java.sql.*;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement stmnt;
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/augdb", "root", "admin");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void createInquiry(String name, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into inquiry values('"+name+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInquiry(String email) {
		try {
			stmnt.executeUpdate("delete from inquiry where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateInquiry(String email, String mobile) {
		try {
			stmnt.executeUpdate("update inquiry set mobile='"+mobile+"' where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listInquiry() {
		try {
			ResultSet result = stmnt.executeQuery("select * from inquiry");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
