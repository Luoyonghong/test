package leetcode140AndLater;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem145
{
	public List<Integer> postorderTraversal(TreeNode root)
	{
		//先序遍历是根-左-右，首先换成根-右-左，然后交换一下顺序就变成了左-右-根
		Stack<TreeNode> s = new Stack<>();
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		s.push(root);
		while (!s.isEmpty())
		{
			TreeNode t = s.pop();
			l.add(0,t.val);
			if (t.left != null)
				s.push(t.left);
			if (t.right != null)
				s.push(t.right);
		}
		return l;
	}

	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;

		Problem145 p = new Problem145();
		List<Integer> l = p.postorderTraversal(t1);
		for (Integer in : l)
		{
			System.out.println(in);
		}
	}
}
