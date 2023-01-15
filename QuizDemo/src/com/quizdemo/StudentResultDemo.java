package com.quizdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentResultDemo {
                // to get total student data from database
	public void getResult() {

		try {
			Connection con2 = null;
			PreparedStatement ps2 = null;

			GetConnection con = new GetConnection();
			con2 = con.getConnectionDetails();          //Query for to get data
			ps2 = con2.prepareStatement("Select studno,firstname,lastname,marks,remark from studdata order by marks desc;");
			ResultSet rs = ps2.executeQuery();
			System.out.println("studno  firstname   lastname  marks      remark");
			while (rs.next()) {
				int a = rs.getInt(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				int d = rs.getInt(4);
				String e = rs.getString(5);

				System.out.println(a + " :   " + b + "      " + c + "   " + d + "          " + e);
			}
			con2.close();
			ps2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
             // To get particular student data
	public void getIndividualStudentData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("If u want to retrive ur result\n" + "Enter ur sid i.e Student id from the table");
		System.out.println(" ");
		int a = sc.nextInt();
		Connection con2 = null;
		PreparedStatement ps3 = null;
		try {
			GetConnection con = new GetConnection();
			con2 = con.getConnectionDetails();
			ps3 = con2
					.prepareStatement("select studno,firstname,lastname,marks,remark from studdata where studno=" + a);
			ResultSet rs3 = ps3.executeQuery();
			while (rs3.next()) {
				System.out.println("No : " + rs3.getInt("studno") + "\n" + rs3.getString("firstname") + " "
						+ rs3.getString("lastname") + "\n" + "your score is : " + rs3.getInt("marks") + " \n"+
						"your remark is : "+ rs3.getString("remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
