package leetcode200AndLater;

import java.util.Deque;
import java.util.LinkedList;

public class Problem239
{
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		int[] re = null;
		if (k == 0)
			return new int[] {};
		Deque<Integer> q = new LinkedList<Integer>();
		re = new int[nums.length - k + 1];
		int index = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (!q.isEmpty() && q.getFirst() < i - k +1)
				q.pollFirst();
			while (!q.isEmpty() && nums[q.getLast()] < nums[i])
				q.pollLast();
			q.offerLast(i);
			if (i >= k - 1)
				re[index++] = nums[q.getFirst()];
		}
		return re;
	}

	public static void main(String[] args)
	{
		Problem239 p = new Problem239();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] re = p.maxSlidingWindow(nums, 3);
		for (int i : re)
		{
			System.out.println(i);
		}
	}
}
