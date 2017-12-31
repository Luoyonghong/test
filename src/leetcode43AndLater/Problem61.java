package leetcode43AndLater;

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}
public class Problem61
{
	

	public ListNode rotateRight(ListNode head, int k)
	{
		if(head==null)
			return head;
		ListNode back=head;
		ListNode last=null;
		int n=0;
		while(head!=null)
		{
			n++;
			if(head!=null&&head.next==null)
				last=head;
			head=head.next;
			
		}
		k%=n;
		//System.out.println(last.val); 
		int left=n-k;
		head=back;
		while(head!=null&&left>1)
		{
			left--;
			head=head.next;
		}
			
		//System.out.println(head.val); 
		//System.out.println(head.next.val);
		last.next=back;
		back=head.next;
		head.next=null;
		return back;
	}

	public static void main(String[] args)
	{
		ListNode l=new ListNode(1);
		ListNode head=l;
		l.next=new ListNode(2); l=l.next;
//		l.next=new ListNode(3); l=l.next;
//		l.next=new ListNode(4); l=l.next;
//		l.next=new ListNode(5); l=l.next;
		Problem61 p=new Problem61();
		head=p.rotateRight(head, 2);
		
		while(head!=null)
		{
			System.out.println(head.val);
			head=head.next;
		}
	}
}
