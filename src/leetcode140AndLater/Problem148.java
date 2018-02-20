package leetcode140AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem148
{
	public ListNode sortList(ListNode head)
	{
		if(head==null)
			return null;
		List<ListNode> r=new ArrayList<>();
		ListNode back=head;
		int count=0;
		while(head!=null)
		{
			if(count%2==0)
			{
				r.add(head);
				head=head.next;
				count++;
			}
			else
			{
				ListNode t=head.next;
				head.next=null;
				head=t;
				count++;
			}
		}//分成两两一对，最后要置null
		for (int i=0;i<r.size();i++)
		{
			ListNode node=r.get(i);
			if(node.next!=null&&node.next.val<node.val)
			{
				ListNode n=node.next;
				node.next=null;
				n.next=node;
				r.set(i, n);
			}
		}//排序最开始的队
		
		while(r.size()>1)
		{
			int index=0;
			count=r.size();
			int step=0;
//			for (ListNode listNode : r)
//			{
//				print(listNode);
//			}
			
			
			while(step<(count+1)/2)
			{
				ListNode node1=r.get(index);
				ListNode node2=index+1==r.size()?null:r.get(index+1);
				ListNode pre=new ListNode(-1);
				ListNode newNode=null;
				if(node2==null||node1.val<node2.val)
				{
					newNode=node1;
					node1=node1.next;
				}
				else
				{
					newNode=node2;
					node2=node2.next;
				}
				pre.next=newNode;
				while(node1!=null||node2!=null)
				{
					if(node2==null)
					{
						ListNode n=node1.next;
						newNode.next=node1;
						newNode=newNode.next;
						node1.next=null;
						node1=n;
					}
					else if(node1==null)
					{
						ListNode n=node2.next;
						newNode.next=node2;
						newNode=newNode.next;
						node2.next=null;
						node2=n;
					}
					else if(node2.val>node1.val)
					{
						ListNode n=node1.next;
						newNode.next=node1;
						newNode=newNode.next;
						node1.next=null;
						node1=n;
					}
					else
					{
						ListNode n=node2.next;
						newNode.next=node2;
						newNode=newNode.next;
						node2.next=null;
						node2=n;
					}
				}
				r.set(index, pre.next);
				if(index+1<r.size())
					r.remove(index+1);
				index+=1;
				step+=1;
			}
		
		}
		
		return r.get(0);
	}
	
	public void print(ListNode n)
	{
		while(n!=null)
		{
			System.out.print(n.val+" ");
			n=n.next;
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Problem148 p=new Problem148();
		ListNode t1=new ListNode(4);
		ListNode t2=new ListNode(6);
		ListNode t3=new ListNode(7);
		ListNode t4=new ListNode(1);
		ListNode t5=new ListNode(9);
		ListNode t6=new ListNode(-100);
		t1.next=t2;
		t2.next=t3;
		t3.next=t4;
		t4.next=t5;
		t5.next=t6;
		ListNode r=p.sortList(t1);
		while(r!=null)
		{
			System.out.print(r.val+" ");
			r=r.next;
		}
		System.out.println();
		
	}
}
