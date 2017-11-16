package leetcode;

import java.util.Arrays;

public class Problem16
{
	public static int  threeSumClosest(int[] nums, int target)
	{
		Arrays.sort(nums);
		double minsum=Integer.MAX_VALUE+1;
		for(int i=0;i<nums.length;i++)
		{
			int begin=i+1;
			int end=nums.length-1;
			while(begin<end)
			{
				
				int sum=nums[i]+nums[begin]+nums[end];
				if(sum==target)
					return sum;
				if(Math.abs(sum-target)<Math.abs(minsum-target))
					minsum=sum;
				if(sum<target)
					begin++;
				if(sum>target)
					end--;
//				while(begin>0&&begin<end&&nums[begin]==nums[begin-1])
//					begin++;
//				while(end<nums.length-1&&begin<end&&nums[end]==nums[end+1])
//					end--;
				
			}
		}
		return (int)minsum;
	}
	public static void main(String[] args)
	{
		int[] a={1,1,-1,-1,3};
		System.out.println(threeSumClosest(a,-1)); 
		
	}
}
