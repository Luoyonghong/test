package leetcode62AndLater;

public class Problem70
{
	public int climbStairs(int n)
	{
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		int r[]=new int[n+1];
		r[0]=1;
		r[1]=1;
		r[2]=2;
		for(int i=3;i<=n;i++)
			r[i]=r[i-1]+r[i-2];
		return r[n];

	}

	public static void main(String[] args)
	{

	}
}
