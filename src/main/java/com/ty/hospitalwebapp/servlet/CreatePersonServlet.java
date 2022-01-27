package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospitalwebapp.dao.PersonDao;
import com.ty.hospitalwebapp.dto.Person;
@WebServlet("/createperson")
public class CreatePersonServlet extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   PrintWriter writer=resp.getWriter(); 
	    	  Person person=new Person();
	    	  person.setAge(Integer.parseInt(req.getParameter("age")));
	    	  person.setGender(req.getParameter("gender"));
	    	  person.setMail(req.getParameter("mail"));
	    	  person.setName(req.getParameter("name"));
	    	  person.setPhone(Long.parseLong(req.getParameter("phone")));
	    	 // int id=Integer.parseInt(req.getParameter("encounterId"));
	    	  new PersonDao().addPerson(person);
	    	 writer.println("<html><body><h2>person created</h2></body></html>");
	    	 RequestDispatcher dispatcher=req.getRequestDispatcher("create_person.jsp");
	    	 dispatcher.include(req, resp);
	    
}
}
