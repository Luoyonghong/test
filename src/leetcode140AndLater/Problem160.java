package leetcode140AndLater;

public class Problem160
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		int n1=0,n2=0;
		ListNode back1=headA,back2=headB;
		while(headA!=null)
		{
			headA=headA.next;
			n1++;
		}
		while(headB!=null)
		{
			headB=headB.next;
			n2++;
		}
		
		headA=back1;
		headB=back2;
		while(n1>0&&n2>0)
		{
			if(n1>n2)
			{
				headA=headA.next;
				n1--;
				continue;
			}
			if(n1<n2)
			{
				headB=headB.next;
				n2--;
				continue;
			}
			if(n1==n2)
			{
				if(headA==headB)
					return headA;
				headA=headA.next;
				headB=headB.next;
				n1--;
				n2--;
				
			}
			
		}
		return null;
		
	}
}
