package LeetCode120AndLater;

import java.util.HashSet;

public class Problem128
{
	public int longestConsecutive(int[] nums)
	{
		HashSet<Integer> h=new HashSet<>();
		for(int i=0;i<nums.length;i++)
		{
			h.add(nums[i]);
		}
		int pre,next,max=0;
		while(!h.isEmpty())
		{
			for (int i = 0; i < nums.length; i++)
			{
				h.remove(nums[i]);
				pre=nums[i]-1;
				next=nums[i]+1;
				while(h.contains(pre))
				{
					h.remove(pre);
					pre-=1;
				}
				while(h.contains(next))
				{
					h.remove(next);
					next+=1;
				}
				if(next-pre-1>max)
					max=next-pre-1;
			}
		}
		return max;
	}
	public static void main(String[] args)
	{
		Problem128 p=new Problem128();
		int[] nums={100, 4, 200, 1, 3, 2};
		System.out.println(p.longestConsecutive(nums)); 
	}
}
