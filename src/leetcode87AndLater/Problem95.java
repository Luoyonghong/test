package leetcode87AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem95
{
	List<TreeNode> l=new ArrayList<TreeNode>();
	public List<TreeNode> generateTrees(int n)
	{
		TreeNode begin=new TreeNode(-1);//最开始的node,无意义，不放入结果中，只是为了方便
		boolean used[] =new boolean[n];
		func(1, n, begin, used, begin);
		return l;
	}
	public boolean isAllUsed(boolean [] used)
	{
		for (boolean b : used)
		{
			if(!b)
				return false;
		}
		return true;
	}
	
	public void func(int begin, int end,TreeNode nowNode,boolean used[],TreeNode first)
	{
		if(isAllUsed(used))
		{
			//TreeNode t=copy(first);
			l.add(first.right);
			return;
		}
		
		if(begin==end)
		{
			return ;
		}
		
		for(int i=begin;i<nowNode.val&&!used[i-1];i++)
			for(int j=nowNode.val+1;j<=end&&!used[i-1];j++)
			{
				TreeNode left=new TreeNode(i);
				TreeNode right=new TreeNode(j);
				nowNode.left=left;
				nowNode.right=right;
				used[i-1]=true;
				used[j-1]=true;
				func(begin, i-1, left, used,first);
				func(j+1, end, right, used,first);
				used[i-1]=false;
				used[j-1]=false;
			}
		if(begin>nowNode.val)
		{
			for(int i=begin;i<=end&&!used[i-1];i++)
			{
				TreeNode right=new TreeNode(i);
				nowNode.left=null;
				nowNode.right=right;
				used[i-1]=true;
				func(begin, end, right, used,first);
				used[i-1]=false;
			}
		}
		if(end<nowNode.val)
		{
			for(int i=begin;i<=end&&!used[i-1];i++)
			{
				TreeNode left=new TreeNode(i);
				nowNode.left=left;
				used[i-1]=true;
				func(begin, end, left, used,first);
				used[i-1]=false;
			}
		}
	}
	
	public TreeNode copy(TreeNode node)
	{
		TreeNode t=node.right;
		
		
		return new TreeNode(0);
	}
	
	public void copyOne(TreeNode node) 
	{
		
	}
	
}
