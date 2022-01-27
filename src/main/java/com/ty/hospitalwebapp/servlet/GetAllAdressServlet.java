package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospitalwebapp.dao.AdressDao;
import com.ty.hospitalwebapp.dto.Adress;

@WebServlet("/getallAdress")
public class GetAllAdressServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	AdressDao dao=new AdressDao();
    	List<Adress> adresses=dao.getAdressList(Integer.parseInt(req.getParameter("branchId")));
    	session.setAttribute("adresses", adresses);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("view_adress.jsp");
    	dispatcher.forward(req, resp);
    }
}
