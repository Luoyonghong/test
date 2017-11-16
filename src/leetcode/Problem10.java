package leetcode;

public class Problem10
{
	/*
	 * 
	1.  P[i][j] = P[i - 1][j - 1], if p[j - 1] != '*' && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
	2.  P[i][j] = P[i][j - 2], if p[j - 1] == '*' and the pattern repeats for 0 times;
	3.  P[i][j] = P[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.'), if p[j - 1] == '*' and the pattern repeats for at least 1 times.
	 * 
	 * 
	 */
	
	
	public static boolean isMatch(String s, String p)
	{
//		if(s.length()==0||s==null)
//			return true;
//		if(p.length()==0||p==null)
//			return false;
//		if(p.compareTo(".*")==0)
//			return true;
		
		boolean dp[][]=new boolean[s.length()+1][p.length()+1];
		dp[0][0]=true;
		int m=s.length();
		int n=p.length();
		for (int i = 0; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) 
			{
				if (j > 1 && p.charAt(j - 1) == '*') 
				{
					dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
	            }
				else 
	            {
	            	dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
	            }
	        }
	    }
	    return dp[m][n];
	}
	public static void main(String[] args)
	{
		System.out.println(isMatch("",".")); 
	}

}
