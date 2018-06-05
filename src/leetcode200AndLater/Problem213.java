package leetcode200AndLater;

public class Problem213
{
	
	public int rob(int[] nums)
	{
		if(nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		int[] n1=new int[nums.length-1];
		for(int i=0;i<nums.length-1;i++)
			n1[i]=nums[i];
		int max1=rob2(n1);
		for(int i=1;i<nums.length;i++)
			n1[i-1]=nums[i];
		int max2=rob2(n1);
		return max1>max2?max1:max2;
	}
	
	public int rob2(int[] nums)
	{
		int length=nums.length;
        if(length==0)
            return 0;
		if(length==1)
			return nums[0];
		int dp[]=new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(dp[0], nums[1]);
		for(int i=2;i<nums.length;i++)
		{
			dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
		}
		return dp[nums.length-1];
	}
	public static void main(String[] args)
	{
		Problem213 p=new Problem213();
		int nums[]={1,2,3,1};
		System.out.println(p.rob(nums)); 
	}
	
}
