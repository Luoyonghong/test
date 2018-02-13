package LeetCode120AndLater;

public class Problem121
{
	public int maxProfit(int[] prices)
	{
		int n = prices.length;
		if (n == 0)
			return 0;
		int r = 0;
		int min = prices[0];
		for (int i = 0; i < n; i++)
		{
			if (prices[i] < min)
				min = prices[i];
			else
			{
				int t = prices[i] - min;
				r = t > r ? t : r;
			}
		}
		return r;
	}

}
