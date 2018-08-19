package leetcode300AndLater;

public class Problem331
{
	public boolean help(String[] s, int l, int r)
	{
		if (s[l].equals("#") && r - l > 1)
		{
			// System.out.println(l +" "+ r + " false");
			return false;
		}
		if (r - l == 1 && s[l].equals("#"))
		{
			// System.out.println(l +" "+ r + " true");
			return true;
		}
		if (r - l == 3 && s[l].equals("#"))
		{
			// System.out.println(l +" "+ r + " true");
			return true;
		}
		for (int i = l + 1; i < r - 1; i++)
		{
			// String left=preorder.substring(1,i+1);
			// String
			// right=preorder.substring(i+1,preorder.length());
			if (help(s, l + 1, i + 1) && help(s, i + 1, r))
			{
				// System.out.println(l +" "+ r + " true");
				return true;
			}
		}
		// System.out.println(l +" "+ r + " false");
		return false;

	}

	public boolean isValidSerialization(String preorder)
	{
		String[] nodes = preorder.split(",");
		// 来一个新点，则入度+1，如果改点不是null(#)的话，出度+2，任何情况出度都要大于入度
		int out = 0;
		int in = 0;
		if (nodes[0].equals("#"))
			out = 0;
		else
			out = 2;
		for (int i = 1; i < nodes.length; i++)
		{
			in++;
			if (out < in)
				return false;
			if (!nodes[i].equals("#"))
			{
				out += 2;
			}
		}
		return out == in;
	}

	public static void main(String[] args)
	{
		Problem331 p = new Problem331();

		System.out.println(p.isValidSerialization("9,#,#,1"));
	}
}
