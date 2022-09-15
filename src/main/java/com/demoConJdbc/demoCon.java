package com.demoConJdbc;
//importing required packages
import java.sql.*;


public class demoCon {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost : 3306/demoemptech";
		String username="root";
		String password ="Divya123";
	
		String query="select * from demotechemp where eid=103";
		//getting connection
		Connection con=DriverManager.getConnection(url,username,password);
		//creation of statement
		Statement sm =con.createStatement();
		//execute the statement
		ResultSet rst= sm.executeQuery(query);
		//to get cursor on next element
		rst.next();
		//process the result
		String empDetails="Emp name : "+rst.getString("ename")+"\nDomain  :  "+rst.getString("edomain");
		
		System.out.println(empDetails);
		//closing connection object
		con.close();
		

	}

}
