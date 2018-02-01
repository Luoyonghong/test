package leetcode87AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem100
{
	 List<String> l1,l2;
	public boolean isSameTree(TreeNode p, TreeNode q) {
       l1=new ArrayList<String>();
       l2=new ArrayList<String>();
       f(p,l1);
       f(q,l2);
       if(l1.size()!=l2.size())
    	   return false;
       for(int i=0;i<l1.size();i++)
       {
    	   //System.out.println(l1.get(i)+"  "+l2.get(i)); 
    	   if(!l1.get(i).equals(l2.get(i)))
    		   return false;
       }
       return true;
    }
	
	public void f(TreeNode t,List<String> l)
	{
		if(t==null)
		{
			l.add("null");
			return;
		}
		if(t.left==null&&t.right==null)
		{
			l.add(""+t.val);
			return;
		}
		f(t.left, l);
		l.add(""+t.val);
		f(t.right, l); 
	}
	public static void main(String[] args)
	{
		Problem100 p=new Problem100();  
		TreeNode t1=new TreeNode(1);
		t1.left=new TreeNode(1);
		TreeNode t2=new TreeNode(1);
		t2.right=new TreeNode(1);
		System.out.println(p.isSameTree(t1, t2)); 
	}

}
