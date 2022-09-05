package com.projectservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BookAppointment.BookAppointmentDao;

/**
 * Servlet implementation class bookingappointment
 */
@WebServlet("/bookingappointmentservlet")
public class bookingappointment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String doctorId = request.getParameter("doctorId");
		String appointmentdate = request.getParameter("appointmentdate");
		HttpSession session = request.getSession();
		String patientId = (String) session.getAttribute("patientId");
		BookAppointmentDao b = new BookAppointmentDao();
		System.out.print(doctorId+"\n");
		System.out.print(patientId+"\n");
		System.out.print(appointmentdate+"\n");
		b.booking(patientId, doctorId, appointmentdate);
		RequestDispatcher rd = request.getRequestDispatcher("welcom.jsp");
		rd.forward(request, response);
	}

	
}
