package 网易;

import java.math.BigInteger;
import java.util.Scanner;

public class 第二题
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		long res = 0;

		for (int i = k + 1; i < n - k + 1; i++)
		{
			int temp = n / i - 1;
			int mod = n % i - k + 1;
			res += temp * (i - k);
			if (mod > 0)
				res += mod;
		}
		long l1 = n - k + 1;
		long l2 = n - k;
		res += l1 * l2 / 2;
		System.out.println(res);

	}

}
