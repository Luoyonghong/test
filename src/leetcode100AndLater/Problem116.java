package leetcode100AndLater;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Problem116 {
	Stack<TreeLinkNode> s=new Stack<>();
	int count=1;
	public void connect(TreeLinkNode root) {
		 if(null == root) return;
	        TreeLinkNode curLev;
	        while(root. left != null){
	            curLev = root;//逐层遍历
	            while(curLev != null){//从左到右
	                curLev.left. next = curLev.right;
	                if(curLev . next != null)
	                    curLev . right . next = curLev . next . left;
	                curLev = curLev . next;
	            }
	            root = root . left;//下一层
	        }
	}
	public TreeLinkNode f(TreeLinkNode r)//不行
	{
		
		if(r.left==null)
			return null;
		//System.out.println(r.val);
		TreeLinkNode left=f(r.left);
		TreeLinkNode right=f(r.right); 
		if(left!=null)
			left.next=right;
		r.left.next=r.right;
		return r;
	}
	
	public void h()//超时
	{
		if(s.size()==0)
			return ;
		int tempcount=1;
		TreeLinkNode pre=s.pop();
		s.push(pre.left);
		
		while(!s.empty())
		{
			
		}
		
	}
	public static void main(String[] args) {
		Problem116 p=new Problem116();
		TreeLinkNode t1=new TreeLinkNode(1),t2=new TreeLinkNode(2),t3=new TreeLinkNode(3);
		t1.left=t2;
		t1.right=t3;
		p.connect(t1); 
		System.out.println(t1.left.val);
		System.out.println(t1.left.next);
	}
}
