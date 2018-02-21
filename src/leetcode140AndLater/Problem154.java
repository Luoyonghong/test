package leetcode140AndLater;

public class Problem154
{
	public int findMin(int[] nums)
	{
		return Math.min(f(nums, 0, nums.length/2),f(nums, nums.length/2, nums.length-1));
	}
	
	public int f(int [] nums, int begin, int end)
	{
		if(begin==end)
			return nums[begin];
		if(begin+1==end)
			return Math.min(nums[begin], nums[end]);
		if(nums[begin]<nums[end])
			return nums[begin];
		
		else
		{
			int mid=(begin+end)/2;
			return Math.min(f(nums, begin, mid), f(nums, mid, end)); 
		}
	}
}
