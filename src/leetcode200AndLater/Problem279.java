package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem279
{
	List<Integer> r =new ArrayList<>();
	int max=Integer.MAX_VALUE;
	public int numSquares(int n)
	{
		int r[] =new int[n+1];
		r[1]=1;
		for(int i=2;i<=n;i++)
		{
			r[i]=i;
			if(Math.sqrt(i)==(int)Math.sqrt(i))
				r[i]=1;
			for(int j=1;j<i;j++)
			{
				r[i]=r[j]+r[i-j]<r[i]?r[j]+r[i-j]:r[i];
			}
			
		}
		return r[n];
		//下面更快
//		int[] minCount = new int[n + 1];
//	        minCount[0] = 0;
//	        for (int i = 1; i <= n; i++) {
//	            minCount[i] = Integer.MAX_VALUE;
//	            for (int j = 1; j * j <= i; j++) { // <= !!!
//	                if (minCount[i - j * j] < minCount[i] - 1) {
//	                    minCount[i] = minCount[i - j * j] + 1;
//	                }
//	            }
//	        }
//	        return minCount[n];

	}
	
	
	public boolean help(int n)
	{
		if(n==0)
		{
			max=max>r.size()?r.size():max;
			return true;
		}
		int c=(int)Math.sqrt(n);
		for(int i=c;i>=1;i--)
		{
			//System.out.println(i); 
			r.add(i*i);
			n -= i*i;
			help(n);
			n+=i*i;
			r.remove(r.size()-1);	
		}
		return true;
		
	}
	public static void main(String[] args)
	{
		Problem279 p =new Problem279();
		System.out.println(p.numSquares(50));  
	}
}
