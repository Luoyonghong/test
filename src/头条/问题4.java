package 头条;

import java.util.Scanner;

import java.util.Collections;
import java.util.ArrayList;

public class 问题4
{

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < m; i++)
		{
			a.add(input.nextInt());
		}
		for (int i = 0; i < n; i++)
		{
			b.add(input.nextInt());
		}
		Collections.sort(a);
		Collections.sort(b);
		float a1 = average(a);
		float b1 = average(b);
		if (a1 == b1)
		{
			System.out.println(0);
			return;
		} else if (a1 > b1)
		{
			System.out.println(magic(a, b, 0));
		} else
		{
			System.out.println(magic(b, a, 0));
		}
	}

	public static int magic(ArrayList<Integer> a, ArrayList<Integer> b, int c)
	{
		float a1 = average(a);
		float b1 = average(b);
		for (int i = 0; i < a.size(); i++)
		{
			if (a.get(i) > b1)
			{
				int x = a.get(i);
				if (x >= a1)
				{
					return c;
				} else
				{
					a.remove(i);
					b.add(x);
					Collections.sort(b);
					return magic(a, b, ++c);
				}
			}
		}
		return c;
	}

	public static float average(ArrayList<Integer> arr)
	{
		float sum = 0;
		for (int i = 0; i < arr.size(); i++)
		{
			sum += arr.get(i);
		}
		return sum / arr.size();
	}
}
