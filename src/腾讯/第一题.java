package 腾讯;

import java.util.Arrays;
import java.util.Scanner;

public class 第一题
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int Z = sc.nextInt();

		long sum = 0;
		for (int i = 1; i <= Z; i++)
		{
			for (int j = 1; j <= Y; j++)
			{
				if (i == j)
				{
					sum += Math.min(i + j - 1, X);
					sum = sum % 10000000007l;
				} else
				{
					sum += Math.min(i + j - 1, X) - Math.abs(i - j);
					sum = sum % 10000000007l;
				}
			}
		}
		System.out.println(sum);
	}
}
