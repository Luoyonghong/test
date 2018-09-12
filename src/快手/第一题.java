package 快手;

import java.util.Scanner;

public class 第一题
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int m =sc.nextInt();
		int nums[]=new int[m];
		int max=0;
		for(int i=0;i<m;i++)
		{
			nums[i]=sc.nextInt();
			if(nums[i]>max)
				max=nums[i];
		}
		long dp[] =new  long [max+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=max;i++)
		{
			int t=1;
			while(i>=t)
			{
				dp[i]=(long) (dp[i]%(10e9+3));
				dp[i]+=dp[i-t];
				dp[i]=(long) (dp[i]%(10e9+3));
				t*=2;
			}
		}
		for(int i=0;i<m;i++)
		{
			System.out.println(dp[nums[i]]); 
		}
	}
}
