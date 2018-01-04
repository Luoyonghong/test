package leetcode62AndLater;

public class Problem69
{
	public int mySqrt(int x)
	{
		return (int)func(x,1,x);
	}
	
	public long func(int x, long low, long high)
	{
		if(low+1==high)
			return low;
		long middel=(low+high)/2;
		if(middel*middel<x)
			return func(x,middel,high);
		else if(middel*middel>x)
			return func(x,1,middel);
		else
			return middel;
	}
	public static void main(String[] args)
	{
		Problem69 p=new Problem69(); 
		System.out.println(p.mySqrt(2147395599)); 
	}

}
