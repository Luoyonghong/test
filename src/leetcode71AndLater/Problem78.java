package leetcode71AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem78
{
	List<List<Integer>> r=new ArrayList<List<Integer>>();
	public List<List<Integer>> subsets(int[] nums)
	{
		boolean [] used=new boolean[nums.length];
		List<Integer> t=new ArrayList<Integer>();
		
		func(t, used, nums.length, nums.length, 0,0,nums); 
		return r;
	}
	
	public void func(List<Integer> t, boolean[] used,int n,int k,int nowLayer,int lastValue,int nums[])
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
		
		r.add(new ArrayList<Integer>(t));
		if(nowLayer==k)
		{
			return;
		}
		for(int i=lastValue;i<n;i++)
		{
//			if(k>1&&i==n-1&&nowLayer==0)
//				continue;
//			if(i+1<nowLayer)
//				continue;
			if(!used[i])
			{
				t.add(nums[i]);
				used[i]=true;
				
				func(t, used, n, k, nowLayer+1,i,nums); 
				used[i]=false;
				t.remove(t.size()-1); 
			}
		}
	}
	public static void main(String[] args)
	{
		Problem78 p=new Problem78();
		List<List<Integer>> l=p.subsets(new int[]{1});
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
