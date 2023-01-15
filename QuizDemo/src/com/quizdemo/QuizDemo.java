package com.quizdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QuizDemo {
	public int marks;
	public  void getquiz()
	{
		QuizDemo quizDemo=new QuizDemo();
		Scanner sc=new Scanner(System.in);
		
		Map<Integer, String> map=new LinkedHashMap<Integer, String>();       //create object of LinkedHashMap with generic
		Connection connection=null;             
		PreparedStatement ps=null;
		
		try{
			GetConnection con=new GetConnection();
			connection=con.getConnectionDetails();                      //create the connection
		
		for(int i=1;i<=10;i++)
		{
			    //created the query to get questions from database.
			ps=connection.prepareStatement("select queno,question,option_A,option_B,option_C ,option_D,corr_option,corr_opt from projectdemo where queno="+i);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				map.put(88, rs.getString(2));            
				
				map.put(1, rs.getString(3));
				map.put(2, rs.getString(4));             //Getting data from database 
				map.put(3, rs.getString(5));
				map.put(4, rs.getString(6));
				
				Set<Integer> s=map.keySet();               //sorting key by keySet() method
				
				for(Integer j:s)
				{
					System.out.println(j+" : "+map.get(j));               //print question with options in console
				}
				System.out.println(" ");
				System.out.println("Choose correct option");
				int a=sc.nextInt();
				if(a==rs.getInt(8))
				{
					System.out.println("Right Answer : "+rs.getString(7));
					quizDemo.marks++;                                           // counting the marks
				}else 
				{
					System.out.println("Wrong Answer");
					System.out.println("Right answer is >> "+rs.getString(7));
				}
			     this.marks=quizDemo.marks;
				System.out.println();
			}
		
		ps.close();
		}
		connection.close();
		
		
 
		
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
