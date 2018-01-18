package leetcode71AndLater;

public class Problem86
{
	
	public ListNode partition(ListNode head, int x)
	{	
		ListNode t=new ListNode(0);
		ListNode back=t;
		ListNode tt=new ListNode(0),ttt=tt;
		while(head!=null)
		{
			if(head.val<x)
			{
				ListNode temp=head;
				head=head.next;
				temp.next=null;
				t.next=temp;
				t=t.next;
			}
			else
			{
				ListNode temp=head;
				head=head.next;
				temp.next=null;
				tt.next=temp;
				tt=tt.next;
			}
		}
		t.next=ttt.next;
		return back.next;
	}
	public static void main(String[] args)
	{
		ListNode head=new ListNode(2);
		ListNode back=head;
		head.next=new ListNode(1);
		ListNode t=new Problem86().partition(back, 2);
		while(t!=null)
		{
			System.out.println(t.val);
			t=t.next;
		}
	}
}
