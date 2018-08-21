package leetcode300AndLater;

public class Problem343
{
	public int integerBreak(int n)
	{
		if(n==2)
			return 1;
		int re[]=new int[n+1];
		re[1]=1;
		re[2]=1;
		for(int i=3;i<=n;i++)
		{
			for(int j=1;j<i;j++)
			{
				re[i]=Math.max(re[i-j]*j, re[i]);
				re[i]=Math.max((i-j)*j,re[i]);
			}
			//System.out.println(re[i]); 
		}
		
		return re[n];
	}
	public static void main(String[] args)
	{
		Problem343 p=new Problem343();
		System.out.println(p.integerBreak(10)); 
	}
}
