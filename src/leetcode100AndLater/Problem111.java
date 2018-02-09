package leetcode100AndLater;

public class Problem111 {
	int min=Integer.MAX_VALUE,now;
	public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
		height(root);
		return min;
	}
	public void height(TreeNode r)
	{
        if(r==null)
            return;
		now+=1;
		if(r.left==null&&r.right==null)
		{
			if(now<min)
            {
				min=now;
                now-=1;
                return;
            }
		}
		
		height(r.left);
		
		height(r.right);
		now-=1;
	}
}
