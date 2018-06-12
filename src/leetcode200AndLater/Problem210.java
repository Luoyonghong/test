package leetcode200AndLater;

import java.util.LinkedList;
import java.util.Queue;

public class Problem210
{
	public int[] findOrder(int numCourses, int[][] prerequisites)
	{
		int[] in=new int[numCourses];//每一门课的入度
		for(int i=0;i<prerequisites.length;i++)
		{
			in[prerequisites[i][0]]++;
		}
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<numCourses;i++)
			if(in[i]==0)
				q.offer(i);
		int[] result=new int[numCourses];
		int count=0;
		boolean used[]=new boolean[numCourses];
		while(q.size()>0)
		{
			int t=q.poll();
			result[count]=t;
			count++;
			for(int i=0;i<prerequisites.length;i++)
			{
				if(prerequisites[i][1]==t)
					in[prerequisites[i][0]]--;
//				采用Boolean数组来鉴别是否放进去过，或者把下面的if放到上面的if里面去
//				if(prerequisites[i][1]==t)
//				{
//					in[prerequisites[i][0]]--;
//					//必须是当前时刻被减少到0的才能加进去，下面的if放外面的话，会有很多以前就被减少为0的节点被放入队列
//					if(in[prerequisites[i][0]]==0)
//						q.offer(prerequisites[i][0]);
//				}
				if(!used[prerequisites[i][0]]&&in[prerequisites[i][0]]==0)
                {
					q.offer(prerequisites[i][0]);
                    used[prerequisites[i][0]]=true;
                }
			}
		}
		if(count==numCourses)
			return result;
		else
			return new int[]{};
	}
}
