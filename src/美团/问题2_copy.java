package 美团;

import java.util.Scanner;

public class 问题2_copy
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int[] numsCount = new int[10];
		for (int i = 0; i < s.length(); i++)
		{
			numsCount[s.charAt(i) - '0']++;
		}
		int minIndex = 1;
		for (int i = 1; i < 10; i++)
		{
			if (numsCount[i] < numsCount[minIndex])
			{
				minIndex = i;
			}
		}
		if (numsCount[minIndex] == 0)
		{
			System.out.println(minIndex);
			return;
		} else if (numsCount[minIndex] > numsCount[0])
		{
			int count = numsCount[0] + 1;
			int res = 1;
			while (count > 0)
			{
				res *= 10;
				count--;
			}
			System.out.println(res);
			return;
		} else
		{
			int res = minIndex;
			int count = numsCount[minIndex];
			while (count > 0)
			{
				res = res * 10 + minIndex;
				count--;
			}
			System.out.println(res);
			return;
		}
	}
}
