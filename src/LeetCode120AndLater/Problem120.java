package LeetCode120AndLater;

import java.util.List;

public class Problem120
{
	/*
	 * 
	 *     [
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
	 * 
	 */
	public int minimumTotal(List<List<Integer>> triangle)
	{
		int n=triangle.size();
		int[] r=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			if(i==n-1)
			{
				List<Integer> nowlist=triangle.get(i);
				for(int j=0;j<nowlist.size();j++)
				{
					r[j]=nowlist.get(j);
				}
			}
			else
			{
				List<Integer> nowlist=triangle.get(i);
				for(int j=0;j<nowlist.size();j++)
				{
					r[j]=Math.min(nowlist.get(j)+r[j],nowlist.get(j)+r[j+1]);
				}
			}
		}
		return r[0];
	}
	
	public int minimumTotal2(List<List<Integer>> triangle)
	{
		int n=triangle.size();
		return f(triangle,n,0,n);
	}
	
	public int f(List<List<Integer>> triangle,int n,int po,int max)
	{
		if(n==1)
		{
			return triangle.get(max-n).get(po);
		}
		int t=triangle.get(max-n).get(po);
		return Math.min(f(triangle, n-1, po,max)+t, f(triangle, n-1, po+1,max)+t); 
	}
}
