package com.login.dao;

import java.sql.*;

public class LoginDao {
	
	String sql = "SELECT * FROM LOGINUSERS where username=? and password=?";
	String user = "vijay";
	String pass = "vijay";
	String url = "jdbc:oracle:thin:vijay@localhost:1521:xe";
	

	public boolean Check(String uname, String pwd) {
		try {

			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(url,user,pass);

			// step3 create the statement object
			// Statement stmt = con.createStatement();

			// step3 create the prepared statement object

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1,uname);
			pst.setString(2,pwd);

			// step4 execute query
			ResultSet rs = pst.executeQuery();

			if (rs.next()) 
			{
				
				return true;
			}
			// step5 close the connection object
		} 
		catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}

}
