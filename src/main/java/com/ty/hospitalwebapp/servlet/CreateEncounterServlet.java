package com.ty.hospitalwebapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospitalwebapp.dao.BranchDao;
import com.ty.hospitalwebapp.dao.Encounterdao;
import com.ty.hospitalwebapp.dao.PersonDao;
import com.ty.hospitalwebapp.dto.Encounter;

@WebServlet("/createEncounter")
public class CreateEncounterServlet  extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  HttpSession session=req.getSession();
	  String person=req.getParameter("personId");
	  int personId=Integer.parseInt(person);
	  int branchId=(Integer)session.getAttribute("branchId");
	   String date=req.getParameter("date");
	   Encounter encounter=new Encounter();
	 LocalDateTime date2=LocalDateTime.parse(date,DateTimeFormatter.ISO_DATE_TIME);
	 encounter.setDate(date2);
	  Encounterdao dao=new Encounterdao();
	    
	    encounter.setCreatorName(req.getParameter("name"));
	    encounter.setReason(req.getParameter("reason"));
	      
	    dao.addEncounter(branchId, personId, encounter);
}
}
