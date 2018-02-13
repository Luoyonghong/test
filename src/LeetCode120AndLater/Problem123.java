package LeetCode120AndLater;

import java.util.Arrays;

public class Problem123
{
	//[7, 1, 5, 3, 6, 4]
	//[7, 6, 4, 3, 1]
	public int maxProfit(int[] prices)
	{
		int n=prices.length;
		int max=maxProfitLocal(prices);
		int i=0;
		for(;i<n-1;i++)
		{
			if(prices[i]<prices[i+1])
				break;
		}
		i+=1;
		while(i<n)
		{
			for(;i<n;i++)
			{
				if(prices[i]<prices[i-1])
				{
					int[] p1=Arrays.copyOfRange(prices, 0, i);
					int[] p2=Arrays.copyOfRange(prices, i, n);
					int m1=maxProfitLocal(p1);
					int m2=maxProfitLocal(p2);
					if(m1+m2>max)
						max=m1+m2;
				}
			}
		}
			
		return max;
	}
	
	public int maxProfitLocal(int[] prices)
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
	public static void main(String[] args)
	{
		int[] prices={1,2,4};
		Problem123 p=new Problem123();
		System.out.println(p.maxProfit(prices));
	}
}
