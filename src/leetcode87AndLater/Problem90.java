package leetcode87AndLater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90
{
	List<List<Integer>> l=new ArrayList<List<Integer>>();
	
	public List<List<Integer>> subsetsWithDup(int[] nums)
	{
		Arrays.sort(nums);
		boolean used[]=new boolean[nums.length];
		List<Integer> r=new ArrayList<Integer>();
		func(used, nums, r,-1); 
		return l;
	}
	public void func(boolean [] used,int [] nums,List<Integer> r,int index)
	{
		l.add(new ArrayList<Integer>(r));
		for(int i=index+1;i<nums.length;i++)
		{
//			if(i>0&&nums[i]==nums[i-1])
//				continue;
			if(!used[i])
			{
				r.add(nums[i]);
				used[i]=true;
				func(used, nums, r,i);
				used[i]=false;
				r.remove(r.size()-1);
			}
			while(i<nums.length-1&&nums[i]==nums[i+1]) i++;//先执行一遍再跳过，如果先跳过的话，则不全，比如说122就没了
		}
	}
	public static void main(String[] args)
	{
		Problem90 p=new Problem90();
		p.subsetsWithDup(new int[]{1,2,2,2});
		for (List<Integer> list : p.l)
		{
			for (Integer integer : list)
			{
				System.out.print(integer);
			}
			System.out.println();
		}
		
	}
	
}
