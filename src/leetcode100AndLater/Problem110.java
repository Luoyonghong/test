package leetcode100AndLater;

public class Problem110 {
	boolean t=true;
	public boolean isBalanced(TreeNode root) {
		TreeNode f=new TreeNode(0);
		f.right=root;
		height(f);
		return t;
	}
	
	public int height(TreeNode r)
	{
		
		if(r==null)
			return 0;
		int heightl=height(r.left),heightr=height(r.right);
		if(Math.abs(heightl-heightr)>1)
		{
			t=false;
			return Math.max(heightl, heightr);
		}
		System.out.println("node:"+r.val+" "+"l: "+heightl+" r:"+heightr); 
		return Math.max(heightl, heightr)+1;
	}
	public static void main(String[] args) {
		Problem110 p=new Problem110();
		TreeNode t1=new TreeNode(1),t2=new TreeNode(2),t3=new TreeNode(3);
		t1.right=t2;
		t2.right=t3;
		System.out.println(p.isBalanced(t1)); 
		
	}
}
