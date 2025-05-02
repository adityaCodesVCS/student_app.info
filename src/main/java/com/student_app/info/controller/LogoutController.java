package com.student_app.info.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logOut") //This "logOut" annotation name came from menu.jsp
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public LogoutController() {
        super();       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			HttpSession session = request.getSession(false); //i.e. access 'session' object which already created & not get newly created.
			session.setMaxInactiveInterval(10);
			//System.out.println(session.getAttribute("email"));
			session.invalidate(); //this line'll destroy the data from 'session' object.
			//System.out.println(session.getAttribute("email"));-->gotError
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Session time out, login again!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		    rd.forward(request, response);
		}
	}
}
