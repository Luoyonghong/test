package 头条;

import java.util.Scanner;

public class 抖音红人
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int guanzhu[][]=new int[m][2];
		for(int i=0;i<n;i++)
		{
			guanzhu[i][0]=sc.nextInt();
			guanzhu[i][1]=sc.nextInt();
		}
		if(n==1)
			System.out.println(1); 
	}
}
