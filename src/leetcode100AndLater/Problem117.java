package leetcode100AndLater;

public class Problem117
{
	public void connect(TreeLinkNode root)
	{
		if (null == root)
			return;
		TreeLinkNode curLev;
		while (root != null && (root.left != null || root.right != null || root.next != null))
		{
			curLev = root;// 逐层遍历
			System.out.println(curLev.val);
			while (curLev != null)
			{// 从左到右
				if (curLev.left == null && curLev.right == null)
				{
					curLev = curLev.next;
					continue;
				}
				if (curLev.left != null && curLev.right != null)
					curLev.left.next = curLev.right;
				if (curLev.next != null)
				{
					TreeLinkNode temp = curLev.next;
					while (temp != null && temp.left == null && temp.right == null)
						temp = temp.next;// 找到同一层中有孩子的节点
					if (temp != null && curLev.right != null)// next指向兄弟的孩子
						curLev.right.next = temp.left != null ? temp.left : temp.right;
					else if (temp != null && curLev.left != null)
						curLev.left.next = temp.left != null ? temp.left : temp.right;
				}
				curLev = curLev.next;
			}
			while (true)
			{// 找下一层中第一个有孩子的节点
				if (root == null)
					break;
				if (root.left == null && root.right == null)
					root = root.next;
				else
				{
					root = root.left != null ? root.left : root.right;
					System.out.println("next" + root.val);
					break;
				}
			}
			// 下一层
		}
	}
}
