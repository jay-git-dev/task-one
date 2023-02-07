package com.interview.task;

import java.util.Scanner;

public class TaskOne 
{
	public static void main(String[] args) 
	{
		
		//find the tripalets which means some of the elemnts should be zero and also all elements are distinct
		
		//here mask value is 3 for the triplates
		// 1, 0, 1 -2 ,3, -4
		Scanner scan = new Scanner(System.in);
		
		//Scanning the size
		System.out.println("Enter the size of the list:" );
		int size = scan.nextInt();
		
		//check the condition for size
		if(size<3)
		{
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
			}
			if(data[0] + data[1] + data[2] == 0 && data[0] != data[1] && data[1] != data[2])
			{
				System.out.println("Pair is: ["+ data[0] + ", " +data[1]+", " + data[2]+ "]");
			}
			else
			{
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
			}
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
									System.out.println("Pair is: ["+ data[firstIter] + ", " +data[secondIter]+", " + data[thirdIter]+ "]");
								}
							}
							
						}
					}
				}
			}
			if(!isResultAvailble)
			{
				System.out.println("No triplets found for matching condition for the given input");
			}
		}

		
	}
	
}
