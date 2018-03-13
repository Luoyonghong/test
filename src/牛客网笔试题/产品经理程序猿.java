package 牛客网笔试题;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Idea
{
	int proposeTime;
	int prioty;
	int needTime;
	int pmId;
	Idea(int ptime, int pri , int needtime,int pmid)
	{
		proposeTime=ptime;
		prioty=pri;
		needTime=needtime;
		pmId=pmid;
	}
	
}
public class 产品经理程序猿
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int p=scan.nextInt();
		List<PriorityQueue> pmIdeas=new ArrayList<PriorityQueue>();
		for(int i=0;i<n;i++)
		{
			PriorityQueue<Idea> t=new PriorityQueue<Idea>(100,new Comparator<Idea>()
			{

				@Override
				public int compare(Idea i1, Idea i2)
				{
					// TODO Auto-generated method stub
					if(i1.prioty!=i2.prioty)
						return i2.prioty-i1.prioty;
					else if(i1.needTime!=i2.needTime)
						return i2.needTime-i1.needTime;
					else 
					{
						return i2.proposeTime-i1.proposeTime;
					}
				}
			});
			pmIdeas.add(t);//最大堆
		}
		for(int i=0;i<p;i++)
		{
			int pmid=scan.nextInt();
			int proposetime=scan.nextInt();
			int prioty=scan.nextInt();
			int needtime=scan.nextInt();
			Idea idea=new Idea(proposetime, prioty, needtime, pmid);
			pmIdeas.get(pmid-1).offer(idea);
		}
		
	}
	
	
}
