package 快手;

import java.util.Arrays;
import java.util.Scanner;

public class 第二题
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int nums[]=new int[n];
		int sum[]=new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i]=sc.nextInt();
			if(i>0)
				sum[i]=sum[i-1]+nums[i];
		}
		//dp[i][j]代表打了以i结尾的菜且打了j次的最大和
		Arrays.sort(nums);
		int t=0;
		for(int i=m;i>0;i--)
		{
			t+=nums[i];
		}
		System.out.println(t); 
//		if(m==1)
//		{
//			int t=nums[0];
//			int tt=nums[0];
//			for(int i=1;i<n;i++)
//				if(t+nums[i]>nums[i])
//				{
//					t+=nums[i];
//					if(tt<t)
//						tt=t;
//				}
//			System.out.println(tt);
//			return;
//		}
//		
//		if(m==2)
//		{
//			int t=nums[0];
//			int index=0;
//			int tt=nums[0];
//			for(int i=1;i<n;i++)
//				if(t+nums[i]>nums[i])
//				{
//					t+=nums[i];
//					if(tt<t)
//					{
//						tt=t;
//						index=i;
//					}
//				}
//			for(int i=index+1;i<n;i++)
//				tt=Math.max(tt, tt+nums[i]);
//			System.out.println(tt);
//			return;
//		}
		
//		
//		int dp[][]=new int[n][m+1];
//		int max=0;
//		int help[][]=new int[n][n];//代表i~j之间，以j结尾的最大和,不包括i
//		for(int i=n-2;i>=0;i--)
//			for(int j=i+1;j<n;j++)
//			{
//				help[i][j]=Math.max(help[i+1][j],sum[j]-sum[i]);
//			}
//		
//		
//		for(int i=0;i<n;i++)
//		{
//			for(int j=1;j<=m;j++)
//			{
//				dp[i][j]=dp[i][j-1];
//				for(int k=0;k<i;k++)
//					dp[i][j]=Math.max(dp[i][j], dp[k][j-1]+help[k][i]);
//				if(max<dp[i][j])
//					max=dp[i][j];
//			}
//		}
//		System.out.println(max+1); 
	}
}
