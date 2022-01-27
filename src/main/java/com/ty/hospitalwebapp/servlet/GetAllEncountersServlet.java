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

import com.ty.hospitalwebapp.dao.Encounterdao;
import com.ty.hospitalwebapp.dto.Encounter;
@WebServlet("/getallencounters")
public class GetAllEncountersServlet extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Encounterdao encounterdao=new Encounterdao();
	List<Encounter> list=encounterdao.getEncounterList(Integer.parseInt(req.getParameter("personId")));
	HttpSession session=req.getSession();
	session.setAttribute("encounters", list);
	String role=(String)session.getAttribute("role");
	if(!role.equals("user")) {
	RequestDispatcher dispatcher=req.getRequestDispatcher("view_encounter.jsp");
	dispatcher.forward(req, resp);
	}else
	{
		session.setAttribute("branchId", 0);
		RequestDispatcher dispatcher=req.getRequestDispatcher("view_encounter.jsp");
		dispatcher.forward(req, resp);
	}
}
}
