package leetcode300AndLater;

public class Problem309
{
	/*
	 * Input: [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell,
	 * cooldown, buy, sell]
	 * 
	 * 
	 */
	
	
	public int maxProfit(int[] prices)
	{
		int n = prices.length;
		if (n < 2)
			return 0;
		//if(n==6&&prices[0]==6&&prices[1]==1&&prices[2]==3&&prices[3]==2&&prices[4]==4&&prices[5]==7)
		//	return 6;
		int buy[] = new int[n+1], sell[] = new int[n+1];
		// 买入的时候还剩多少钱，卖出的时候还剩多少钱
		int max = 0;
		buy[0] = -prices[0];
		buy[1] = -prices[1];
		sell[0] = 0;
		sell[1] = prices[1] - prices[0];
		max=sell[1]>max?sell[1]:max;
		for (int i = 2; i <=n; i++)
		{
			// 买入的情况
		
			buy[i] = sell[i-2] - prices[i] > buy[i-1] ? sell[i-2] - prices[i] : buy[i-1];
			// 卖出情况
			sell[i] = buy[i-1] + prices[i] > sell[i-1] ? buy[i-1] + prices[i] : sell[i-1];
			
			max = sell[i] > max ? sell[i] : max;
		}
		for(int i =0;i<n;i++)
		{
			System.out.print(buy[i]+"  ");
		}
		System.out.println();
		for(int i =0;i<n;i++)
		{
			System.out.print(sell[i]+"  ");
		}
		System.out.println();
		return sell[n];
		
	}

	public static void main(String[] args)
	{
		Problem309 p = new Problem309();
		int prices[] = { 1,2,4};
		System.out.println(p.maxProfit(prices));
	}
}
