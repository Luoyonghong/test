package 头条;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class 问题1
{
	public static void main2(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		Arrays.sort(nums);
		int begin = 0;
		int end = 1;
		int count = 0;
		if (k == 0)
		{
			int duplite = 0;
			int temp = nums[0];
			HashSet<Integer> hash = new HashSet<>();
			for (int i = 1; i < n; i++)
			{
				if (nums[i] == temp)
					hash.add(nums[i]);
				temp = nums[i];
			}
			System.out.println(hash.size());
			return;
		}

		while (begin < end && end < n && begin < n)
		{
			if (nums[end] - nums[begin] < k)
			{
				end++;
				while (end + 1 < n && nums[end] == nums[end + 1])
					end++;
			} else if (nums[end] - nums[begin] > k)
			{
				begin++;
				while (begin + 1 < n && begin + 1 < end && nums[begin] == nums[begin + 1])
					begin++;
			} else
			{
				count++;
				end++;
				while (end + 1 < n && nums[end] == nums[end + 1])
					end++;
			}
			// System.out.println(end);
		}
		System.out.println(count);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		Arrays.sort(nums);
		int count = 0, j = 0;
	        for (int i = 0; i < n; ++i) {
	            j = Math.max(j, i + 1);
	            while (j < n && nums[j] - nums[i] < k)
	        	    	j++;
	            if (j < n && nums[j] - nums[i] == k) 
	        	    	count++;
	            while (i < n - 1 && nums[i] == nums[i + 1])
	        	    	i++;
	        }
	        System.out.println(count); 

	}
}
