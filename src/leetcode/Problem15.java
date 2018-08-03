package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem15
{
	public static List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (len < 3)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < len; i++)
		{
			if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int begin = i + 1, end = len - 1;
			while (begin < end)
			{
				int sum = nums[i] + nums[begin] + nums[end];
				if (sum == 0)
				{
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[begin]);
					list.add(nums[end]);
					res.add(list);
					begin++;
					end--;
					while (begin < end && nums[begin] == nums[begin - 1])
						begin++;
					while (begin < end && nums[end] == nums[end + 1])
						end--;
				} else if (sum > 0)
					end--;
				else
					begin++;
			}
		}
		return res;
	}

	public static void main(String[] args)
	{

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(-2);
		l1.add(0);
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(-2);
		l2.add(2);
		l2.add(0);
		System.out.println(l1.containsAll(l2));

		int[] a = { 0, 0, 0, 0 };
		List<List<Integer>> r = threeSum(a);
		for (List<Integer> l : r)
		{
			for (Integer i : l)
			{
				System.out.print(i + "  ");
			}
			System.out.println();
		}
	}
}
