package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem216
{
	boolean used[]=new boolean[9];
	List<List<Integer>> l=new ArrayList<List<Integer>>();
	List<Integer> t=new ArrayList<Integer>();
	public List<List<Integer>> combinationSum3(int k, int n)
	{
		if(n>45||n<1)
			return new ArrayList<List<Integer>>();
		help(k,n,0);
		return l;
	}
	public void help(int k, int n, int last )
	{
		if(k<0||n<0)
			return;
		if(k==0&&n==0)
		{
			l.add(new ArrayList<Integer>(t));
			return;
		}
		for(int i=last+1;i<=9;i++)
		{
			if(!used[i-1])
			{
				t.add(i);
				used[i-1]=true;
				help(k-1,n-i,i);
				t.remove(t.size()-1);
				used[i-1]=false;
			}
		}
	}
	public static void main(String[] args)
	{
		Problem216 p=new Problem216();
		List<List<Integer>> l= p.combinationSum3(3, 9);
		for (List<Integer> list : l)
		{
			for (Integer integer : list)
			{
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
}
