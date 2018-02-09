package leetcode100AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem107 {
	List<List<Integer>> l=new ArrayList<>();
	List<TreeNode> nowlayer=new ArrayList<>();
	List<TreeNode> nextlayer=new ArrayList<>();
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root==null)
            return l;
		nowlayer.add(root);
		help();
		List<List<Integer>> rr=new ArrayList<>();
		for(int i=l.size()-1;i>=0;i--)
		{
			rr.add(l.get(i));
		}
		
		return rr;
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
