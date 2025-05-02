package com.student_app.info.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.student_app.info.model.DAOServiceImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
	@Override
	public void init(ServletConfig config) throws ServletException { //It came from HttpServelet. 
		System.out.println("It's like birth of Servelet.");
		super.init(config);
	}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			DAOServiceImpl service = new DAOServiceImpl();
			service.connectDB();
			boolean status = service.verifyLogin(email, password);
			if (status) {
				HttpSession session = request.getSession(true); //i.e. 'session' object get newly created.
				session.setAttribute("email", email); //i.e. put data(email through which user logged-in) in 'session' object.
			      /* Now i.e. If there is a data present in 'session' object it means user is logged-in
		             and If there is a no data present in 'session' object it means user is logged-out.
		             So we can say If we destroy 'session' object's data then user got logged-out. */
				
				session.setMaxInactiveInterval(10);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/inquiry.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid Credentials !"); //I'll create variable as "errorMessage" in 'request' object and store "invalid credentials" as message in that variable.
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
	@Override
	public void destroy() { //It came from GenericServelet.
		System.out.println("It's like death of Servelet.");
		super.destroy();
	}
}
