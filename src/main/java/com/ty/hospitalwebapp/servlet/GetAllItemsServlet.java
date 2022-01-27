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
import com.ty.hospitalwebapp.dao.ItemsDao;
import com.ty.hospitalwebapp.dto.Adress;
import com.ty.hospitalwebapp.dto.Items;
@WebServlet("/getallItems")
public class GetAllItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ItemsDao dao=new ItemsDao();
 	   List<Items> list=dao.getItemList(Integer.parseInt(req.getParameter("orderId")));
    	HttpSession session=req.getSession();
    	session.setAttribute("orders",  list);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("view_items.jsp");
    	dispatcher.forward(req, resp);
    }
}
