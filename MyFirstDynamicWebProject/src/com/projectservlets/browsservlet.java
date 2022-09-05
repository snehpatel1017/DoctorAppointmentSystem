package com.projectservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/browsservlet")
public class browsservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = (String) request.getParameter("city");
		request.setAttribute("city", city);
		String cheking = (String) request.getAttribute("city");
		System.out.print(cheking);
		response.sendRedirect("welcom.jsp");
	}

	

}
