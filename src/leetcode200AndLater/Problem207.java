package leetcode200AndLater;

import java.util.LinkedList;
import java.util.Queue;

public class Problem207
{
	public boolean canFinish(int numCourses, int[][] prerequisites)
	{
		int [] in=new int[numCourses];
		for(int i=0;i<prerequisites.length;i++)
		{
			in[prerequisites[i][0]]++;
		}
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=0;i<in.length;i++)
		{
			if(in[i]==0)
				q.offer(i);
		}
		System.out.println(q.size());
		int count=0;
		//boolean used[]=new boolean [numCourses];
		while(q.size()>0)
		{
			int t=q.poll();
			count++;
			//used[t]=true;
			for(int i=0;i<prerequisites.length;i++)
			{
				if(prerequisites[i][1]==t)
				{
					in[prerequisites[i][0]]--;
					if(in[prerequisites[i][0]]==0)
						q.offer(prerequisites[i][0]);
				}
			}
		}
		if(count==numCourses)
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		Problem207 p=new Problem207();
		int [][]prerequisites={};
		System.out.println(p.canFinish(2, prerequisites));
	}
}
