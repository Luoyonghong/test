package 网易;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job
{

	int d, p;

	public Job(int a, int b)
	{
		d = a;
		p = b;
	}
}

public class 问题3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// n个工作
		int m = sc.nextInt();// m个同学
		Job[] jobs = new Job[n];
		int a[] = new int[m];
		for (int i = 0; i < n; i++)
		{
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			Job j = new Job(num1, num2);
			jobs[i] = j;
		}

		for (int i = 0; i < m; i++)
		{
			a[i] = sc.nextInt();
		}
		Arrays.sort(jobs, new Comparator<Job>()
		{

			@Override
			public int compare(Job o1, Job o2)
			{
				// TODO Auto-generated method stub
				return o1.d - o2.d;
			}
		});

		for (int i = 0; i < m; i++)
		{
			int ability = a[i];
			int index = find(jobs, ability) + 3;
			int max = 0;
			for (; index > index - 10 && index >= 0; index--)
			{
				if (index < n && jobs[index].d <= ability && jobs[index].p > max)
					max = jobs[index].p;
			}
			System.out.println(max);
		}
	}

	public static int find(Job[] jobs, int key)// 小于等于的最后一个位置
	{
		int low = 0;
		int high = jobs.length - 1;

		while (low <= high)
		{
			int mid = (low + high) / 2;
			if (jobs[mid].d <= key)
				low = mid + 1;
			else if (jobs[mid].d > key)
				high = mid - 1;
		}

		if (low == 0)
			return -1;

		return low - 1;
	}
}