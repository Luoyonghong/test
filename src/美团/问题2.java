package 美团;

import java.util.Scanner;

public class 问题2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] c = new int[10];
		for (int i = 0; i < s.length(); i++)
		{
			char temp = s.charAt(i);
			c[temp - '0']++;
		}
		for (int i = 1; i < 10; i++)
		{
			if (c[i] == 0)
			{
				System.out.println(i);
				return;
			}
		}

		if (c[0] == 0)
		{
			System.out.println(10);
			return;
		}

		int min = s.length();
		int index = 0;
		for (int i = 1; i < 10; i++)
		{
			if (c[i] < min)
			{
				min = c[i];
				index = i;
			}
		}
		if (c[index] > c[0])
		{
			int count = c[0] + 1;
			int res = 1;
			while (count > 0)
			{
				res *= 10;
				count--;
			}
			System.out.println(res);
			return;
		}
		String k = "";
		for (int i = 1; i <= min + 1; i++)
		{
			k += String.valueOf(index);
		}
		System.out.println(k);

	}
}
