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

import com.ty.hospitalwebapp.dao.HospitalDao;
import com.ty.hospitalwebapp.dto.Hospital;
@WebServlet("/getallhospitals")
public class GetAllHospitalsServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HospitalDao dao=new HospitalDao();
    	List<Hospital> list=dao.getHospitalList();
    	HttpSession session=req.getSession();
    	session.setAttribute("hospitals", list);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("view_hospitals.jsp");
    	dispatcher.forward(req, resp);
    	
    }
}
