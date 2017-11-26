package leetcode;

import javax.rmi.CORBA.Tie;

import leetcode.Problem23.ListNode;

public class Problem25
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

	public static ListNode reverseKGroup(ListNode head, int k)
	{
		if(k==1)
			return head;
		ListNode t=head,r=head,before=null,next=null,twoRoundT=head;
		//t是本轮的开始那个节点，twoRoundT是前一轮的开始节点
		int totalCount=0;
		while(head!=null)
		{
			totalCount++;
			head=head.next;
		}
		//System.out.println(totalCount);
		if(totalCount<k)
			return r;
		int floop=totalCount/k;
		//System.out.println(floop); 
		int tempFloot=-1;
		boolean isfirst=false;
		int count=1;
		head=r;
		while(head!=null) 
		{
			//System.out.println("aaa" );
			//System.out.println(tempFloot);
			if(tempFloot<floop) 
			{
				if(count==1)
				{
					tempFloot++;
					
					if(floop>=1)
						twoRoundT=t;
					t=head;
					before=head;
					head=head.next;
				}
				else
				{
					if(count!=k)
					{
						next=head.next;
						head.next=before;
						before=head;
						head=next;
					}
					else
					{
						next=head.next;
						head.next=before;
						//t=head;
						t.next=next;//先把t指向下一轮的起始点，但随着更新，t会被赋值给tworoundt，然后next指向下一轮的终点
						if(!isfirst)
						{
							r=head;
							isfirst=true;
						}
						else
						{
							twoRoundT.next=head;
						}
						
						before=head;
						head=next;
						count=0;
					}
				}
			}
			else
				head=head.next;
			count++;
		}
		return r;
	}

	public static void main(String[] args)
	{
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		//l1.next.next=new ListNode(3);
		//l1.next.next.next=new ListNode(4);
		//l1.next.next.next.next=new ListNode(5);
		ListNode l=reverseKGroup(l1,1);
		while(l!=null)
		{
			System.out.println(l.val);
			l=l.next;
		}
	}
}
