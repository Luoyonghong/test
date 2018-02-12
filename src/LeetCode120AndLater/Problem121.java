package LeetCode120AndLater;

public class Problem121
{
	public int maxProfit(int[] prices)
	{
		int n=prices.length;
		int mins[]=new int[n],maxs[]=new int[n];
		for(int i=0;i<n;i++)
		{
			if(i==0)
				mins[0]=prices[0];
			else
			{
				if(prices[i]<mins[i-1])
					mins[i]=prices[i];
				else
					mins[i]=mins[i-1];
			}
		}
		for(int i=n-1;i>=0;i--)
		{
			if(i==n-1)
				maxs[n-1]=prices[n-1];
			else
			{
				maxs[i]=maxs[i+1]>prices[i]?maxs[i+1]:prices[i];
			}
		}
		int r=0;
		for(int i=0;i<n-1;i++)
		{
			if(maxs[i+1]>mins[i])
			{
				if(maxs[i+1]-mins[i]>r)
					r=maxs[i+1]-mins[i];
			}
		}
		return r;
	}
		
}
