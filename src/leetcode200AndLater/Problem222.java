package leetcode200AndLater;

public class Problem222
{
	public int countNodes(TreeNode root)
	{
		if(root==null)
			return 0;
		int leftLenth=1,rightLength=1;
		TreeNode back=root;
		while(root.left!=null)
		{
			leftLenth++;
			root=root.left;
		}
		root=back;
		while(root.right!=null)
		{
			rightLength++;
			root=root.right;
		}
		if(leftLenth==rightLength)
			return (int) Math.pow(2, leftLenth)-1;
		else
		{
			return countNodes(back.left)+countNodes(back.right)+1; 
		}
	}
	
	/*
	public int countNodes(TreeNode root) {
        int height = getHeight(root);
        if (height == -1) {
            return 0;
        } else if (getHeight(root.right) == height - 1) {
            return countNodes(root.right) + (1 << height);
        } else {
            return countNodes(root.left) + (1 << (height - 1));
        }
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return getHeight(root.left) + 1;
    }
    */
}
