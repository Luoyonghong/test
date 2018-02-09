package leetcode100AndLater;

public class Problem108 {
	public TreeNode sortedArrayToBST(int[] nums) {
	return h(nums, 0, nums.length-1);	
	}
	
	public TreeNode h(int[] nums,int begin,int end)
	{
		if(begin>end)
			return null;
		if(end>=nums.length)
			return null;
		if(begin==end)
			return new TreeNode(nums[begin]);
		int t=(begin+end)/2;
		TreeNode n=new TreeNode(nums[t]);
		n.left=h(nums, begin, t-1);
		n.right=h(nums, t+1, end);
		return n;
	}
}
