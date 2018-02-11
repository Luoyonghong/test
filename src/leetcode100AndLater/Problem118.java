package leetcode100AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem118
{
	/*
	 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
	 */
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> l = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		l1.add(1);
		l2.add(1);
		l2.add(1);
		if (numRows == 0)
			return new ArrayList<>();
		else if (numRows == 1)
		{
			l.add(l1);
			return l;
		} else if (numRows == 2)
		{
			l.add(l1);
			l.add(l2);
			return l;
		} else
		{
			l.add(l1);
			l.add(l2);
			for (int i = 3; i <= numRows; i++)
			{
				List<Integer> t = new ArrayList<>();
				t.add(1);
				for (int j = 2; j <= i - 1; j++)
				{
					// System.out.println("i: "+i+" j: "+j);
					List<Integer> last = l.get(i - 2);
					t.add(last.get(j - 1) + last.get(j - 2));
				}
				t.add(1);
				l.add(t);
			}
		}
		return l;
	}

	public static void main(String[] args)
	{
		Problem118 p = new Problem118();
		List<List<Integer>> l = p.generate(5);
		for (List<Integer> list : l)
		{
			for (Integer integer : list)
			{
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
