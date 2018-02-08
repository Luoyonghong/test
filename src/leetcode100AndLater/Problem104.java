package leetcode100AndLater;
public class Problem104 {

	public int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		return java.lang.Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	}
	
	
}
