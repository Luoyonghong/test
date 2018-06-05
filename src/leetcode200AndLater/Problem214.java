package leetcode200AndLater;

public class Problem214
{
	public String shortestPalindrome(String s)
	{
		int length=s.length();
		if(length==0)
			return "";
		boolean dp[][]=new boolean[length][length];
		for(int i=0;i<length;i++)
			for(int j=i;j>=0;j--)
			{
				if(i-j==0)
					dp[j][i]=true;
				if(i-j==1)
					dp[j][i]=s.charAt(i)==s.charAt(j);
				if(i-j>1)
					dp[j][i]=(s.charAt(i)==s.charAt(j)&&dp[j-1][i-1]);
			}
		int max=0;
		for(int i=length-1;i>=0;i--)
		{
			if(dp[0][i]==true)
			{
				max=i;
				break;
			}
		}
		String sub=s.substring(max+1);
		StringBuilder b=new StringBuilder(sub);
		return b.reverse().toString()+s;
	}
}
