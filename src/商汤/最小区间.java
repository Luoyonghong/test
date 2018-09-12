package 商汤;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最小区间
{
	static class my
	{
		int index;//第几个堆的元素
		int value;
		public my(int x, int y)
		{
			index=x;
			value=y;
		}
		public String toString()
		{
			return "index: "+index+" value: "+value;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int k=sc.nextInt(),n=sc.nextInt();
		int nums[][]=new int[k][n];
		//k个数组，n个元素
		for(int i=0;i<k;i++)
			for(int j=0;j<n;j++)
			{
				nums[i][j]=sc.nextInt();
			}
		//取k个放到堆，每次删除最小的，然后取下一个
		int indexs[]=new int[k];//每个数字当前已经放入堆的index
		PriorityQueue<my> que=new PriorityQueue<my>(k,new Comparator<my>()
		{

			@Override
			public int compare(my o1, my o2)
			{
				// TODO Auto-generated method stub
				return o1.value-o2.value;
			}
		});
		int nowmaxvalue=Integer.MIN_VALUE;
		for(int i=0;i<k;i++)
		{
			my t=new my(i,nums[i][0]);
			que.add(t);
			nowmaxvalue=t.value>nowmaxvalue?t.value:nowmaxvalue;
		}
		int left=que.peek().value,right=nowmaxvalue,nowleft=left,nowright=right;
		int qujian=right-left;
		for(int i=0;i<(n-1)*k;i++)
		{
			//System.out.print("left: "+left+" right: "+right); 
			my t=que.poll();
			//System.out.println(t); 
			int next=0;
			if(indexs[t.index]==n-1)
			{
				for(int j=0;j<k;j++)
					if(indexs[j]<n-1)
					{
						next=j;
						break;
					}
			}
			else
				next=t.index;
			
			my add=new my(next, nums[next][indexs[next]+1] );
			//System.out.println(add); 
			que.add(add);
			indexs[next]+=1;
			
			if(add.value>nowright)
				nowright=add.value;
			nowleft=que.peek().value;
			//System.out.println(" nowleft: "+nowleft+" nowright:  "+nowright);  
			if(nowright-nowleft<qujian)
			{
				qujian=nowright-nowleft;
				left=nowleft;
				right=nowright;
			}
		}
		System.out.println(left+" "+right); 
	}
}
