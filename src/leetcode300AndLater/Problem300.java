package leetcode300AndLater;

public class Problem300 {
	public int lengthOfLIS(int[] nums) {
		if(nums.length==0)
			return 0;
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
		}
		return max; 
	}

	public static void main(String[] args) {
		int nums[] = {10,9,2,5,3,7,101,18};
		Problem300 p =new Problem300();
		System.out.println(p.lengthOfLIS(nums)); 
		System.out.println("haha");
	}
}
