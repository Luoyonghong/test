package leetcode;

class ListNode {
    int val;
    ListNode next;
   ListNode(int x) { val = x; }
}
public class Problem2 {

	
	public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l=new ListNode(0);
		ListNode lOrignl=l;
		boolean isMax10=false;
		
		isMax10=false;
		l.val=(l1.val+l2.val)%10;
		if(l1.val+l2.val>=10)
			isMax10=true;
		l1=l1.next;
		l2=l2.next;
		
		while(l1!=null||l2!=null||isMax10==true)
		{
			if(l1==null)
				l1=new ListNode(0);
			if(l2==null)
				l2=new ListNode(0);
			if(isMax10)
			{
				l.next=new ListNode((l1.val+l2.val+1)%10);
				if(l1.val+l2.val+1>=10)
					isMax10=true;
				else
					isMax10=false;
			}
			else
			{
				l.next=new ListNode((l1.val+l2.val)%10);
				if(l1.val+l2.val>=10)
					isMax10=true;
				else
					isMax10=false;
			}
			
			l1=l1.next;
			l2=l2.next;
			l=l.next;
		}
		return lOrignl;
        
    }
}
