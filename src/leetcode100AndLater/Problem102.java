package leetcode100AndLater;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem102 {
	public static void main(String[] args) {

	}
	List<TreeNode> nowlayer=new ArrayList<TreeNode>();
	List<TreeNode> nextlayer=new ArrayList<TreeNode>();
	
	List<List<Integer>> l=new ArrayList<List<Integer>>();
	

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null)
            return l;
		nowlayer.add(root);
		help();
		return l;
	}
	
	public void help()
	{
		if(nowlayer.size()==0)
			return;
		int i=0;
		List<Integer> values=new ArrayList<Integer>();
		nextlayer=new ArrayList<TreeNode>();
		while(nowlayer.size()>i)
		{
			TreeNode next=nowlayer.get(i);
			values.add(next.val);
			if(next.left!=null)
				nextlayer.add(next.left);
			if(next.right!=null)
				nextlayer.add(next.right);
			i++;
		}
		l.add(values);
		nowlayer=nextlayer;
		help();
	}

}
