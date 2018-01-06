package leetcode71AndLater;

public class Problem74
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		int m=matrix.length,n=0;
		if(m>0)
			n=matrix[0].length;
		
		if(m==0)
			return false;
		if(m==1)
		{
			for(int i=0;i<n;i++)
				if(matrix[0][i]==target)
					return true;
			return false;
		}
		for(int i=1;i<m;i++)
		{
			if(matrix[i][0]>target&&matrix[i-1][0]<=target)
			{
				for(int j=0;j<n;j++)
					if(matrix[i-1][j]==target)
						return true;
				return false;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(matrix[m-1][i]==target)
				return true;
		}
		
		return false;
	}
	public static void main(String[] args)
	{
		Problem74 p=new Problem74();
		int[][] matrix={};
		System.out.println(p.searchMatrix(matrix,0)); 
	}
}
