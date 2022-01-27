package com.ty.hospitalwebapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospitalwebapp.dao.ItemsDao;
import com.ty.hospitalwebapp.dto.Items;
@WebServlet("/createitem")
public class CreateItemServlet extends HttpServlet{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Items items=new Items();
    	ItemsDao dao=new ItemsDao();
    	items.setMessage(req.getParameter("message"));
    	items.setName(req.getParameter("name"));
    	items.setPrice(Double.parseDouble(req.getParameter("price")));
    	items.setQuantity(Integer.parseInt(req.getParameter("quantity")));
    	dao.addItem(items, Integer.parseInt(req.getParameter("orderId")));
    	RequestDispatcher dispatcher=req.getRequestDispatcher("staff_home.jsp");
    	dispatcher.forward(req, resp);
    }
}
