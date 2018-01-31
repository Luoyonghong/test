package leetcode87AndLater;


public class Problem99
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
	public boolean isValidBST(TreeNode root)
	{
		
		return func(root).ok;
		
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
	
	public void recoverTree(TreeNode root)
	{
		
	}
}
