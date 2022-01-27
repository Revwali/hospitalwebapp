package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospitalwebapp.dao.PersonDao;
import com.ty.hospitalwebapp.dao.UserDao;
import com.ty.hospitalwebapp.dto.Person;
import com.ty.hospitalwebapp.dto.User;
@WebServlet("/getallpersons")
public class GetAllPersonsServerServlet extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    List<Person> list=new PersonDao().getPersonList();
	    req.setAttribute("list", list);
	    RequestDispatcher dispatcher=req.getRequestDispatcher("view_person.jsp");
	    dispatcher.forward(req, resp);
}
}
