package leetcode162AndLater;

public class Problem198
{
	
	public int rob(int[] nums)
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
}
