package LeetCode120AndLater;

public class Problem129
{

	int sum = 0, nowsum = 0;

	public int sumNumbers(TreeNode root)
	{
		if (root == null)
			return 0;
		if (root != null && root.left == null && root.right == null)
		{
			sum += root.val;
			return sum;
		}
		nowsum = root.val;
		h(root.left);
		h(root.right);
		return sum;
	}

	public void h(TreeNode r)
	{
		System.out.println(nowsum);
		if (r != null && r.left == null && r.right == null)
		{
			sum += nowsum * 10 + r.val;
			return;
		}
		if (r == null)
			return;
		int temp = nowsum;
		nowsum = nowsum * 10 + r.val;
		h(r.left);
		h(r.right);
		nowsum = temp;
	}

	public static void main(String[] args)
	{
		Problem129 p = new Problem129();
		TreeNode t1 = new TreeNode(4), t2 = new TreeNode(9), t3 = new TreeNode(0), t4 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		System.out.println(p.sumNumbers(t1));
	}

}
