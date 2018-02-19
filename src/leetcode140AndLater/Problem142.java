package leetcode140AndLater;

public class Problem142
{
	public ListNode detectCycle(ListNode head)
	{
		ListNode fast,slow,r;
		fast=head;
		slow=head;
		r=head;
		while(true)
		{
			if (fast == null || fast.next == null) {
			            return null;    //遇到null了，说明不存在环
			        }
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				break;
		}
		while(r!=null)
		{
			if(r==slow)
				break;
			r=r.next;
			slow=slow.next;
		}
		return slow;
		
	}
}
