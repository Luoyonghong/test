package leetcode33AndLarger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem40
{
	/*
	 * hashset<List<Integer>> 放入{1,2,3}和{1,2,3}
	 * 结果只会存入一个
	 */
	
	Set<List <Integer>> result=new HashSet<List<Integer>>();
	List<Integer> t=new ArrayList<Integer>();
	boolean isFirst=false;
	public List<List<Integer>> combinationSum2(int[] candidates, int target)
	{
		Arrays.sort(candidates); 
//		for (int i : candidates)
//		{
//			System.out.print(i+" ");
//		}
//		System.out.println();
		func(candidates,target,-1);
		return new ArrayList<List<Integer>>(result);
	}
	
	public boolean func(int[] candidates, int target,int lastIndex)
	{
		//System.out.println("target: "+target+" lastIndex: "+lastIndex); 
		if(target<0)
			return false;
		if(target==0)
			return true;
		for(int i=lastIndex+1;i<candidates.length;i++)
		{
//			if(!isFirst&&lastIndex+1>0&&candidates[lastIndex]==candidates[lastIndex+1])
//			{
//				isFirst=true;
//				t.add(candidates[i]);
//				if(func(candidates,target-candidates[i],i))
//				{
//					List<Integer> x=new ArrayList<Integer>();
//					x.addAll(t);
//					result.add(x); 
//					t.remove(t.size()-1);
//				}
//				else
//				{
//					t.remove(t.size()-1);
//				}
//			}
//			
//			if(isFirst&&lastIndex+1>0&&candidates[lastIndex]==candidates[lastIndex+1])
//			{
//				continue;
//			}
			
			//if(i!=lastIndex+1&&candidates[lastIndex+1]!=candidates[lastIndex+2])
			//	continue;
			t.add(candidates[i]);
			if(func(candidates,target-candidates[i],i))
			{
				List<Integer> x=new ArrayList<Integer>();
				x.addAll(t);
				result.add(x); 
				t.remove(t.size()-1);
			}
			else
			{
				t.remove(t.size()-1);
			}
			
			
		}
		return false;
	}
	
	public List<Integer> copy(List<Integer> a )
	{
		List<Integer> r=new ArrayList<Integer>();
		for (Integer i : a)
		{
			r.add(i);
		}
		return r;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		Problem40 p=new Problem40();
		int[] candidates={1,1,1};
		//int[] candidates={1,1,1};
		p.combinationSum2(candidates, 1);
		for (List<Integer> t : p.result)
		{
			for (Integer i : t)
			{
				System.out.print(i+"  ");
			}
			System.out.println(); 
		}
		
		
		
//		Set<List<Integer>> set = new HashSet<List<Integer>>();
//		List<Integer> l1=new ArrayList<Integer>();
//		List<Integer> l2=new ArrayList<Integer>();
//		l1.add(1);
//		l1.add(2);
//		l1.add(3);
//		l2.add(1);
//		l2.add(2);
//		l2.add(3);
//		set.add(l1);
//		set.add(l2);
//		for (List<Integer> l : set)
//		{
//			for (Integer i : l)
//			{
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
	}

}
