package 牛客网笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode
{
	int n;
	public TreeNode(int t)
	{
		n=t;
	}
	TreeNode left,right;
}

public class 游历魔法王国
{
	static boolean[] used;
	static int [] p;
	static int count=1;
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int l=scan.nextInt();
		p=new int[n-1];
		for(int i=0;i<p.length;i++)
		{
			p[i]=scan.nextInt();
		}
		used=new boolean[n];
		used[0]=true;
		f(l,0);
		System.out.println(count); 
	}
	//p[i]是第i+1的父亲，可以从p[i]走到i+1
	public static void f(int l,int n)
	{
		if(l==0)
		{
			int temp=0;
			for (int i = 0; i < used.length; i++)
			{
				if(used[i])
					temp++;
			}
			if(temp>count)
				count=temp;
		}
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<p.length;i++)
		{
			if(p[i]==n)
				list.add(i+1);
		}
		for (Integer in : list)
		{
			used[in]=true;
			f(l-1, in);
			used[in]=false;
		}
		
	}
}
