package 携程;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main
{

	/*
	 * A2B3D 
	 * A4C2E 
	 * A5D 
	 * C3B
	 */

	/*
	 * 请完成下面这个函数，实现题目要求的功能 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 开始写代码
	 ******************************/
	static int calculate(int M, String[] strs)
	{
		int map[][]=new int[5][5];
		for(int i=0;i<strs.length;i++)
		{
			String s=strs[i];
			for(int j=0;2*j+1<s.length();j++)
			{
				map[s.charAt(2*j)-'A'][s.charAt(2*j+2)-'A']=Integer.parseInt(s.charAt(2*j+1)+""); 
			}
		}
		if(!isCycle(map, 5))
		{
			return -1;
		}
		else
		{
			//深度优先遍历
			
			for(int i=0;i<5;i++)
			{
				if(!used[i])
				{
					used[i]=true;
					count+=1;
					DFS(map,i);
					used[i]=false;
					count-=1;
				}
			}
		}
		return max;

	}
	static int length=0,max=-1;
	static int count=0;
	static boolean used[]=new boolean[5];
	public static void DFS(int[][] map,int nowIndex)
	{
		if(length>max)
			max=length;
		for(int i=0;i<5;i++)
		{
			if(!used[i])
			{
				if(map[nowIndex][i]>0)
				{
					used[i]=true;
					length+=map[nowIndex][i];
					count+=1;
					DFS(map,i);
					length-=map[nowIndex][i];
					used[i]=false;
					count-=1;
				}
			}
		}
	}
	public  static boolean isCycle(int[][] prerequisites,int num)//无环 正， 有环负
	{
		int [] in=new int[num];
		for(int i=0;i<prerequisites.length;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(prerequisites[i][j]>0)
					in[j]++;
			}
		}
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=0;i<in.length;i++)
		{
			if(in[i]==0)
				q.offer(i);
		}
		//System.out.println(q.size());
		int count=0;
		//boolean used[]=new boolean [numCourses];
		while(q.size()>0)
		{
			int t=q.poll();
			count++;
			//used[t]=true;
			for(int i=0;i<prerequisites.length;i++)
			{
				if(prerequisites[t][i]>0)
				{
					in[i]--;
					if(in[i]==0)
						q.offer(i);
				}
			}
		}
		if(count==num)
			return true;
		else
			return false;
	}

	/****************************** 结束写代码 ******************************/

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int res;

		int _M;
		_M = Integer.parseInt(in.nextLine().trim());

		int _strs_size = _M;
		String[] _strs = new String[_strs_size];
		String _strs_item;
		for (int _strs_i = 0; _strs_i < _strs_size; _strs_i++)
		{
			try
			{
				_strs_item = in.nextLine();
			} catch (Exception e)
			{
				_strs_item = null;
			}
			_strs[_strs_i] = _strs_item;
		}

		res = calculate(_M, _strs);
		System.out.println(String.valueOf(res));

	}
}