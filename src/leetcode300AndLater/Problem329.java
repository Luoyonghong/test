package leetcode300AndLater;

public class Problem329
{
	public int longestIncreasingPath(int[][] matrix)
	{
		int m=matrix.length;
		if(m==0)
			return 0;
		int n =matrix[0].length;
		if(n==0)
			return 0;
		int result[][] =new int[m][n];
		boolean isupdate=true;
		while(isupdate)
		{
			isupdate=false;
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
				{
					if(isbigger(matrix, i, j, i+1, j, m, n) )
					{
						if(result[i+1][j] + 1>result[i][j])
						{
							isupdate=true;
							result[i][j] = result[i+1][j] + 1;
						}
					}
					if(isbigger(matrix, i, j, i-1, j, m, n) )
					{
						if(result[i-1][j] + 1>result[i][j])
						{
							isupdate=true;
							result[i][j] = result[i-1][j] + 1;
						}
					}
					if(isbigger(matrix, i, j, i, j+1, m, n) )
					{
						if(result[i][j+1] + 1>result[i][j])
						{
							isupdate=true;
							result[i][j] = result[i][j+1] + 1;
						}
					}
					if(isbigger(matrix, i, j, i, j-1, m, n) )
					{
						if(result[i][j-1] + 1>result[i][j])
						{
							isupdate=true;
							result[i][j] = result[i][j-1] + 1;
						}
					}
				}
		}
		int max=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				//System.out.print(result[i][j]+" ");
				if(max<result[i][j])
					max=result[i][j];
			}
			//System.out.println(); 
		}
		return max + 1;

	}
	public boolean isbigger(int[][]  matrix, int i, int j, int i2,int j2, int m,int n)
	{
		if(i2>=m||j2>=n||i2<0||j2<0)
			return false;
		if(matrix[i][j]>matrix[i2][j2])
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		Problem329 p=new Problem329();
		int[][] matrix={{3,4,5},{3,2,6},{2,2,1}};
		System.out.println(p.longestIncreasingPath(matrix)); 
	}
}
