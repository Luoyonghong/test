package 牛客网笔试题;

import java.util.Scanner;

public class 构造回文
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		String s;
		while(scan.hasNext())
		{
			s=scan.nextLine();
			int [][] dp=new int[s.length()][s.length()];
			int max=1;
			for(int i=s.length()-1;i>=0;i--)
				for(int j=i;j<s.length();j++)
				{
					if(i==j)
					{
						dp[i][j]=1;
						continue;
					}
					if(j==i+1)
					{
						if(s.charAt(i)==s.charAt(j))
						{
							dp[i][j]=2;
							continue;
						}
						else
						{
							dp[i][j]=1;
							continue;
						}
					}
					
					if(j>i+1&&s.charAt(i)==s.charAt(j))
					{
						dp[i][j]=dp[i+1][j-1]+2;
						if(dp[i][j]>max)
							max=dp[i][j];
						continue;
					}
					if(j>i&&s.charAt(i)!=s.charAt(j))
					{
						dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
						//if(dp[i][j]>max)
						//	max=dp[i][j];
						continue;
					}
					
				}
			System.out.println(s.length()-max); 
		}
	}
}
