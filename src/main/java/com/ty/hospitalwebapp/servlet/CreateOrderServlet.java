package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospitalwebapp.dao.OrdersDao;
import com.ty.hospitalwebapp.dto.Orders;
@WebServlet("/createorders")
public class CreateOrderServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	String name=(String) session.getAttribute("userName");
	OrdersDao dao=new OrdersDao();
	 Orders orders=new Orders();
	 orders.setCreatorName(name);
	String date= req.getParameter("datetime");
	 LocalDateTime date2=LocalDateTime.parse(date,DateTimeFormatter.ISO_DATE_TIME);
	 orders.setDateTime(date2);
	 orders.setMessage(req.getParameter("message"));
	 dao.addOrder(orders, Integer.parseInt(req.getParameter("encounterId")));
	 RequestDispatcher dispatcher=req.getRequestDispatcher("staff_home.jsp");
	 dispatcher.forward(req, resp);
}
}
