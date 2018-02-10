package leetcode100AndLater;

public class Problem114 {
	public void flatten(TreeNode root) {
		if(root==null)
			return  ;
		h(root);
	}
	
	
	public TreeNode h(TreeNode r)
	{
        if (r == null)
			return null;
		if (r != null && r.left == null && r.right == null) {
			System.out.println(r.val);
			return r;
		}
		System.out.println(r.val);
		TreeNode left = r.left;
		TreeNode right = r.right;
		r.left = null;
		r.right = null;
		TreeNode ll = h(left), rr = h(right);
		if (ll == null) {
			r.right = rr;
			return r;
		} else if (rr == null) {
			r.right = ll;
			return r;
		} else {
			r.right = ll;
            TreeNode g=r.right;
            while(g.right!=null)
            {
                g=g.right;
            }
			g.right = rr;
			return r;
		}
	}

	public static void main(String[] args) {
		Problem114 p = new Problem114();
		TreeNode t1 = new TreeNode(1), t2 = new TreeNode(2), t3 = new TreeNode(3);
		t1.left = t2;
		t2.left = t3;
		p.flatten(t1);

	}
}
