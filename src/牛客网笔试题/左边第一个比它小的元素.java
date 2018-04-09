package 牛客网笔试题;

import java.util.Stack;

public class 左边第一个比它小的元素
{
	//也可以做右边第一个比它小！ 比它小就是单调递增栈，比它大就是递减栈！
	//可以用来做最大矩形面积的题，或者最大0 1矩阵中1矩阵面积
	static int[] min(int[] nums)
	{
		int[] r=new int[nums.length];
		r[0]=0;
		Stack<Integer> s=new Stack<Integer>();//递增栈
		s.push(0);
		for(int i=1;i<nums.length;i++)
		{
			while(!s.isEmpty()&&nums[i]<nums[s.peek()])
			{
				s.pop();
			}
			if(!s.isEmpty())
				r[i]=nums[s.peek()];
			else
				r[i]=Integer.MIN_VALUE;
			s.push(i);
		}
		r[0]=Integer.MIN_VALUE;
		return r;
	}
	public static void main(String[] args)
	{
		int[] nums={3,7,8,2,4,7,5};
		int[] r=min(nums);
		for (int i : r)
		{
			System.out.print(i+" "); 
		}
	}
}
