package com.interview.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class TaskOne 
{
	public static void main(String[] args) throws SQLException 
	{
		
		//find the tripalets which means some of the elemnts should be zero and also all elements are distinct
		
		//here mask value is 3 for the triplates
		// 1, 0, 1 -2 ,3, -4
		String url = "jdbc:mysql://127.0.0.1:3306/triplates";
		String username = "root";
		String password = "databaseMySql";
		Connection con = null;
		
		
		try
		{
			con =  DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println(con);
		String query = "INSERT INTO attempt(input, output, dateandtime) VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		Scanner scan = new Scanner(System.in);
		String result ="";
		
		//Scanning the size
		System.out.println("Enter the size of the list:" );
		int size = scan.nextInt();
		String inputString = "";
		//check the condition for size
		if(size<3)
		{
			inputString = "No value availble";
			pstmt.setString(1, inputString);
			result = "No value availble";
			pstmt.setString(2, result);
			System.out.println("Invalid size for the triplates");
		}
		else if(size == 3)
		{
			System.out.println("Enter the values of the list");
			int data[] = new int[size];
			for(int input=0;input<size;input++)
			{
				
				System.out.println(input +"th element: ");
				data[input] = scan.nextInt();
				inputString = inputString + data[input]+ " ";
			}
			
			
			//System.out.println("String is: "+inputString);
			pstmt.setString(1, inputString);
			
			if(data[0] + data[1] + data[2] == 0 && data[0] != data[1] && data[1] != data[2])
			{
				result += "["+ data[0] + ", " +data[1]+", " + data[2]+ "]";
				pstmt.setString(2, result);
				
				System.out.println("Pair is: ["+ data[0] + ", " +data[1]+", " + data[2]+ "]");
			}
			else
			{
				result += "No triplets found for matching condition for the given input";
				pstmt.setString(2, result);
				System.out.println("No triplets found for matching condition for the given input");
			}
		}
		else
		{
			System.out.println("Enter the values of the list");
			int data[] = new int[size];
			
			for(int input=0;input<size;input++)
			{
				System.out.println(input +"th element: ");
				data[input] = scan.nextInt();
				inputString = inputString + data[input]+ " ";
			}
			pstmt.setString(1, inputString);
			
			
			
			
			boolean isResultAvailble = false;
			int triplate_size = 3; //size of triplates
			for(int firstIter=0;firstIter<(size - triplate_size); firstIter++)
			{
				for(int secondIter=firstIter+1; secondIter<((size- triplate_size) + 1); secondIter++)
				{
					if(data[firstIter] == data[secondIter]) //check for unique element
					{
						continue;
					}
					else
					{
						for(int thirdIter=secondIter+1; thirdIter<size; thirdIter++)
						{
							if(data[secondIter] == data[thirdIter]) //check for unique element
							{
								continue;
							}
							else
							{
								if(data[firstIter] + data[secondIter] + data[thirdIter] == 0)
								{
									isResultAvailble = true;
									result += "["+ data[firstIter] + ", " +data[secondIter]+", " + data[thirdIter]+ "]";
									System.out.println("Pair is: ["+ data[firstIter] + ", " +data[secondIter]+", " + data[thirdIter]+ "]");
								}
							}
							
						}
					}
				}
			}
			if(!isResultAvailble)
			{
				result  = "No triplets found for matching condition for the given input";
				pstmt.setString(2, result);
				System.out.println("No triplets found for matching condition for the given input");
			}
			pstmt.setString(2, result);
		}
		Date d = new Date();
		pstmt.setString(3, d.toLocaleString());
		pstmt.executeUpdate();
			
	}
	
}
