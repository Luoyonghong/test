package 头条;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 程序猿 {
	static class Idea
	{
		int pmid,prioty,begin,cost;
		int comple;
		public Idea(int a,int b,int c, int d)
		{
			pmid=a;
			begin=b;
			prioty=c;
			cost=d;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt(),m=sc.nextInt(), p=sc.nextInt();
		List<Idea> forout=new ArrayList<>(n);
		List<PriorityQueue<Idea>> l=new ArrayList<>(n);
		PriorityQueue<Idea> allideas=new PriorityQueue<Idea>(p, new Comparator<Idea>() {

			@Override
			public int compare(Idea o1, Idea o2) {
				// TODO Auto-generated method stub
				return o1.begin-o2.begin;
			}
		});//按照时间排序
		//N个PM，M个程序员，P个idea。
		for(int i=0;i<n;i++)
		{
			l.add(new PriorityQueue<Idea>(new Comparator<Idea>() {

				@Override
				public int compare(Idea o1, Idea o2) {
					// TODO Auto-generated method stub
					if(o1.prioty!=o2.prioty)
						return o2.prioty-o1.prioty;
					else if(o1.cost!=o2.cost)
						return o1.cost-o2.cost;
					else
						return o1.begin-o2.begin;
				}
			}));
		}
		//n个优先队列，对应N个PM
		for(int i=0;i<p;i++)
		{
			int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
			Idea dea=new Idea(a, b, c, d);
			forout.add(dea);
			allideas.add(dea);
		}
		
		int [] chengxuyuan=new int[m];//代表到什么时刻是忙的,包括当前时刻
		
		for(int time=1;time<=3000;time++)
		{
			while(!allideas.isEmpty()&&allideas.peek().begin<=time)
			{
				Idea dea=allideas.poll();
				//System.out.println(dea.begin); 
				l.get(dea.pmid-1).add(dea);
			}
			for(int i =0;i<m;i++)
			{
				if(chengxuyuan[i]<time)
				{
					Idea nowidea=new Idea(10000, 10000, 10000, 10000);
					int index=0;
					for(int j=0;j<n;j++)
					{
						Idea d=l.get(j).peek();
						if(d!=null&&d.cost<nowidea.cost)
						{
							nowidea=d;
							index=j;
						}
					}
					if(nowidea.begin==10000)
						continue;
					nowidea=l.get(index).poll();
					nowidea.comple=time+nowidea.cost;
					chengxuyuan[i]=time+nowidea.cost-1;
					//System.out.println("time: "+time+" idea: "+forout.indexOf(nowidea)); 
				}
			}
			
		}
		//System.out.println(); 
		for(int i=0;i<forout.size();i++)
			System.out.println(forout.get(i).comple); 
		
	}
}
