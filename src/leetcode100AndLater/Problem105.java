package leetcode100AndLater;

public class Problem105 {
	//preorder = [3,9,20,15,7]
	//inorder = [9,3,15,20,7]
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        if(preorder.length==1)
            return new TreeNode(preorder[0]);
		return f(preorder, inorder, 0, preorder.length, 0, inorder.length);
	}
	
	public TreeNode f(int[] preorder, int[] inorder,int prebegin,int preend,int inbegin,int inend)
	{
		TreeNode t=new TreeNode(preorder[prebegin]);
		int leftlength=0,rightlength=0;
		for(int i=inbegin;i<inend;i++)
		{
			if(inorder[i]==preorder[prebegin])
			{
				leftlength=i-inbegin;
				rightlength=inend-i-1;
				break;
			}
		}
		System.out.println("leftlength: "+leftlength+" rightlength: "+rightlength);
		if(leftlength==1)
			t.left=new TreeNode(inorder[inbegin]);
        else if (leftlength==0)
            t.left=null;
		else
			t.left=f(preorder, inorder, prebegin+1, prebegin+leftlength+1, inbegin, inbegin+leftlength);
		if(rightlength==1)
			t.right=new TreeNode(inorder[inend-1]);
        else if (rightlength==0)
            t.right=null;
		else
			t.right=f(preorder, inorder, prebegin+leftlength+1, preend, inbegin+leftlength+1, inend);
		return t;
	}
	public static void main(String[] args) {
		int preorder[]={1,2,3},inorder[]={3,2,1};
		Problem105 p=new Problem105();
		System.out.println(p.buildTree(preorder, inorder));
	}
}
