package com.student_app.info.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.student_app.info.model.DAOServiceImpl;

@WebServlet("/addInquiry")
public class InquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InquiryController() {
        super();        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);  
			session.setMaxInactiveInterval(10);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/inquiry.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Session time out, login again!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		    rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false); //Its good practice to write 'false' here otherwise we can write 'true' or can kept blank here. 
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
			    String name = request.getParameter("name");
			    String email = request.getParameter("email");
			    String mobile = request.getParameter("mobile");
			
			    DAOServiceImpl service = new DAOServiceImpl();
			    service.connectDB();
			    service.createInquiry(name, email, mobile);
			    request.setAttribute("message", "Saved");
			    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/inquiry.jsp");
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
}
