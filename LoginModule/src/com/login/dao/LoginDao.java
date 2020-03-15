package com.login.dao;

import java.sql.*;

public class LoginDao {
	
	String sql = "SELECT * FROM LOGINUSERS where UName=? and pass=?";
	String user = "root";
	String pass = "root";
	String url = "jdbc:mysql://localhost:3306/student";
	

	public boolean Check(String uname, String pwd) {
		try {

			// step1 load the driver class
			Class.forName("com.mysql.jdbc.Driver");

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
