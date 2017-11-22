package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.Problem21.ListNode;

public class Problem23
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
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode t=new ListNode(0); 
		ListNode tt=t;
		while(l1!=null||l2!=null)
		{
			if((l2==null&&l1!=null)||(l1!=null&&l2!=null&&l1.val<=l2.val))
			{
				t.next=l1;
				l1=l1.next;
				t=t.next;
			}
			if((l1==null&&l2!=null)||(l1!=null&&l2!=null&&l1.val>l2.val))
			{
				t.next=l2; 
				l2=l2.next;
				t=t.next;
			}
		}
		return tt.next;
	}
	public static ListNode mergeKLists(ListNode[] lists)
	{
		if(lists.length==0)
            return null;
		return mergeTwoLists(helper(lists,0,lists.length/2),helper(lists,lists.length/2+1,lists.length-1));
	}
	public static ListNode helper(ListNode[] lists,int left,int right)
	{
		if(left<right)
		{
			if(left+1==right)
				return mergeTwoLists(lists[left],lists[right]);
			
			return mergeTwoLists(helper(lists,left,(left+right)/2),helper(lists,(left+right)/2+1,right));
		}
		if(left==right)
			return lists[left];
		return null;
	}
	
	public static boolean  isAllEnd(ListNode[] lists,int[] b)
	{
		b[0]=0;
		for(int i=0;i<lists.length;i++)
		{
			if(lists[i]!=null)
			{
				if(b[0]<i)
				{
					lists[b[0]]=lists[i];
					lists[i]=null;
				}
				b[0]++;
			}
		}
		if(b[0]>0)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args)
	{
		ListNode l1=new ListNode(0);
		l1.next=new ListNode(1);
		l1.next.next=new ListNode(4);
		ListNode l2=new ListNode(2);
		l2.next=new ListNode(3);
		l2.next.next=new ListNode(5);
		l2.next.next.next=new ListNode(9);
		ListNode l3=new ListNode(0);
		l3.next=new ListNode(8);
		l3.next.next=new ListNode(10);
		l3.next.next.next=new ListNode(10);
		l3.next.next.next.next=new ListNode(10);
		
		ListNode[] lists=new ListNode[3];
		lists[0]=null;
		lists[1]=null;
		lists[2]=null;
		ListNode t=mergeKLists(lists);
		while(t!=null)
		{
			System.out.println(t.val);
			t=t.next;
		}
	}
}
