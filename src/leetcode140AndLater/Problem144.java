package leetcode140AndLater;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)
	{
		val = x;
	}
}

public class Problem144
{
	public List<Integer> preorderTraversal(TreeNode root)
	{
		Stack<TreeNode> s = new Stack<>();
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		s.push(root);
		while (!s.isEmpty())
		{
			TreeNode t = s.pop();
			l.add(t.val);
			if (t.right != null)
				s.push(t.right);
			if (t.left != null)
				s.push(t.left);
		}
		return l;
	}

}
