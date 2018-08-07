package leetcode300AndLater;

public class Problem334 {
	public boolean increasingTriplet(int[] nums) {
		if(nums.length==0)
			return false;
		int max=1;
		int dp[]=new int[nums.length];
		dp[0] =1 ;
		for(int i=1;i<dp.length;i++)
		{
			dp[i]=1;
			for(int j =0;j<i;j++)
				if(nums[j]<nums[i])
				{
					dp[i]=dp[j]+1>dp[i]?dp[j]+1:dp[i];
				}
			max = max<dp[i]?dp[i]:max;
			if(max>=3)
				return true;
		}
		
		return false;
	}
}
