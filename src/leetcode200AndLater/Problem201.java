package leetcode200AndLater;

public class Problem201
{
	public int rangeBitwiseAnd(int m, int n)
	{
		if(m==n)
            return m;
		//110
		//111
		//首先找到第一个小于等于n的2的某次方，记为a,判断m是否大于a,不是的话直接返回0，是的话，m,n都减去a,继续循环，直到m<=a
		int sum=0;
        long a=1;
        while(true)
        {
			while(a*2<=n)
				a*=2;
			if(m>=a)
			{
				sum+=a;
				m-=a;
				n-=a;
				a=1;
			}
			else
				return sum;
        }
        //return sum;
	}
	public static void main(String[] args)
	{
		Problem201 p=new Problem201();
		//20000
		//2147483647
		System.out.println(p.rangeBitwiseAnd(20000, 2147483647));
		
	}
}
