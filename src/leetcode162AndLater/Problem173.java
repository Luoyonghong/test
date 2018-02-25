package leetcode162AndLater;

import java.util.Stack;


class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)
	{
		val = x;
	}
}
public class Problem173
{
	Stack<TreeNode> s=new Stack<TreeNode>();
    public Problem173(TreeNode root) {
        while(root!=null)
        {
            s.push(root);
            root=root.left;
        }
    }

    
    public boolean hasNext() {
        return !s.isEmpty();
    }

  
    public int next() {
        TreeNode t=s.pop();
        TreeNode t2=t.right;
        while(t2!=null)
        {
            s.push(t2);
            t2=t2.left;
        }
        return t.val;
    }
}
