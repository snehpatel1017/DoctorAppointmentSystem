package com.sigin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SiginDao {
	String sql = "insert into patient values(?,?,?)";
	String cheking = "select * from patient where patientId = ?";
	String url = "jdbc:mysql://localhost:3306/sneh";
	String username = "root";
	String password = "Sneh@0701";
    public boolean chek(String name,String user,String pass){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(cheking);
			st.setString(1,user);
			ResultSet rs = st.executeQuery();
			if(rs.next())return false;
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2,user);
			st.setString(3,pass);
			st.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
}
