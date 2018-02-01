package leetcode87AndLater;


public class Problem99
{
	int errorCount=0;
	int error1,error2;
	int pre1,pre2;
	public void recoverTree(TreeNode root)
	{
		TreeNode pre=null;
		int before[]=new int[2];
		before[0]=Integer.MIN_VALUE;
		before[1]=Integer.MIN_VALUE;
		inorder(root, before);
		if(errorCount==2)
		{
			swap(root, error1, error2, error2, error1); 
		}
		else
		{
			swap(root, error1, pre1, pre1, error1);
		}
	}
	
	public void inorder(TreeNode t,int[] before)
	{
		if(t==null)
			return;
		inorder(t.left,before);
		before[0]=before[1];
		before[1]=t.val;
		if(before[1]<before[0])
		{
			if(errorCount==0)
			{
				errorCount+=1;
				error1=before[0];
				pre1=before[1];
			}
			else
			{
				errorCount+=1;
				error2=before[1];
				pre2=before[0];
			}
			
		}
		inorder(t.right,before); 
	}
	
	public void swap(TreeNode t, int value1, int back1,int value2,int back2)
	{
		if(t==null)
			return;
		swap(t.left, value1, back1, value2, back2);
		if(t.val==value1)
		{
			t.val=back1;
		}
		else if (t.val==value2)
		{
			t.val=back2;
		}
		swap(t.right, value1, back1, value2, back2);
	}
	public static void main(String[] args)
	{
		Problem99 p=new Problem99();
		TreeNode t1=new TreeNode(2),t2=new TreeNode(3),t3=new TreeNode(1);
		
		t1.left=t2;
		t1.right=t3;
		
		p.recoverTree(t1);
		
		System.out.println(p.error1);
		System.out.println(p.error2); 
		
		System.out.println(t1.left.val);
		System.out.println(t1.val);
		System.out.println(t1.right.val);
	}
	
	
}
