package leetcode140AndLater;

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
		next = null;
	}
}

public class Problem141
{
	public boolean hasCycle(ListNode head)
	{
		ListNode r=head;
		if(head==null)
			return false;
		ListNode fast = head;  
	        ListNode slow = head;  
	  
	        while (fast.next != null) {  
	            fast = fast.next.next;  
	  
	            if (fast == null) {  
	                return false;  
	            }  
	  
	            slow = slow.next;  
	              
	            if (fast == slow) {  
	                return true;  
	            }  
	        }  
	  
	        return false;  
	}
}
