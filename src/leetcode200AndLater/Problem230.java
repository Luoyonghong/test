package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem230
{
	//中序遍历
	/*
	int kth[]=new int[2];
	public int kthSmallest(TreeNode root, int k)
	{
		kth[0]=k;
		help(root);
        return kth[1];
	}
	
	public void help(TreeNode root)
	{
		if(root!=null)
		{
			help(root.left);
			if(kth[0]==1)
				kth[1]=root.val;
            
			kth[0]=kth[0]-1;
			help(root.right);
		}
	}
	 * 递归
	 */
	//非递归
	List<Integer> l=new ArrayList<Integer>();
	public int kthSmallest(TreeNode root, int k)
	{
		Stack<TreeNode> s=new Stack<TreeNode>();
		while(root!=null||s.size()>0)
		{
			while(root!=null)
			{
				s.push(root);
				root=root.left;
			}
			root=s.pop();
			l.add(root.val);
			if(l.size()==k)
				return l.get(l.size()-1);
			root=root.right;
		}
		return -1;
	}
	
	
}
