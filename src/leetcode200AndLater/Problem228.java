package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem228
{
	/*
	 *  Input:  [0,2,3,4,6,8,9]
		Output: ["0","2->4","6","8->9"]
		Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
	 */
	
	public List<String> summaryRanges(int[] nums)
	{
		List<String> l=new ArrayList<String>();
		if(nums.length==0)
			return l;
		int start=nums[0];
		int end=start;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]==end+1)
			{
				end=nums[i];
			}
			else
			{
				if(start==end)
					l.add(start+"");
				else
					l.add(start+"->"+end);
				start=nums[i];
				end=nums[i];
			}
		}
		if(start==end)
			l.add(start+"");
		else
			l.add(start+"->"+end);
		return l;
	}
	public static void main(String[] args)
	{
		Problem228 p=new Problem228();
		int nums[]={0,2,3,4,6,8,9};
		System.out.println(p.summaryRanges(nums)); 
	}
}
