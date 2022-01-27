package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospitalwebapp.dao.UserDao;
import com.ty.hospitalwebapp.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session=req.getSession();
	  
	  PrintWriter writer=resp.getWriter();
	    String mail=req.getParameter("email");
	    String password=req.getParameter("password");
	    User user=new UserDao().validateUser(mail, password);
	    if(user != null) {
	    	session.setAttribute("name", user.getName());
    		session.setAttribute("role", user.getRole());
    		 session.setAttribute("userName", user.getName());
    		
	    	if(user.getRole().equals("staff")) {
	    		 session.setAttribute("branchId", user.getBranch().getId());
	    		writer.println("<html><h2>welcome Staff</h2></html>");
	    		RequestDispatcher dispatcher=req.getRequestDispatcher("staff_home.jsp");
	    		dispatcher.include(req, resp);
	    	}
	    	else if(user.getRole().equals("admin")) {
	    		
	    		writer.println("<html><h2>welcome Admin</h2></html>");
	    		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_home.jsp");
	    		dispatcher.include(req, resp);
	    	}
	    	else if(user.getRole().equals("user")) {
	    		writer.println("<html><h2>welcome User</h2></html>");
	    		RequestDispatcher dispatcher=req.getRequestDispatcher("user_home.jsp");
	    		dispatcher.include(req, resp);
	    	}
	    }
	    else
	    {
	    	writer.println("<html><h2>invalid credentials</h2></html>");
	    	RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
	    	dispatcher.include(req, resp);
	    }
}
}
