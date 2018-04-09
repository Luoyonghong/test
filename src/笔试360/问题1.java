package 笔试360;

import java.util.Scanner;

public class 问题1
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int nums[][]=new int[n][5];
		for(int i=0;i<n;i++)
			for(int j=0;j<5;j++)
				nums[i][j]=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=0;j<5;j++)
			{
				sum+=nums[i][j];
			}
			if(sum%5==0)
				System.out.println(sum/5);
			else
				System.out.println(-1); 
		}
	}
}
