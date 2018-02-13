package LeetCode120AndLater;

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

public class Problem124
{
	int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root)
	{
		f(root);
		return max;
	}
	public int f(TreeNode r)
	{
		if(r==null)
			return 0;
		int left=f(r.left);
		int right=f(r.right);
		int nowmax=Math.max(left+right+r.val, Math.max(0,Math.max(left, right))+r.val);
		if(nowmax>max)
			max=nowmax;
		return Math.max(Math.max(left, right),0)+r.val;
		
	}
}
