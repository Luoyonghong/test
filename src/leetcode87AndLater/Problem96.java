package leetcode87AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem96
{
	public int numTrees(int n)
	{
		//return func(1, n);
		int[] r=new int[n+1];
		
		r[0]=1;
		r[1]=1;
		
		for(int i=1;i<=n;i++)
		{
			int d=0;
			
			for(int j=1;j<=i;j++)
				d+=r[j-1]*r[i-j];
			r[i]=d;
		}
		
		return r[n];
	}
	
	public int func(int begin, int end)
	{
		//List<TreeNode> r=new ArrayList<TreeNode>();
		int r=0;
		if(end<=begin)
		{
			return 1;
		}
		for(int i=begin;i<=end;i++)
		{
			int l1=func(begin, i-1);
			int l2=func(i+1, end);
			r+=l1*l2;
		}
		return r;
	}
	public static void main(String[] args)
	{
		Problem96 p=new Problem96();
		System.out.println(p.numTrees(4));
	}
}
