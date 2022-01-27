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

import com.ty.hospitalwebapp.dao.OrdersDao;
import com.ty.hospitalwebapp.dto.Orders;
@WebServlet("/getallorders")
public class GetAllOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	int encounterId=Integer.parseInt(req.getParameter("encounterId"));
    	OrdersDao dao=new OrdersDao();
    	List<Orders> list=dao.getOrdersList(Integer.parseInt(req.getParameter("encounterId")));
    	session.setAttribute("orders", list);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("view_orders.jsp");
    	dispatcher.forward(req, resp);
    	
    }
}
