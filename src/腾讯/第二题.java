package 腾讯;

import java.util.Scanner;

public class 第二题
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();

		long y = sc.nextLong();

		long n = getNum(2 * (x + y));

		if (n == -1)
		{
			System.out.println(-1);
		}
		long num = 0l;
		for (long i = n; i > 0; i--)
		{
			if (x >= i)
			{
				x -= i;
				num++;
			}
		}

		System.out.println(num);
	}

	private static long getNum(long lm)
	{
		long i = (long) Math.sqrt(lm);
		for(;i<lm;i++)
		{
			if (i * (i + 1) == lm)
			{
				return i;
			}
		}
		return -1;
	}

}
