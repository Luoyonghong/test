package leetcode100AndLater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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

public class Problem101
{
	public boolean isSymmetric(TreeNode root)
	{
		
	       return f(root.left,root.right);
	}

	public boolean f(TreeNode l,TreeNode r)
	{
		if(l==null&&r==null)
			return true;
		
		if(l!=null&&r==null)
			return false;
		if(l==null&&r!=null)
			return false;
		if(l!=null&&r!=null&&l.val!=r.val)
			return false;
		else
			return f(l.left,r.right)&&f(l.right,r.left);
		
	}
}
