package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospitalwebapp.dao.AdressDao;
import com.ty.hospitalwebapp.dto.Adress;

@WebServlet("/createadress")
public class CreateAdressServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	AdressDao dao=new AdressDao();
        	Adress adress=new Adress();
        	HttpSession session=req.getSession();
        	adress.setAdress(req.getParameter("adress"));
        	adress.setPin(Integer.parseInt(req.getParameter("pin")));
        	adress.setState(req.getParameter("state"));
        	dao.AddAdress(Integer.parseInt(req.getParameter("branchId")), adress);
        	RequestDispatcher dispatcher=req.getRequestDispatcher("admin_home.jsp");
        	dispatcher.forward(req, resp);
				
				
			
        }
}
