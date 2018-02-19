package leetcode140AndLater;

public class Problem143
{
	public void reorderList(ListNode head)
	{
		// int count=0;
		ListNode fast = head, slow = head, h2 = head;
		if(head==null)
			return ;
		while (fast.next != null)
		{
			fast = fast.next;
			if (fast.next != null)
				fast = fast.next;
			else
				break;
			slow = slow.next;
		}
		//slow是前半截最后一个（双数）或者中间一个（单数）
		ListNode pre=null;
		ListNode hshshs=slow;
		slow=slow.next;
		hshshs.next=null;
		while(slow!=null)
		{
			if(slow.next!=null)
			{
				ListNode ne=slow.next;
				slow.next=pre;
				pre=slow;
				slow=ne;
			}
			else
			{
				slow.next=pre;
				break;
			}
		}//翻转后半截的链表
		//slow 是扭转后半截链表后的开始节点
		head=h2;
		while(slow!=null)
		{
			ListNode Hne=head.next;//head的下一个
			ListNode Sne=slow.next;//slow的下一个
			head.next=slow;
			slow.next=Hne;
			head=Hne;
			slow=Sne;	
		}
	}
	
	public static void main(String[] args)
	{
		Problem143 p=new Problem143();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2); t1.next=t2;
		ListNode t3=new ListNode(3);t2.next=t3;
		ListNode t4=new ListNode(4);t3.next=t4;
		ListNode t5=new ListNode(5);t4.next=t5;
		p.reorderList(t1); 
		while(t1!=null)
		{
			System.out.println(t1.val);
			t1=t1.next;
		}
	}
}
