package 牛客网笔试题;

public class 最长公共子序列
{
	public static void main(String[] args)
	{
		String s1="cnblogsaaa";
		String s2="belongaaa";
		System.out.println(f(s1, s2)); 
	}
	
	public static int f(String s1,String s2)
	{//以 i j结尾的子字符串的最长公共子序列
		int m=s1.length();
		int n=s2.length();
		int dp[][]=new int[m+1][n+1];
		StringBuffer b=new StringBuffer();
		String t="";
		int max=0,end1=0,end2=0;
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1]+1;
					b.append(s1.charAt(i-1));
				}
				else
				{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		return dp[m][n]; 
	}
}
