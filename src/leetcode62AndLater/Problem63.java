package leetcode62AndLater;

import javax.jws.Oneway;

public class Problem63
{

	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		int m=obstacleGrid.length;
		int n=obstacleGrid[0].length;
		int[][] sum=new int[m][n];
		for(int i=0;i<m;i++)
		{
			sum[i][0]=1;
			if(obstacleGrid[i][0]==1)
			{
				sum[i][0]=0;
				break;
			}
		}
		for(int i=0;i<n;i++)
		{
			sum[0][i]=1;
			if(obstacleGrid[0][i]==1)
			{
				sum[0][i]=0;
				break;
			}
		}
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
			{
				if(obstacleGrid[i][j]!=1)
					sum[i][j]=sum[i-1][j]+sum[i][j-1];
			}
		
		return sum[m-1][n-1];
	}
}
