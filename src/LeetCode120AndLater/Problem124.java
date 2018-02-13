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
	//寻找二叉树中任意开头和结果的最大路径
	/*
	 * 要么是当前节点的左子树+右子树+当前值，或者直接返回当前节点遍历到叶子节点的路径最大和
	 * 因为值有可能是负数，所以判断一下左子树+右子树的路径和如果小于0，就舍弃这个，变成0+当前值
	 */
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
