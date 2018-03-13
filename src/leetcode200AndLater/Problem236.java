package leetcode200AndLater;

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

/*
 *         _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 * 
 */
public class Problem236
{
	/*正确答案
	 * （4,6） ->5，就算找到了5，回溯到3的时候，右边的子树由于找不到节点，所以返回空，所以对于节点3来说，返回的也是5！
	 * 
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {  
        if(root == null) return null;  
        if(root == p || root == q) return root;  
        TreeNode l1 = lowestCommonAncestor(root.left, p, q);  
        TreeNode l2 = lowestCommonAncestor(root.right, p, q);  
        if(l1 !=null && l2!=null) return root;  
        return l1 == null? l2 :l1;  
    }  
	*/
	
	//下面的答案只能通过31/32个测试样例，不是时间问题，测试数据问题
	boolean isfind=false;
	TreeNode father=null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		int[] result=new int[1];
		help(root, p, q, result);
		return father;
	}
	
	public void help(TreeNode node,TreeNode p, TreeNode q, int[] result)
	{
		if(node==null)
		{
			result[0]=0;
			return;
		}
		if(isfind)
			return;
		help(node.left,p,q,result);
		int a=result[0];
		help(node.right,p,q,result);
		int b=result[0];
		int c=0;
		if(node.val==p.val||node.val==q.val)
			c++;
		if(a+b+c==2&&!isfind)
		{
			isfind=true;
			father=node;
			return ;
		}
		
		result[0]=a+b+c;
	}
}
