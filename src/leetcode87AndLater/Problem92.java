package leetcode87AndLater;

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}

public class Problem92
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		
		int count=1;
		ListNode begin = null,end,before;
		ListNode beforeBegin=new ListNode(0);
		beforeBegin.next=head;
		before=beforeBegin;
		ListNode r=beforeBegin;
		while(head!=null)
		{
			if(m==count)
			{
				beforeBegin=before;
				begin=head;
			}
			else if(count>m&&count<n)
			{
				ListNode next=head.next;
				head.next=before;
				before=head;
				head=next;
				count++;
				continue;
			}
			else if(count==n)
			{
				System.out.println("hh"); 
				end=head;
				ListNode next=head.next;
				head.next=before;
				before=head;
				head=next;
				begin.next=next; 
				beforeBegin.next=end;
				count++;
				continue;
			}
			count++;
			before=head;
			head=head.next;
		}
		return r.next;
	}
	public static void main(String[] args)
	{
		Problem92 p=new Problem92();
		ListNode t=new ListNode(1);
		ListNode head=t;
		t.next=new ListNode(2);t=t.next;
		t.next=new ListNode(3);t=t.next;
		t.next=new ListNode(4);t=t.next;
		t.next=new ListNode(5);t=t.next;
		ListNode f=p.reverseBetween(head, 1, 5);
		while(f!=null)
		{
			System.out.println(f.val);
			f=f.next;
		}
	}
}
