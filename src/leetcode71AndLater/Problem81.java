package leetcode71AndLater;

public class Problem81
{
	public boolean search(int[] nums, int target)
	{
		int n=nums.length;
		return func(nums, target, 0, nums.length-1,n);
	}
	public boolean func(int[] nums,int target, int begin ,int end,int n)
	{
		System.out.println("begin: "+begin+" end: "+end); 
		if(end>=n||begin<0||end<0||begin>=n)
			return false;
		if(begin==end||(nums[begin]==nums[end])&&begin+1==end)
			return target==nums[end];
		if(begin+1==end&&(target!=nums[begin]&&nums[end]!=target))
			return false;
		int middel=(begin+end)/2;
		if(target==nums[middel]||target==nums[begin]||target==nums[end])
			return true;
		if(nums[begin]<nums[middel])
		{
			if(target<nums[middel]&&target>=nums[begin])
				return func(nums, target, begin, middel,n);
			else
				return func(nums, target, middel, end,n);
		}
		else if(nums[middel]<nums[end])
		{
			if(target<=nums[end]&&target>nums[middel])
				return func(nums, target, middel+1, end,n);
			else
				return func(nums, target, begin, middel-1,n);
		}
		else
		{
			if(func(nums, target, middel, end,n)||func(nums, target, begin, middel,n))
				return true;
			else
				return false;
		}
	}
	public static void main(String[] args)
	{
		int nums[]={3,1};
		Problem81 p=new Problem81();
		System.out.println(p.search(nums, 2));
	}
}
