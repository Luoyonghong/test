package leetcode33AndLarger;

import java.util.ArrayList;
import java.util.List;

public class Problem39
{
	/*
	 * t可以用数组替换，数组最长为target长度，并用一个变量记录当前用了几个数字，然后把数组拷贝到result中
	 * 数组的置0比list的删除快
	 * 
	 */
	
	List<List <Integer>> result=new ArrayList<List<Integer>>();
	List<Integer> t=new ArrayList<Integer>();
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		func(candidates,target,0);
		return result;
	}
	
	public boolean func(int[] candidates, int target,int lastIndex)
	{
		if(target<0)
			return false;
		if(target==0)
		{
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(t);
			result.add(x); 
			return true;
		}
		for(int i=lastIndex;i<candidates.length;i++)
		{
			t.add(candidates[i]);
			if(func(candidates,target-candidates[i],i))
			{
//				List<Integer> x=new ArrayList<Integer>();
//				x.addAll(t);
//				result.add(x); 
			}
			t.remove(t.size()-1);
		
			
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
		Problem39 p=new Problem39();
		int[] candidates={2,3,6,7};
		p.combinationSum(candidates, 7);
		for (List<Integer> t : p.result)
		{
			for (Integer i : t)
			{
				System.out.print(i+"  ");
			}
			System.out.println(); 
		}
	}

}
