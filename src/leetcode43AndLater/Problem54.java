package leetcode43AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem54
{
	List<Integer> r;
	public List<Integer> spiralOrder(int[][] matrix)
	{
		r=new ArrayList<Integer>();
		if(matrix.length==0)
			return r;
		int m=matrix.length;
		int n=matrix[0].length;
		for(int i=0;i<(Math.min(n, m)+1)/2;i++)
		{
			
			if(i==m-1-i)
			{
				System.out.println(i); 
				for(int j=i;j<n-i;j++)
					r.add(matrix[i][j]);
				break ;
			}
			if(i==n-1-i)
			{
				System.out.println(i); 
				for(int j=i;j<m-i;j++)
					r.add(matrix[j][i]);
				break ;
			}
			for(int j=i;j<n-i;j++)
			{
				r.add(matrix[i][j]);
			}//上
			if(n-i>i)
				r.remove(r.size()-1);
			for(int j=i;j<m-i;j++)
			{
				r.add(matrix[j][n-1-i]);
			}//右
			if(m-i>i)
				r.remove(r.size()-1);
			for(int j=n-1-i;j>=i;j--)
			{
				r.add(matrix[m-1-i][j]);
			}//下
			if(n-i>i)
				r.remove(r.size()-1);
			for(int j=m-1-i;j>=i;j--)
			{
				r.add(matrix[j][i]);
			}//左
			if(m-i>i)
				r.remove(r.size()-1);
			//System.out.println(r.size()); 
		}
		return r;
	}
	public void func(int n,int [][] matrix)
	{
		
	}
	public static void main(String[] args)
	{
		Problem54 p=new Problem54();
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		//int[][] matrix={{1,2},{3,4}};
		//int[][] matrix={{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
		List<Integer> l=p.spiralOrder(matrix);
		for (Integer integer : l)
		{
			System.out.print(integer+" ");
		}
	}
}
