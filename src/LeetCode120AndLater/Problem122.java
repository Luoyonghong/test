package LeetCode120AndLater;

public class Problem122
{
	//[7, 1, 5, 3, 6, 4]
	//[7, 6, 4, 3, 1]
	public int maxProfit(int[] prices)
	{
		int n=prices.length;
		int last=0,i=0;
		int profit=0;
		while(i<n)
		{
			for(;i<n-1;i++)
			{
				if(prices[i]<prices[i+1])
				{
					last=prices[i];
					break;
				}
			}
			//System.out.println(i); 
			i+=1;
			for(;i<n;i++)
			{
				if(i==n-1)
				{
					profit+=prices[i]-last;
					break;
				}
				if(prices[i]>prices[i+1])
				{
					profit+=prices[i]-last;
					break;
				}
			}
			
		}
		return profit;
	}
	public static void main(String[] args)
	{
		int prices[]=//{1,2};
			//{7, 6, 4, 3, 1};
			{7, 1, 5, 3, 6, 4};
		Problem122 p=new Problem122();
		int t=p.maxProfit(prices);
		System.out.println(t);
	}
}
