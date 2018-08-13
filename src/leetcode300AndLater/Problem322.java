package leetcode300AndLater;

public class Problem322
{
	public int coinChange(int[] coins, int amount)
	{
		int n=amount;
		if(n==0)
			return 0;
		int[] dp=new int[n+1];
		for(int i=0;i<coins.length;i++)
		if(coins[i]<=n)
			dp[coins[i]]=1;
		
		for(int i=0;i<=n;i++)
		{
			if(dp[i]==0)
				dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<coins.length;j++)
				if(i-coins[j]>0&&dp[i-coins[j]]!=Integer.MAX_VALUE)
					dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
		}
		if(dp[n]==Integer.MAX_VALUE)
			return -1;
		return dp[n];
	}
	public static void main(String[] args)
	{
		Problem322 p=new Problem322();
		int[] coins={1};
		System.out.println(p.coinChange(coins, 1)); 
		System.out.println(Integer.MAX_VALUE); 
	}
}
