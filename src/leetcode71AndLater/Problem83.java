package leetcode71AndLater;



public class Problem83
{

	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode back=new ListNode(0);
		back.next=head;
		ListNode last=back;
		while(head!=null)
		{
			if(head.next!=null)
			{
				if(head.val==head.next.val)
				{
				//ListNode t=head.next;
					while(head.next!=null&&head.next.val==head.val)
						head=head.next;
					last.next=head;
					last=head;
					head=head.next;
					continue;
				}
				else
				{
					last.next=head;
					last=head;
					head=head.next;
					continue;
				}
			}
			else
			{
				last.next=head;
				last=head;
				last.next=null;
				break;
			}
		}
		last.next=null;
		return back.next;
	}
	public static void main(String[] args)
	{
		Problem83 p=new Problem83();
		ListNode head=new ListNode(1);
		ListNode backup=head;
		head.next=new ListNode(1);head=head.next;
		head.next=new ListNode(3);head=head.next;
		head.next=new ListNode(3);head=head.next;
		head.next=new ListNode(4);head=head.next;
		head.next=new ListNode(4);head=head.next;
		head.next=new ListNode(7);head=head.next;
		
		head=backup;
		head=p.deleteDuplicates(head);
		while(head!=null)
		{
			System.out.println(head.val);
			head=head.next;
		}
	}
}
