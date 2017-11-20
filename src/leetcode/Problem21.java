package leetcode;

import java.util.List;

public class Problem21
{
	static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode t=new ListNode(0); 
		ListNode tt=t;
		while(l1!=null||l2!=null)
		{
			if((l2==null&&l1!=null)||(l1!=null&&l2!=null&&l1.val<=l2.val))
			{
				t.next=l1;
				
				l1=l1.next;
				
				t=t.next;
				
//				System.out.println(t.val);
//				System.out.println(l1.val);
//				System.out.println(l2.val);
				//t=null;
			}
			if((l1==null&&l2!=null)||(l1!=null&&l2!=null&&l1.val>l2.val))
			{
				t.next=l2; 
				//System.out.println(l2.val);
				l2=l2.next;
			
				t=t.next;
				//t=null;
			}
		}
		return tt.next;
	}
	public static void main(String[] args)
	{
		ListNode l1=new ListNode(0);
		l1.next=new ListNode(1);
		l1.next.next=new ListNode(4);
		ListNode l2=new ListNode(2);
		l2.next=new ListNode(3);
		l2.next.next=new ListNode(5);
		l2.next.next.next=new ListNode(9);
		ListNode t=mergeTwoLists(null, l2);
		while(t!=null)
		{
			System.out.println(t.val);
			t=t.next;
		}
	}
}
