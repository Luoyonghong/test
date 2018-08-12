package 网易;

import java.util.Scanner;

public class 第一题2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int score[] = new int[n];
		int isqingxing[] = new int[n];
		for (int i = 0; i < n; i++)
			score[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			isqingxing[i] = sc.nextInt();
		int[] sum = new int[n];
		if (isqingxing[0] == 1)
			sum[0] = score[0];

		if (n <= k)
		{
			int temp = 0;
			for (int i = 0; i < n; i++)
				temp += score[i];
			System.out.println(temp);
		}

		for (int i = 1; i < n; i++)
		{
			if (isqingxing[i] == 1)
				sum[i] = sum[i - 1] + score[i];
			else
				sum[i] = sum[i - 1];
		}
		int max = 0;
		for (int i = 0; i < n - k; i++)
		{
			if (isqingxing[i] == 0)
			{
				int temp = 0;
				if (i != 0)
					temp = sum[i - 1];

				for (int j = 0; j < k; j++)
				{
					temp += score[j + i];
				}
				if (i + k < n)
					temp += sum[n - 1] - sum[i + k - 1];
				if (temp > max)
					max = temp;
			}
		}

		for (int i = n - k; i < n; i++)
		{
			int temp = sum[i - 1];
			for (int j = i; j < n; j++)
			{
				temp += score[j];
			}
			if (temp > max)
				max = temp;
		}

		System.out.println(max);
	}
}
