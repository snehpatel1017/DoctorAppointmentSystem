package com.sigin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.loginpage.LoginDao;
import com.projectservice.Authentication;
import com.projectservice.GetPass;
import com.projectservice.InvalidMessage;

@WebServlet("/SiginServlet")
public class SiginServlet extends HttpServlet {
	static Logger logger = LogManager.getLogger(SiginServlet.class.getName());
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String str = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		HttpSession session = request.getSession();
		if(pass.length() == 0 || pass.equals(cpass)==false){
			InvalidMessage m = new InvalidMessage("Enter the Valid Password");
			session.setAttribute("invalid", m);
			response.sendRedirect("patientsigin.jsp");
		}
		else{
		pass = GetPass.getpass(pass);
		PrintWriter out = response.getWriter();
			SiginDao sg = new SiginDao();
			boolean ch = sg.chek(name,str,pass);
			if(ch==false){
				InvalidMessage m = new InvalidMessage("Userid is already been taken try another");
				session.setAttribute("invalid", m);
				response.sendRedirect("patientsigin.jsp");
			}
			else{
			LoginDao d = new LoginDao();
			String patientname = (String) d.patient(str, pass);	
			logger.info("Patient  " + str + " is Sigin");
			session.setAttribute("patientId", str);
			session.setAttribute("patientName",name);
			response.sendRedirect("welcom.jsp");
			}
		}
		
	}

}
