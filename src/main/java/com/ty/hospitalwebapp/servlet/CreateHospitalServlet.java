package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospitalwebapp.dao.HospitalDao;
import com.ty.hospitalwebapp.dto.Hospital;
@WebServlet("/createhospital")
public class CreateHospitalServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Hospital hospital=new Hospital();
	    hospital.setGst(Double.parseDouble(req.getParameter("gst")));
	    hospital.setName(req.getParameter("name"));
	    hospital.setWebsite(req.getParameter("website"));
	    new HospitalDao().addHospital(hospital);
	    PrintWriter writer=resp.getWriter();
	    writer.println("<html><body><h2>hospital added</h2></body></html>");
	    req.getRequestDispatcher("create_hospital.jsp").include(req, resp);
}
}
