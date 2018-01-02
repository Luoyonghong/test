package leetcode62AndLater;

public class Problem66
{
	public int[] plusOne(int[] digits)
	{
		int n=digits.length;
		int [] r=new int[n];
		int inter=0;
		inter=1;
		int t=0;
		for(int i=n-1;i>=0;i--)
		{
			t=digits[i]+inter;
			r[i]=t%10;
			inter=t/10;
		}
		//r[0]=inter;
		if(inter==0)
			return r;
		else
		{
			int [] f=new int[n+1];
			for(int i=0;i<n;i++)
				f[i+1]=r[i];
			f[0]=inter;
			return f;
		}
	}
}
