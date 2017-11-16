package leetcode;

public class Problem9
{

	public static boolean isPalindrome(int x)
	{
		if(x<0)
			return false;
		x=Math.abs(x);
		int a=(int)Math.log10(x)+1;
		int b=1;
		System.out.println(a);
		System.out.println(b);
		while(a>b)
		{
			System.out.println(a);
			System.out.println(b);
			int high=x/(int)Math.pow(10, a-1);
			int low=x%10;
			if(high!=low)
				return false;
			else
			{
				x-=high*Math.pow(10, a-1);
				x/=10;
				a-=2;
				//b++;
				System.out.println(x); 
			}
		}
		return true;
		
	}
	public static void main(String[] args)
	{
		System.out.println(isPalindrome(888));
	}
	
}
