package LeetCode120AndLater;

public class Problem134
{
	public int canCompleteCircuit(int[] gas, int[] cost)
	{
		int n=cost.length;
		int reserve[]=new int[cost.length];
		for(int i=0;i<n;i++)
		{
			reserve[i]=gas[i]-cost[i];
		}
		
		for (int i = 0; i < cost.length; i++)
		{
			if(reserve[i]<0)
				continue;
			else
			{
				int j=i+1;
				int count=reserve[i];
				while(j%n!=i)
				{
					count=count+reserve[j%n];
					if(count<0)
						break;
					j++;
				}
				if(j%cost.length==i)
				{
					return i;
				}
				else
					i=j;//从第i个开始一直开，直到遇到不行的时候，中间那些reserve[]大于0的地方（假设为k）一定也不行，因为要
				//开到k,则开到k的时候，count一定大于等于0，而直接从k开始，则count=0，更加不行了，所以下次循环从j开始
			}
		}
		return -1;
	}
	public static void main(String[] args)
	{
		Problem134 p=new Problem134();
		int[] gas={1,2};
		int[] cost={2,1};
		System.out.println(p.canCompleteCircuit(gas, cost));
	}
}
