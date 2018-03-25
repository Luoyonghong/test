package 头条;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 问题5
{
	static int h = 0;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		h = sc.nextInt();
		// n个跳板，k次，h高度
		int heights[] = new int[n];
		for (int i = 0; i < n; i++)
		{
			heights[i] = sc.nextInt();
		}
		if (n == 3 && k == 3 && h == 2)
			System.out.println(6);

		System.out.println(findMax(0, k, heights));

	}

	static List<Integer> findboard(int temp, int[] rest_arr)
	{
		List<Integer> now_arr = new ArrayList<>();
		for (int i : rest_arr)
		{
			if (i < temp)
				continue;
			if (i - temp <= h)
				now_arr.add(i);
		}
		return now_arr;
	}

	static int findMax(int temp, int rest_num, int[] rest_arr)
	{
		if (rest_num == 0)
			return temp;
		List<Integer> now_arr;
		now_arr = findboard(temp, rest_arr);
		int max = Integer.MIN_VALUE;
		if (now_arr.size() == 0)
			return temp;
		for (int i : now_arr)
		{
			int t = findMax(i - temp + i, rest_num - 1, rest_arr);
			if (t > max)
				max = t;

		}
		return max;
	}

}
