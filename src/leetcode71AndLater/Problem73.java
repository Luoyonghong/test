package leetcode71AndLater;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Problem73
{
/*
 * 第一行第一列记录剩余行 列是否为0
 */
	public void setZeroes(int[][] matrix)
	{
		boolean line1=false;
		boolean column1=false;
		int m=matrix.length;
		int n=matrix[0].length;
		for(int i=0;i<m;i++)
		{
			if(matrix[i][0]==0)
				column1=true;
			//matrix[i][0]=1;
		}
		for(int i=0;i<n;i++)
		{
			if(matrix[0][i]==0)
				line1=true;
			//matrix[0][i]=1;
		}
		
//		for(int i=0;i<m;i++)
//		{
//			matrix[i][0]=1;
//		}
//		for(int i=0;i<n;i++)
//		{
//			matrix[0][i]=1;
//		}
		
		
		System.out.println("line1: "+line1+" colum1: "+column1); 
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
			{
				if(matrix[i][0]==0||matrix[0][j]==0)
					matrix[i][j]=0;
			}
		for(int i=0;i<m;i++)
			if(column1)
				matrix[i][0]=0;
		for(int i=0;i<n;i++)
			if(line1)
				matrix[0][i]=0;
	}
	public static void main(String[] args)
	{
		Problem73 p=new Problem73();
		int[][] matrix={{0,1}};
		p.setZeroes(matrix);
		for (int[] is : matrix)
		{
			for (int i : is)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
