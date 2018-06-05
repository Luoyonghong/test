package leetcode300AndLater;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class Problem337
{
	public int rob(TreeNode root)
	{
		if(root==null)
			return 0;
		List<Integer> dp=new ArrayList<Integer>();
		dp.add(root.val);
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		int oldlength=1;
		int nowlength=0;
		int nowsum=0;
		while(q.size()>0)
		{
			TreeNode t=q.poll();
			if(t.left!=null)
			{
				q.offer(t.left);
				nowsum+=t.left.val;
				nowlength++;
			}
			if(t.right!=null)
			{
				q.offer(t.right);
				nowsum+=t.right.val;
				nowlength++;
			}
			oldlength--;
			if(oldlength==0)
			{
				oldlength=nowlength;
				nowlength=0;
				//dp[i]=max(dp[i-1],dp[i-2]+nowsum)
				if(dp.size()==1)
					dp.add(Math.max(dp.get(0),nowsum));
				int max=Math.max(dp.get(dp.size()-1), dp.get(dp.size()-2)+nowsum);
				dp.add(max);
				nowsum=0;
			}
		}
		return dp.get(dp.size()-1);
	}
}
