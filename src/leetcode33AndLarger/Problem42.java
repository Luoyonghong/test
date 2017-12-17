package leetcode33AndLarger;

public class Problem42
{
	public int trap(int[] height)
	{
		int sum=0;
		int lastHighest=0;
		int maxHighest=0;
		for (int i=0;i<height.length;i++)
		{
			if(height[i]>height[maxHighest])
				maxHighest=i;
		}
		System.out.println(maxHighest); 
		
		for(int i=1;i<=maxHighest;i++)
		{
			while(i<maxHighest&&height[i]<=height[lastHighest])
				i++;
			System.out.println("目前遍历到i: "+i+" 当前height大小： "+height[i]+" 当前lastHighest大小： "+lastHighest); 
			for(int j=lastHighest+1;j<i;j++)
			{
				sum+=height[lastHighest]-height[j];
			}
			System.out.println("当前sum: "+sum); 
			lastHighest=i;
		}
		
		
		lastHighest=height.length-1;
		for(int i=height.length-2;i>=maxHighest;i--)
		{
			while(i>=maxHighest&&height[i]<=height[lastHighest])
				i--;
			System.out.println("目前遍历到i: "+i+" 当前height大小： "+height[i]+" 当前lastHighest大小： "+lastHighest); 
			for(int j=i+1;j<lastHighest;j++)
			{
				sum+=height[lastHighest]-height[j];
			}
			System.out.println("当前sum: "+sum); 
			lastHighest=i;
			
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		Problem42 p=new Problem42();
		int height[]={5,5,1,7,1,1,5,2,7,6};
		System.out.println(p.trap(height));
	}
}
