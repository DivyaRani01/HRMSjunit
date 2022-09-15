//Creating a class connection to insert and retrieve the values to database
//controller

package com.demoConJdbc;

import java.sql.*;
import static java.lang.System.*;

public class empDaoController  {
	static Connection con=null;                                                        //global object 
	//creating a method to connect vd database
	public void connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//getting connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demoemptech","root","Divya123");
		
	}
	 //creating a method to add the values in database
	public static void addEmp(empl e1) throws SQLException {
		String query="insert into demotechemp values(?,?,?,?,?,?,?)";
		//preparing statement from con object
		PreparedStatement psm=con.prepareStatement(query);
		//inserting the values
		psm.setInt(1, e1.eId);
		psm.setString(2,e1.eName);
		psm.setString(3,e1.eDomain);
		psm.setString(4,e1.eDesignation);
		psm.setString(5,e1.eLocation);
		psm.setInt(6,e1.eContact);
		psm.setInt(7,e1.eSalary);
		//using executeupdatemethod to update or modify the values
		int count=psm.executeUpdate();
        out.println("\n\t"+count+" *row get affected*");
		
		}
	
//creating method to remove  values  via employee id
		public empl deltEmp(int eid) throws Exception {
			empl e=new empl();
			e.eId=eid;
			String query="delete from demotechemp where eid="+eid;
			//creating statement
			//preparing statement from con object
			PreparedStatement psm=con.prepareStatement(query);
			//inserting the values
			
			//using executeupdatemethod to update or modify the values
			int count=psm.executeUpdate();
	        out.println(count+" *row get affected *");
	     return e;
		}
		
		//creating a method for incrementing the salary of employees
		public static int hikeSlry(int id,int hike) throws Exception {
			Statement sm = con.createStatement();
			
			// taking employee details via employee id
			ResultSet set = sm.executeQuery("select * from demotechemp where eid ="+id);
			//using if else for incrementing salary
			if(set.next()) {
				Statement hikeSm = con.createStatement();
				int salary = set.getInt(7);
				salary = salary+((salary*hike)/100);
				// updating data in the database
				hikeSm.executeUpdate("update demotechemp set eSalary = "+salary+" where eid ="+id);
				return salary;
			}
             //if id does not exist in the database
			else 
				return 0;
		}
	
//creating method to printing values  via employee id
	    public empl getEmp(int eid) throws Exception {
		   empl e=new empl();
		   e.eId=eid;
		   String query="select * from demotechemp where eid="+eid;
		   //creating statement
		   Statement sm =con.createStatement();
		   //execute the statement
		   ResultSet rst= sm.executeQuery(query);
		   //to get cursor on next element
		   rst.next();
		   e.eName=rst.getString(2);
		   e.eDomain=rst.getString(3);
		   e.eDesignation=rst.getString(4);
		   e.eLocation=rst.getString(5);
		   e.eContact=rst.getInt(6);
		   e.eSalary=rst.getInt(7);
		
		return e;
	}
	
}
