package leetcode87AndLater;

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

public class Problem94
{

	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> l=new ArrayList<Integer>();
		Stack<TreeNode> s=new Stack<TreeNode>();
		//s.push(root);
		while (root != null||!s.isEmpty())
		{
			if(root!=null)
			{
				s.push(root);
				root=root.left;
			}
			else
			{
				root=s.pop();
				l.add(root.val);
				root=root.right;
			}
		}
		return l;
	}
	
	public List<Integer> inorderTraversal2(TreeNode root)
	{
		List<Integer> l=new ArrayList<Integer>();
		func(root, l); 
		return l;
	}
	public void func(TreeNode node,List<Integer> l)
	{
		if(node!=null)
		{
			func(node.left,l);
			l.add(node.val);
			func(node.right, l);
		}
	}
}
