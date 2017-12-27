package leetcode43AndLater;

public class Problem53
{
	public int maxSubArray(int[] nums)
	{
		int max[]=new int[nums.length];
		max[0]=nums[0];
		int maxSum=nums[0];
		for(int i=1;i<nums.length;i++)
		{
			if(max[i-1]>0)
				max[i]=max[i-1]+nums[i];
			else
				max[i]=nums[i];
			if(max[i]>maxSum)
				maxSum=max[i];
		}
		return maxSum;
	}
	public static void main(String[] args)
	{
		Problem53 p=new Problem53();
		int nums[]={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(p.maxSubArray(nums));
	}
}
