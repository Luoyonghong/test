package leetcode100AndLater;

 class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }

public class Problem109 {
	ListNode node=null;
	public TreeNode sortedListToBST(ListNode head) {
		node=head;
		int length=0;
		while(head!=null)
		{
			length++;
			head=head.next;
		}
		return h(0, length,length);
	}
	
	public TreeNode h(int begin, int end,int length)
	{
		if(begin==end)
		{
			TreeNode t=new TreeNode(node.val);
			node=node.next;
			return t;
		}
		if(begin>end||end>length)
		{
			return null;
		}
		int middle=(begin+end)/2;
		TreeNode left=h(begin,middle-1,length);
		
		TreeNode t=new TreeNode(node.val);
		node=node.next;
		t.left=left;
		
		TreeNode right=h(middle+1,end,length);
		t.right=right;
		
		return t;
	}
}
