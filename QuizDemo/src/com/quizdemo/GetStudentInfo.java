package com.quizdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class GetStudentInfo extends QuizDemo {
	public void getStudentInformation() {
		String remark = null;                                   //initializing remark variable
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name : ");
		String firstname = sc.next();                           // accepting user input data and store in variable
		sc.nextLine();
		System.out.println("Enter your last name : ");
		String lastname = sc.next();
		System.out.println(" ");
		System.out.println("<<  Quiz  Started  >>");
		System.out.println(" ");
		try {
			getquiz();                                             // this method starts the quiz from QuizDemo class
		} catch (Exception e) {
			e.printStackTrace();
		}

		updateUserInput(firstname, lastname, marks, remark);            //calling method for update user data in database

	}

	public void updateUserInput(String firstname, String lastname, int marks, String remark) {
		Connection con1 = null;
		PreparedStatement ps1 = null;
		try {
			GetConnection con = new GetConnection();                  //creating object of connection
			con1 = con.getConnectionDetails();      
			ps1 = con1.prepareStatement("insert into studdata(firstname,lastname,marks,remark)values(?,?,?,?);");   //insert data quiry
			ps1.setString(1, firstname);
			ps1.setString(2, lastname);                              // setting value for database    
			ps1.setInt(3, marks);

			if (marks <= 10 && marks > 8) {
				remark = "A";
			} else if (marks <= 8 && marks >= 6) {
				remark = "B";                                         // for remarks condition
			} else if (marks == 5) {
				remark = "C";
			} else if (marks < 5) {
				remark = "Fail";
			}

			ps1.setString(4, remark);
			ps1.executeUpdate();
			System.out.println("Record is inserted in database.");
			System.out.println(" ");

			System.out.println(firstname + " your score is : " + marks + " out of 10 .");
			System.out.println(" "); 
			System.out.println("Your Grade Is >> " + remark);
			System.out.println(" ");

			con1.close();
			ps1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
