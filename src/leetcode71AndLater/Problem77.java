package leetcode71AndLater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem77
{
	List<List<Integer>> r=new ArrayList<List<Integer>>();

	public List<List<Integer>> combine(int n, int k)
	{
		
		boolean [] used=new boolean[n];
		int [] t=new int[k];
		
		func(t, used, n, k, 0,0); 
		return r;
	}
	
	public void func(int[]t, boolean[] used,int n,int k,int nowLayer,int lastValue)
	{
//		System.out.println("n: "+n+" k: "+k); 
//		for (boolean b : used)
//		{
//			System.out.print(b+" ");
//		}
//		System.out.println();
//		
//		for (int b : t)
//		{
//			System.out.print(b+" ");
//		}
//		System.out.println();
		
		if(nowLayer==k)
		{
			List<Integer> l = new ArrayList<Integer>(k);
			for (Integer integer : t)
			{
				l.add(integer);
			}
			r.add(l);
			return;
		}
		for(int i=lastValue;i<n;i++)
		{
			if(k>1&&i==n-1&&nowLayer==0)
				continue;
//			if(i+1<nowLayer)
//				continue;
			if(!used[i])
			{
				t[nowLayer]=(Integer)(i+1);
				used[i]=true;
				
				func(t, used, n, k, nowLayer+1,i); 
				used[i]=false;
				t[nowLayer]=0;
			}
		}
	}
	public static void main(String[] args)
	{
		Problem77 p=new Problem77();
		List<List<Integer>> l=p.combine(4,2);
		for (List<Integer> list : l)
		{
			for (Integer i : list)
			{
				System.out.print(i+" ");
			}
			System.out.println(); 
		}
	}

}
