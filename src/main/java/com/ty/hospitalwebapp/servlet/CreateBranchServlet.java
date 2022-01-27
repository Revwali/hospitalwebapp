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
import com.ty.hospitalwebapp.dao.HospitalDao;
import com.ty.hospitalwebapp.dto.Branch;
@WebServlet("/createbranch")
public class CreateBranchServlet extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session=req.getSession();
	   BranchDao dao=new BranchDao();
	   Branch branch=new Branch();
	   int hospitalId=Integer.parseInt(req.getParameter("hospital_id"));
	//  branch.setHospital(new HospitalDao().getHospital(hospitalId));
	  branch.setMail(req.getParameter("mail"));
	  branch.setName(req.getParameter("name"));
	  branch.setPlace(req.getParameter("place"));
	  dao.addBranch(branch, hospitalId);
	   RequestDispatcher dispatcher=req.getRequestDispatcher("admin_home.jsp");
	   dispatcher.forward(req, resp);
}
}
