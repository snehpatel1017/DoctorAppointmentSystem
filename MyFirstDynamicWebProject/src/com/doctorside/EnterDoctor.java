package com.doctorside;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;


import org.apache.logging.log4j.*;


import com.projectservice.GetPass;
public class EnterDoctor {
    static String sql = "insert into doctorlogin values(?,?)";
	static final String url = "jdbc:mysql://localhost:3306/sneh";
	static final String username = "root";
	static final String password = "Sneh@0701";
	static Logger logger = LogManager.getLogger(EnterDoctor.class.getName());
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Doctor Name : ");
		String name = sc.nextLine();
		System.out.print("Enter the Password : ");
		String pass = sc.nextLine();
		
		pass = GetPass.getpass(pass);
		System.out.println(pass);
		
//		logger.error("error----");
//		logger.info("this is info");
//		logger.error("error----");
//		logger.info("this is info");
//		logger.error("error----");
//		logger.info("this is info");
//		logger.error("error----");
//		logger.info("this is info");
//		logger.error("error----");
//		logger.info("this is info");
//		logger.error("error----");
//		logger.info("this is info");
//		logger.error("error----");
//		logger.info("this is info");
//		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pass);
			st.execute();
			System.out.print("Entered Sucsessfully");
		}
		catch(Exception e){
			
		}
		
	}
}
