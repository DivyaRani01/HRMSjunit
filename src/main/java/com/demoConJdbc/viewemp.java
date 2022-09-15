/*
 * *****************HUMAN RESOURCE MANAGEMENT SYSTEM*******************************
 * creating a project using java and jdbc to add employee , to delete employee , to hike the salary and to print the data as required.
 */
package com.demoConJdbc;
//importing required packages
import java.util.Scanner;
import static java.lang.System.*;

//creating a class to consume a connection to business logic
//view

public class viewemp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//creating scanner object to take users input
		Scanner obj =new Scanner(System.in);
		out.println("\t\t\t\t\t\t--------WELCOME TO HUMAN RESOURCE  MANAGEMENT SYSTEM----------- ");
	    out.println("\nPress 1 *****to  add emp to the database \nPress 2 *****to remove employee data from database\nPress 3 *****to hike the employee salary \nPress 4 *****to retrive employee data from database");
		out.print("\nYour Choice : ");
	    int opt=obj.nextInt();
		//creating object of empdaocontroller class 
		empDaoController empdao=new empDaoController();
		//calling a connect method
		empdao.connect();
		
		//using switch expression
		switch(opt) 
	{
		
		case 1 -> {
			//Adding employee details by taking required input from the user
			empl e1=new empl();
			//taking employee id from user
			out.print("Enter Employee id : ");
			 int empid=obj.nextInt();
			e1.eId=empid;
			//taking employee name from user
			out.print("Enter Employee Name : ");
			 String empName = obj.next();
			e1.eName=empName;
			//taking employee Domain from user
			out.print("Enter Employee Domain : ");
			 String empDomain = obj.next();
			e1.eDomain=empDomain;
			//taking employee Designation from user
			out.print("Enter Employee Designation : ");
			 String empDesignation = obj.next();
			e1.eDesignation=empDesignation;
			//taking employee location from user
			out.print("Enter Employee Location : ");
			 String empLocation = obj.next();
			e1.eLocation=empLocation;
			//taking employee contact details from user
			out.print("Enter Employee Contact number : ");
			 int empPhone = obj.nextInt();
			e1.eContact=empPhone;
			//taking employee salary from user
			out.print("Enter Employee Salary : ");
			int empSalary = obj.nextInt();
			e1.eSalary=empSalary;
		    //calling addEmp method 
			empdao.addEmp(e1);
			out.println("Successfully Added the Employee Details ....! ");
		         }
		
		case 2 -> { 
			//second method to delete the employee details from database
			out.print("Enter Employee Id for removing the details of the employee : ");
			int eid = obj.nextInt();
			
			// Calling get employee method
			empl e2= empdao.deltEmp(eid);
		  out.println("Successfully removed the "+eid+" Employee Details ....! ");
		          }
		 
	    case 3 ->{
	    	//third case to hike the salary of individual employee
	    	int amt,id;
			out.print("\nEnter Employee Id  : ");
			id = obj.nextInt();
			out.print("Enter Percentage for Salary Hike : ");
			amt = obj.nextInt();
			// CALLING HIKE SALARY METHOD TO ADD HIKE AMOUNT IN SALARY
			int rst = empDaoController.hikeSlry(id,amt);
				if(rst>0)
				  out.println("\nUpdated Salary : "+rst);	
			    else
				   out.println("\nEmployee does not Exist!!!");
					}
		
		
		case 4 -> {
			//case 2 to retrieve the data 
			out.print("Enter Employee Id for the details : ");
			int eid = obj.nextInt();
			
			// Calling get employee method
			empl e2= empdao.getEmp(eid);
		  out.println(e2.eId+" is "+e2.eName+" working in domain "+e2.eDomain+" with a salary "+e2.eSalary+" per month.");
		         }
		
		
		
		}
		obj.close();
	}

}
