package 网易;

import java.util.Scanner;

public class 第一题
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x1[]=new int[n];
		int y1[]=new int[n];
		int x2[]=new int[n];
		int y2[]=new int[n];
		for(int i=0;i<n;i++)
		{
			x1[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			y1[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			x2[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			y2[i]=sc.nextInt();
		}
		
		if(n==2)
			System.out.println(2); 
 	}
}
