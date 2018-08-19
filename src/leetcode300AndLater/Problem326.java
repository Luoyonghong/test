package leetcode300AndLater;

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}

public class Problem326
{
	public ListNode oddEvenList(ListNode head)
	{
		//0 2 4...在前面，单数在后面
		ListNode oushu=new ListNode(0),jishu=new ListNode(0);
		ListNode jishuback=jishu,oushuback=oushu;
		int index=0;
		
		while(head!=null)
		{
			ListNode t=head.next;
			if(index%2==1)
			{
				jishu.next=head;
				head.next=null;
				jishu=jishu.next;
			}	
			else
			{
				oushu.next=head;
				head.next=null;
				oushu=oushu.next;
			}
			head=t;
			index++;
		}
		oushu.next=jishuback.next;
		return oushuback.next;
	}
	public static void main(String[] args)
	{
		Problem326 p=new Problem326();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		ListNode t7=new ListNode(7);
		t1.next=t2;
		t2.next=t3;
		t3.next=t4;
		t4.next=t5;
		t5.next=t6;
		t6.next=t7;
		ListNode test=p.oddEvenList(t1);
		while(test!=null)
		{
			System.out.println(test.val);
			test=test.next;
		}
		
	}
}
