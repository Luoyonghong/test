package 腾讯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 第三题
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String a = sc.next();
		sc.nextLine();
		String b = sc.next();
		sc.nextLine();

		// List<char[]> zichuan=new ArrayList<>();
		int sum = 0;
		char[] t = b.toCharArray();
		// System.out.println(a.length());
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < a.length(); i++)
		{
			if (i + k <= a.length())
			{
				// System.out.println(i);
				// zichuan.add(a.substring(i,
				// i+k).toCharArray());
				String h = a.substring(i, i + k);
				if (!set.contains(h))
				{
					sum += func(h.toCharArray(), t);
					set.add(h);
				}
			}
		}
		System.out.println(sum);
	}

	public static int func(char[] a, char[] b)
	{
		// System.out.println(new String(a));
		// System.out.println(new String(b));
		int sum = 0;
		for (int i = 0; i <= b.length - a.length; i++)
		{
			boolean isok = true;
			int k = 0;
			for (k = 0; k < a.length; k++)
			{

				if (i + k < b.length && b[i + k] != a[k])
				{
					isok = false;
					break;
				}
			}
			if (isok && k >= a.length)
				sum++;
		}
		// System.out.println(sum);
		return sum;

	}
}
