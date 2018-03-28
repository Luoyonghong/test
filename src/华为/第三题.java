package 华为;

import java.util.Scanner;

public class 第三题
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] ns=s.split(",");
		int nums[]=new int[ns.length];
		for(int i=0;i<nums.length;i++)
			nums[i]=Integer.parseInt(ns[i].trim());
		
		int dp[]=new int[nums.length];
		dp[0]=nums[0];
		int max=Integer.MIN_VALUE;
		for(int i=1;i<nums.length;i++)
		{
			dp[i]=dp[i-1]+nums[i]>nums[i]?dp[i-1]+nums[i]:nums[i];
			max=dp[i]>max?dp[i]:max;
		}
		System.out.println(max); 
	}
}
