package leetcode100AndLater;

public class Problem106 {
	// inorder = [9,3,15,20,7]
	//postorder = [9,15,7,20,3]
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return f(inorder, postorder, 0, postorder.length, 0, inorder.length);
	}

	public TreeNode f(int[] inorder, int[] postorder, int posbegin, int posend, int inbegin, int inend) {
		TreeNode t = new TreeNode(postorder[posend-1]);
		int leftlength = 0, rightlength = 0;
		for (int i = inbegin; i < inend; i++) {
			if (inorder[i] == postorder[posend-1]) {
				leftlength = i - inbegin;
				rightlength = inend - i - 1;
				break;
			}
		}
		System.out.println("leftlength: " + leftlength + " rightlength: " + rightlength);
		if (leftlength == 1)
			t.left = new TreeNode(inorder[inbegin]);
		else if (leftlength == 0)
			t.left = null;
		else
			t.left = f(inorder, postorder, posbegin , posbegin + leftlength , inbegin, inbegin + leftlength);
		if (rightlength == 1)
			t.right = new TreeNode(inorder[inend - 1]);
		else if (rightlength == 0)
			t.right = null;
		else
			t.right = f(inorder, postorder, posbegin + leftlength , posend-1, inbegin + leftlength + 1, inend);
		return t;
	}

	public static void main(String[] args) {
		int inorder[] = { 9,3,15,20,7 }, posorder[] = { 9,15,7,20,3 };
		Problem106 p = new Problem106();
		System.out.println(p.buildTree(inorder, posorder));
	}
}
