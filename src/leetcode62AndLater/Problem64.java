package leetcode62AndLater;

public class Problem64
{

	public int minPathSum(int[][] grid)
	{
		int m=grid.length,n=grid[0].length;
		int sum[][]=new int[grid.length][grid[0].length];
		sum[0][0]=grid[0][0];
		for(int i=1;i<m;i++)
		{
			sum[i][0]=sum[i-1][0]+grid[i][0];
		}
		for(int i=1;i<n;i++)
		{
			sum[0][i]=sum[0][i-1]+grid[0][i];
		}
		
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
			{
				sum[i][j]=Math.min(sum[i-1][j]+grid[i][j], sum[i][j-1]+grid[i][j]);
			}
		
		return sum[m-1][n-1];

	}

	public static void main(String[] args)
	{
		Problem64 p=new Problem64();
		//System.out.println(p.);
	}
}
