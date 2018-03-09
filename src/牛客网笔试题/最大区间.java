package 牛客网笔试题;

import java.util.Scanner;

public class 最大区间
{
	/*
	 * dp[i][j] 区间的开始和结束
	 * start 0 end n-1
	 * 首先从右边开始减少，若num[end]>min,end--，直到Num[end]==min
	 * 左边也是一样的 
	 */
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int num[]=new int[n];
		for(int i=0;i<n;i++)
		{
			num[i]=scan.nextInt();
		}
		int start=0,end=n-1;
		int min=num[0];
		int sum=num[0];
		int result=min*min;
		while(start<end)
		{
			
		}
	}
}
