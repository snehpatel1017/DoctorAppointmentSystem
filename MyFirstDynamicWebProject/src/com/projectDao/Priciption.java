package com.projectDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Priciption {
	String url = "jdbc:mysql://localhost:3306/sneh";
	String username = "root";
	String password = "Sneh@0701";
   public void updatepriciption(String text,String patientid,String doctorid,String appointmentdate){
	   String sql = "update appointment set priciption = ? where patientid = ? and doctorid = ? and appointmentdate=?";
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, text);
			st.setString(2, patientid);
			st.setString(3, doctorid);
			st.setString(4, appointmentdate);
			st.execute();
	   }
	   catch(Exception e){
		   
	   }
   }
   public void updatestatus(String patientid,String doctorid,String appointmentdate){
	   String sql = "update appointment set status = 'complete' where patientid = ? and doctorid = ? and appointmentdate=?";
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, patientid);
			st.setString(2, doctorid);
			st.setString(3, appointmentdate);
			st.execute();
	   }
	   catch(Exception e){
		   
	   }
   }
}
