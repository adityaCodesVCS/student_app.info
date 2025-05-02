package com.student_app.info.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.student_app.info.model.DAOServiceImpl;

@WebServlet("/listInquiry")
public class ListInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;     
    public ListInquiryController() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
				DAOServiceImpl service = new DAOServiceImpl();
				service.connectDB();
				
				ResultSet result = service.listInquiry();
				request.setAttribute("result", result);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/list_inquiry.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Session time out, login again!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		    rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
