import java.util.Deque;
import java.util.LinkedList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class 最大滑动窗口
{

	public static int[] maxSlidingWindow(int [] num, int w)
	{
		int result[]=new int[num.length-w+1];
		int index=0;
		Deque<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<num.length;i++)
		{
			while(!q.isEmpty()&&(i-q.getFirst())>=w)
				q.pollFirst();
			while(!q.isEmpty()&&num[q.getLast()]<num[i])
			{
				q.pollLast();
			}
			q.offerLast(i);
			if(i>=w-1)
			{
				result[index]=num[q.getFirst()];
				index++;
			}
		}
		return result;	
	}
	public static void main(String[] args)
	{
		int [] num={2,3,4,2,6,2,5,1};
		int[] t=maxSlidingWindow(num, 3);
		for (int i : t)
		{
			System.out.println(i); 
		}
	}
}
