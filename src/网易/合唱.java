package 网易;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 合唱
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int nums[] =new int[n];
		HashSet<Integer> set=new HashSet<>();
		for(int i =0;i<n;i++)
		{
			nums[i]=sc.nextInt();
			set.add(nums[i]);
		}
		if(set.size()==1||set.size()==2)
		{
			System.out.println("0");
			return;
		}
		int dp[] =new int[n];
		dp[0]=0;
		dp[1]=0;
		int last1 = nums[0];
		int last2 = nums[1];
		for(int i=2;i<n;i++)
		{
			int cha1=Math.abs(nums[i]-last1);
			int cha2=Math.abs(nums[i]-last2);
			if(cha1>cha2)
			{
				dp[i]=dp[i-1]+cha2;
				last2=nums[i];
			}
			else
			{
				dp[i]=dp[i-1]+cha1;
				last1=nums[i];
			}
			//System.out.println(nums[i]+"  "+dp[i]); 
		}
		//for(int i=0;i<n;i++)
		System.out.println(dp[n-1]);
	}
}
