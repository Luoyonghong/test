package leetcode162AndLater;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199
{
	public List<Integer> rightSideView(TreeNode root)
	{
		if(root==null)
            return new ArrayList<Integer>();
		List<Integer> l=new ArrayList<Integer>();
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.offer(root);
		int size=1;
		int count=0;
		while(!q.isEmpty())
		{
			TreeNode t=q.poll();
			count++;
			if(t.left!=null)
				q.add(t.left);
			if(t.right!=null)
				q.add(t.right);
			if(count==size)
			{
				l.add(t.val);
				size=q.size();
				count=0;
			}
		}
		return l;
	}
}
