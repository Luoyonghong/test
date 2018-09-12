package 商汤;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 合并果子
{
	static class guozi
	{
		int x,y,w;
		public guozi(int x,int y, int w)
		{
			this.x=x;
			this.y=y;
			this.w=w;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
//		int x[]=new int[n];
//		int y[]=new int[n];
//		int w[]=new int[n];
		guozi[] gs=new guozi[n];
		boolean used[]=new boolean[n];
		PriorityQueue<guozi> weight=new PriorityQueue<guozi>(n, new Comparator<guozi>()
		{

			@Override
			public int compare(guozi o1, guozi o2)
			{
				// TODO Auto-generated method stub
				return o1.w-o2.w;
			}
			
		});
		for(int i=0;i<n;i++)
		{
//			x[i]=sc.nextInt();
//			y[i]=sc.nextInt();
//			w[i]=sc.nextInt();
			int x=sc.nextInt(),y=sc.nextInt(),w=sc.nextInt();
			guozi t=new guozi(x,y,w);
			weight.add(t);
			gs[i]=t;
		}
		//每次移动w最小的，然后寻找最近的，合并
		int sum=0;
		for(int i=0;i<n-1;i++)
		{
			guozi t=weight.poll();
			System.out.println(t.w); 
			Iterator<guozi> iter=weight.iterator();
			int nowmincost=Integer.MAX_VALUE;
			guozi now=null;
			while(iter.hasNext())
			{
				guozi tt=iter.next();
				int nowcost=t.w*(Math.abs(tt.x-t.x)+Math.abs(tt.y-t.y));
				if(nowcost<nowmincost)
				{
					nowmincost=nowcost;
					now=tt;
				}
			}
			sum+=nowmincost;
			weight.remove(now);
			weight.add(new guozi(now.x,now.y,now.w+t.w));
		}
		System.out.println(sum); 
	}
}

