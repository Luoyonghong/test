package leetcode;

public class Problem19
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

	public static ListNode removeNthFromEnd(ListNode head, int n)
	{
		int length=0;
		ListNode l2=head;
		while(head!=null)
		{
			length++;
			head=head.next;
		}
		if(n>length)
			return null;
		int count=0;
		//System.out.println(length); 
		if(length==1&&n==1)
			return null;
		head=l2;
		if(length==n)
		{
			head=head.next;
			return head;
		}
		
		while(head!=null)
		{
			count++;
			ListNode before=head;
			if(count==length-n)
			{
				head.next=head.next.next;
				break;
			}
			head=head.next;
			
		}
		return l2;
	}
	public static void main(String[] args)
	{
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		ListNode l=removeNthFromEnd(head,2);
		while(l!=null)
		{
			System.out.println(l.val);
			l=l.next;
		}
	}
}
