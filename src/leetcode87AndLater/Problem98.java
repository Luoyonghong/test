package leetcode87AndLater;


public class Problem98
{
	
	class H
	{
		int min,max;
		boolean ok;
		H(int min,int max,boolean ok)
		{
			this.min=min;
			this.max=max;
			this.ok=ok;
		}
	}
	public boolean isValidBST2(TreeNode root)
	{
		
		return func(root).ok;
		
	}
	
	public boolean isValidBST(TreeNode root)
	{
		
		double before[]=new double[1];
		before[0]=-Double.MAX_VALUE;
		return helper(root, before);
		
	}
	
	public boolean helper(TreeNode t, double[] before)
	{
		
		if(t==null)
			return true;
		System.out.println("t: "+t.val+" before:"+before[0]); 
		boolean m1=
		helper(t.left, before);
		if(before[0]>=t.val)
			return false;
		else
			before[0]=t.val;
		return	helper(t.right, before)&&m1;
		
	}
	
	public H func(TreeNode h)
	{
		if(h==null)
			return new H(0, 0, true);
		//System.out.println(h.val); 
		if(h.left==null&&h.right!=null)
		{
			H h1=func(h.left),h2=func(h.right);
			if(h1.ok&&h2.ok&&h.val<h.right.val&&h2.min>h.val)
				return new H(h.val,h2.max,true);
			else
				return new H(0,0,false);
		}
		if(h.left!=null&&h.right==null)
		{
			H h1=func(h.left),h2=func(h.right);
			if(h1.ok&&h2.ok&&h.val>h.left.val&&h1.max<h.val)
				return new H(h1.min,h.val,true);
			else
				return new H(0,0,false);
		}
		
		if(h.left==null&&h.right==null)
		{
			return new H(h.val,h.val,true);
		}
		
		if(h.left!=null&&h.right!=null)
		{
			H h1=func(h.left),h2=func(h.right);
			if(h1.ok&&h2.ok&&h.val<h.right.val&&h.val>h.left.val&&h1.max<h.val&&h2.min>h.val)
				return new H(h1.min,h2.max,true);
			else
				return new H(0,0,false);
		}
		
		return new H(0,0,false);
		
	}
	
	public static void main(String[] args)
	{
		TreeNode root=new TreeNode(3);
		TreeNode t1=new TreeNode(30);
		TreeNode t2=new TreeNode(10);
		TreeNode t3=new TreeNode(15);
		TreeNode t4=new TreeNode(45);
		root.right=t1;
		t1.left=t2;
		t2.right=t3;
		t3.right=t4;
		
		Problem98 p=new Problem98();
		
		System.out.println(p.isValidBST(new TreeNode(0).left=new TreeNode(-1)));  
		System.out.println(-4.9E-32>-1); 
	}
}
