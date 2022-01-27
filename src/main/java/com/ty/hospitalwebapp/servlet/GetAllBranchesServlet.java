package com.ty.hospitalwebapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospitalwebapp.dao.BranchDao;
@WebServlet("/getallbranches")
public class GetAllBranchesServlet extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	BranchDao branchDao=new BranchDao();
	session.setAttribute("branches", branchDao.getBranchList(Integer.parseInt(req.getParameter("hospitalId"))));
	RequestDispatcher dispatcher=req.getRequestDispatcher("view_branch.jsp");
	dispatcher.forward(req, resp);
}
}
