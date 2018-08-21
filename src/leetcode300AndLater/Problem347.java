package leetcode300AndLater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem347
{
	class Node
	{
		int count;
		int val;
		public Node(int a, int b)
		{
			count=a;
			val =b;
		}
	}
	public List<Integer> topKFrequent(int[] nums, int k)
	{
		Arrays.sort(nums);
		List<Node> l=new ArrayList<>();
		int t=nums[0];
		int count=1;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]==t)
			{
				count++;
			}
			else
			{
				l.add(new Node(count,t));
				t=nums[i];
				count=1;
			}
		}
		l.add(new Node(count,t)); 
		Collections.sort(l,new Comparator<Node>()
		{

			@Override
			public int compare(Node o1, Node o2)
			{
				// TODO Auto-generated method stub
				return o2.count-o1.count;
			}
		});
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<k;i++)
			result.add(l.get(i).val);
		return result;
		
	}
	
	public void downadjust(int [] nums, int i, int length)
	{
		int leftindex=2*i+1,rightindex=2*i+2;
		if(rightindex>=length)
			return;
		int leftchild=nums[leftindex],rightchild=nums[rightindex];
		
	}
}
