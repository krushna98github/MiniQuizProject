package com.quizdemo;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		System.out.println(" ");
		System.out.println("    PROJECT NAME = QUIZ COMPETITION\n    QUIZ Organized By- Group C ");
		System.out.println(" ");
		String yn = null;

		do {
			Scanner sc1 = new Scanner(System.in);

			GetStudentInfo student = new GetStudentInfo();       // create GetStudentInfo class object 
			student.getStudentInformation();                   //  call the method

			System.out.println("Do you want to retest Quiz");
			System.out.println(" Enter 'Y' for yess, 'N' for no");
			yn = sc1.next();

		} while (yn.equals("y") || yn.equals("Y"));
		System.out.println(" ");
		System.out.println("    THANK YOU FOR ATTEMPTING TEST...");
		System.out.println(" ");

		System.out.println("Total no of student given test.. ");
		System.out.println(" ");
		StudentResultDemo as = new StudentResultDemo();
		as.getResult();                                     // call the method to get all student data.. 
		System.out.println("  ");

		System.out.println("TO GET PARTICULAR STUDENT DATA...");
		System.out.println(" ");
		as.getIndividualStudentData();                            // call the method to get particular student data
       System.out.println(" ");
		System.out.println("       <<  THANK YOU  >> ");

	}

}
