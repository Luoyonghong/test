package leetcode;

import leetcode.Problem23.ListNode;

public class Problem24 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if(head==null)
			return null;
		ListNode l=null;
		if(head.next!=null)
			l=head.next;
		if(head.next==null)
			return head;
		
		ListNode before=new ListNode(-1);
		//head=head.next;
		while(head!=null)
		{
			if(head.next!=null)
			{
				ListNode next=head.next;
				head.next=next.next;
				next.next=head;
				head=head.next;
				before.next=next;
				before=next.next;
				//System.out.println(next.val);
				//System.out.println(next.next.val); 
				//System.out.println(head.val);
				//System.out.println(before.val);
			}
			else
			{
				//before.next=head;
				head=head.next;
				
			}
			
		}
		
		return l;
	}
	public static void main(String[] args) {
		ListNode l1=new ListNode(0);
		//l1.next=new ListNode(1);
		//l1.next.next=new ListNode(4);
		//l1.next.next.next=new ListNode(5);
		ListNode l=swapPairs(null);
		while(l!=null)
		{
			System.out.println(l.val); 
			l=l.next;
		}
	}
}
