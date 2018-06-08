package leetcode200AndLater;

public class Problem221
{
	public int maximalSquare(char[][] matrix)
	{
		int m=matrix.length,n=0;
		if(m>0)
			n=matrix[0].length;
		else
			return 0;
		int dp[][]=new int[m+1][n+1];
        int max=0;
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
			{
				if(matrix[i-1][j-1]=='1')
					dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
				else
					dp[i][j]=0;
                max=dp[i][j]>max?dp[i][j]:max;
			}
		return max*max;

	}
}
