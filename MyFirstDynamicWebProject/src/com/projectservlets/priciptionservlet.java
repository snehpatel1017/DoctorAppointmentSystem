package com.projectservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projectDao.Priciption;


@WebServlet("/priciptionservlet")
public class priciptionservlet extends HttpServlet {
	static Logger logger = LogManager.getLogger(priciptionservlet.class.getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("priciption");
		String patientid = request.getParameter("patientid");
		HttpSession session = request.getSession();
		String doctorid = (String) session.getAttribute("doctorId");
		String appointmentdate = request.getParameter("appointmentdate");
		Priciption p = new Priciption();
		logger.info("Doctor "+doctorid+" has given the prescription to the Patient "+patientid);
		p.updatepriciption(text, patientid, doctorid, appointmentdate);
		response.sendRedirect("doctorwelcom.jsp");
	}	

}
