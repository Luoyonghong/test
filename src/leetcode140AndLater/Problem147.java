package leetcode140AndLater;

public class Problem147
{
	public ListNode insertionSortList(ListNode head)
	{
		if(head==null)
			return null;
		ListNode t=head;
		ListNode before=new ListNode(Integer.MIN_VALUE);//需要新建一个链表，这样最后是null
		ListNode beforeback=before;
		//head=before;
		ListNode back=head;

		while(t!=null)
		{
			before=beforeback;
			while(before.next!=null&&before.next.val<t.val)
			{
				before=before.next;
			}
			ListNode tn=t.next;
			
			t.next=before.next;//若找不到比他小的，最后是null
			before.next=t;
			
			t=tn;
			
			
		}
		return beforeback.next;
	}
	
	public ListNode f(ListNode head)
	{
		if(head==null || head.next == null)
		        return head;

		    //创造一个新的链表头部
		    ListNode pre = new ListNode(-1);
		    //用一个临时变量保存头节点
		    ListNode ans = pre;
		    //cur是原链表上的指针
		    ListNode cur = head;
		    while (cur != null) {
		        //每次循环前重置pre为头结点，这样保证每次都从头往后遍历
		        pre = ans;
		        
		        //当pre.next.val大于cur.val时停止循环
		        while (pre.next != null && pre.next.val < cur.val) {
		            pre = pre.next;
		        }

		        //pre.next.val 大于 cur.val，此时应该把cur插入到pre后
		        //保存原链表当前节点的下一节点
		        ListNode tmp = cur.next;
		        //把cur插入到pre之后
		        cur.next = pre.next;
		        pre.next = cur;
		        
		        //cur指针后移一位
		        cur = tmp;
		    }
		    return ans.next;
	}
	public static void main(String[] args)
	{
		Problem147 p=new Problem147();
		ListNode t1=new ListNode(4);
		ListNode t2=new ListNode(6);
		ListNode t3=new ListNode(7);
		ListNode t4=new ListNode(1);
		t1.next=t2;
		t2.next=t3;
		t3.next=t4;
		t1=p.insertionSortList(t1);
		int count=0;
		while(t1!=null&&count<10)
		{
			System.out.println(t1.val); 
			t1=t1.next;
			count++;
		}
	}
}
