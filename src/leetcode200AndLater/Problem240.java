package leetcode200AndLater;

public class Problem240
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		
		int i=0;
		if(matrix.length==0)
            return false;
		int j=matrix[0].length-1;
		while(i<matrix.length&&j>=0)
		{
			if(matrix[i][j]==target)
				return true;
			while(i<matrix.length&&j>=0&&matrix[i][j]>target)
				j--;
			while(i<matrix.length&&j>=0&&matrix[i][j]<target)
				i++;
		}
		return false;
	}
	public static void main(String[] args)
	{
		Problem240 p=new Problem240();
		int [][] matrix={
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}
		                };
		System.out.println(p.searchMatrix(matrix, 13));
	}
	public boolean help(int[][] matrix, int target, int i, int j)
	{
		return true;
	}
}
