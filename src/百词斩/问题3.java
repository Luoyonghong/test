package 百词斩;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 问题3
{
	static List<Integer> l=new ArrayList<>();
	static int index=0;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int num[]=new int[n];
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
//		if(n==3)
//	        {
//	            System.out.println("159"); 
//	            System.out.println("195"); 
//	            System.out.println("519"); 
//	            System.out.println("591"); 
//	            System.out.println("915"); 
//	            System.out.println("951"); 
//	        }
		permute(num, 0);
		Collections.sort(l);
		for (int i : l)
		{
			System.out.println(i); 
		}
	}
	public static void permute(int[] array, int start)
	{
		if (start == array.length)
		{ 
			String t="";
			for (int i : array)
			{
				t+=i;
			}
			l.add(Integer.parseInt(t));
			index++;
		} else
			for (int i = start; i < array.length; ++i)
			{
				swap(array, start, i); 
				permute(array, start + 1); 
				swap(array, start, i); 
			}
	}

	private static void swap(int[] array, int s, int i)
	{
		int t = array[s];
		array[s] = array[i];
		array[i] = t;
	}

	

}
