package leetcode200AndLater;

public class Problem209
{
	public int minSubArrayLen(int s, int[] a)
	{
		if (a == null || a.length == 0)
		    return 0;
		  
		  int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		  
		  while (j < a.length) {
		    sum += a[j++];
		    
		    while (sum >= s) {
		      min = Math.min(min, j - i);
		      sum -= a[i++];
		    }
		  }
		  
		  return min == Integer.MAX_VALUE ? 0 : min;
	}
	public static void main(String[] args)
	{
		Problem209 p=new Problem209();
		int nums[]={1,4,4};
		System.out.println(p.minSubArrayLen(4, nums));
	}
}
