package leetcode100AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem103 {
	List<TreeNode> nowlayer=new ArrayList<TreeNode>();
	List<TreeNode> nextlayer=new ArrayList<TreeNode>();
	List<List<Integer>> l=new ArrayList<List<Integer>>();
	boolean flag=true;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
		
		List<Integer> values=new ArrayList<Integer>();
		nextlayer=new ArrayList<TreeNode>();
		int i=0;
		while(nowlayer.size()>i)
		{
			TreeNode next=nowlayer.get(i);
			//values.add(next.val);
			if(next.left!=null)
				nextlayer.add(next.left);
			if(next.right!=null)
				nextlayer.add(next.right);
			i++;
		}
		if(flag)
		{
			 i=0;
			while(nowlayer.size()>i)
			{
				TreeNode next=nowlayer.get(i);
				values.add(next.val);
				i++;
			}
		}
		else
		{
			 i=nowlayer.size()-1;
			while(i>=0)
			{
				TreeNode next=nowlayer.get(i);
				values.add(next.val);
				i--;
			}
		}
		l.add(values);
		nowlayer=nextlayer;
		flag=!flag;
		help();
	}
}
