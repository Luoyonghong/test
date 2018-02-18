package LeetCode120AndLater;

import java.util.HashMap;
import java.util.HashSet;

class RandomListNode
{
	int label;
	RandomListNode next, random;

	RandomListNode(int x)
	{
		this.label = x;
	}
};

public class Problem138
{
	HashMap<RandomListNode, RandomListNode> map=new HashMap<>();
	public RandomListNode copyRandomList(RandomListNode head)
	{
		RandomListNode t= f(head);
		g(head);
		return t;
	}
	public RandomListNode f(RandomListNode r)
	{
		if(r==null)
			return null;
		
		RandomListNode t=new RandomListNode(r.label);
		map.put(r, t);
		t.next=f(r.next);
		//t.random=f(r.random);
		return t;	
	}
	
	public void g(RandomListNode r)
	{
		if(r==null)
			return ;
		
		map.get(r).random=map.get(r.random);
		g(r.random);
		
	}
	public static void main(String[] args)
	{
		Problem138 p=new Problem138();
		HashSet<RandomListNode> h=new HashSet<>();
		RandomListNode t1=new RandomListNode(2),t2=new RandomListNode(2);
		h.add(t1);
		h.add(t2);
		System.out.println(h.size()); 
	}
}
