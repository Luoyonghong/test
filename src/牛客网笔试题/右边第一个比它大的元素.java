package 牛客网笔试题;

import java.util.Stack;

public class 右边第一个比它大的元素
{
	static int[] big(int[] nums)
	{
		int [] r=new int[nums.length];
		Stack<Integer> s=new Stack<Integer>();//单调递减栈
		s.push(0);
		for(int i=1;i<nums.length;i++)
		{
			while(!s.empty()&&nums[i]>nums[s.peek()])
			{
				r[s.peek()]=nums[i];
				s.pop();
			}
			s.push(i);
		}
		while(!s.isEmpty())
		{
			r[s.peek()]=Integer.MIN_VALUE;
			s.pop();
		}
		return r;
	}
	public static void main(String[] args)
	{
		//int nums[]={3,7,8,4,7,5};
		int nums[]={9 ,6 ,5 ,7 ,3 ,2 ,1 ,5 ,9 ,10};
		int[] r=big(nums);
		for (int i : r)
		{
			System.out.print(i+" ");
		}
	}
}
