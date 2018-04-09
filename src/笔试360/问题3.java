package 笔试360;

import java.math.BigInteger;
import java.util.Scanner;

public class 问题3
{
	// (i=1..k) Σ (-1)^(k-i) * C(k,i) * i^n
	// 3 2->6
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		BigInteger sum = new BigInteger("0");
		for (int i = 1; i <= k; i++)
		{
			// sum=sum%772235;
			BigInteger t = myPow(-1, k - i).multiply(c(k, i)).multiply(myPow(i, n));
			// long t=(long)Math.pow(-1, k-i)*c(k,i)*(long)myPow(i,
			// n);
			// System.out.println(t);
			// sum+=t;
			sum = sum.add(t);
		}
		System.out.println(sum.mod(new BigInteger("772235")));
	}

	public static BigInteger myPow(int i, int n)
	{
		BigInteger r = new BigInteger("1");
		for (int j = 1; j <= n; j++)
		{
			r = r.multiply(new BigInteger(i + ""));
		}
		return r;
	}

	public static BigInteger c(int k, int i)
	{
		BigInteger r = new BigInteger("1");
		for (int j = k; j >= 1; j--)
		{
			if (j > k - i)
			{
				r = r.multiply(new BigInteger(j + ""));
			}
			if (j <= i)
				r = r.divide(new BigInteger("" + j));
		}
		return r;
	}
}