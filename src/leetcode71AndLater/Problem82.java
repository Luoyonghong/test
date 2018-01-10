package leetcode71AndLater;

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}
public class Problem82
{

	

	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode backup=new ListNode(0);
		backup.next=head;
		ListNode last=backup;//last表示结果，即删除重复后的node
		//func(head, last);//或者使用此函数，注释掉while循环和之后的if
		while(head!=null)
		{
			if(head.next!=null)
			{
				if(head.val==head.next.val)
				{
					while(head.next!=null&&head.val==head.next.val)
						head=head.next;
					head=head.next;//head跳过此次所有重复值11112 跳到2，且last不做任何变化
					continue;
				}
				else
				{
					last.next=head;//head和之后的节点不同，而由于head一定与之前的也不同，所以保留head，并向前移一位
					last=head;
					head=head.next;
					continue;
				}
			}
			if(head!=null&&head.next==null)//head是最后一个数且不重复11223或者1123，head指向了3
			{
				last.next=head;
				break;
			}
		}
		if(head==null) //head跳过了所有重复的，112233这种情况，head直接指向空
		{
			last.next=null;
		}
		return backup.next;
	}
	public void func(ListNode head,ListNode last)
	{
		if(head==null)
		{
			last.next=head;
			return;
		}
		if(head!=null&&head.next==null)
		{
			last.next=head;
			return;
		}//总之，head与其前一个不同，若下一个是空，则保留head
		if(head!=null&&head.next!=null)
			if(head.val==head.next.val)
			{
				while(head.next!=null&&head.val==head.next.val)
					head=head.next;
				head=head.next;//head跳过了所有当前重复的
				//System.out.println(head.val);
				func(head, last); 
			}
			else
			{
				last.next=head;
				last=head;
				head=head.next;
				func(head, last);
			}
		
	}
	public static void main(String[] args)
	{
		Problem82 p=new Problem82();
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
