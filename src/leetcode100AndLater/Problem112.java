package leetcode100AndLater;

public class Problem112 {
	int count=0;
	boolean t=false;
	public boolean hasPathSum(TreeNode root, int sum) {
		height(root,sum);
		return t;
	}

	public void height(TreeNode r, int sum) {
		if (r == null)
			return;
		count += r.val;
		if (r.left == null && r.right == null) {
			if (count == sum) {
				t=true;
				return;
			}
		}

		height(r.left,sum);

		height(r.right,sum);
		count -= r.val;
	}
}
