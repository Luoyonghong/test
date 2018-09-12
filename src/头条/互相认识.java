package 头条;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class 互相认识
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		//System.out.println(n); 
		List<List<Integer>> l=new ArrayList<>();
		//sc.nextLine();
		for(int i=0;i<n;i++)
		{
			List<Integer> now=new ArrayList<>();
			int t=0;
			t=sc.nextInt();
			while(t!=0)
			{
				now.add(t);
				t=sc.nextInt();
			}
			l.add(now);
			//System.out.println(now); 
		}
		for(int i=0;i<n;i++)
			System.out.println(l.get(i)); 
		
		int sum=0;
		Queue<Integer> q=new LinkedList<>();
		boolean[] isued=new boolean[n];
		for(int i=0;i<n;i++)
		{
			q.clear();
			if(!isued[i])
			{
				q.add(i);
				isued[i]=true;
				while(!q.isEmpty())
				{
					int haha=q.poll();
					List<Integer> renshideren2=l.get(haha);
					isued[haha]=true;
					for(int j=0;j<renshideren2.size();j++)
					{
						int haha2=renshideren2.get(j)-1;
						if(!isued[haha2])
						{
							q.add(haha2);
							isued[haha2]=true;
						}
					}
				}
				sum++;
			}
			System.out.println(sum); 
		}
		System.out.println(sum); 

	}
}
