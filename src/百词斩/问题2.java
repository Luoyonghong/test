package 百词斩;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pair
{
	int s,e;
	int count;
	Pair(int a, int b,int c)
	{
		s=a;
		e=b;
		count=c;
	}
}
public class 问题2
{
	
	public static void main(String[] args)
	{
		//5 ：1 3 4 5 7
		// 1 3 5
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int num[]=new int[n];
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		List<Pair> l=new ArrayList<>();
		int last=num[0];
		int count=1;
		for(int i=1;i<n;i++)
		{
			if(num[i]==last+1)
			{
				count++;
				last=num[i];
			}
			else
			{
				if(count>=3)
				{
					Pair p=new Pair(num[i-count],num[i-1],3);
					l.add(p);
				}
				else if(count==2)
				{
					Pair p=new Pair(num[i-count],num[i-1],2);
					l.add(p);
				}
				else
				{
					Pair p=new Pair(-1,num[i-1],1);
					l.add(p);
				}
				
				count=1;
				last=num[i];
			}
		}
		
		if(count>=3)
		{
			Pair p=new Pair(num[n-count],num[n-1],3);
			l.add(p);
		}
		else if(count==2)
		{
			Pair p=new Pair(num[n-count],num[n-1],2);
			l.add(p);
		}
		else
		{
			Pair p=new Pair(-1,num[n-1],1);
			l.add(p);
		}
		String out="";
		for(int i=0;i<l.size();i++)
		{
			Pair p=l.get(i);
			if(p.count==3)
			{
				out+=p.s+"-"+p.e+",";
			}
			else if(p.count==2)
			{
				out+=p.s+","+p.e+",";
			}
			else
				out+=p.e+",";
		}
		out=out.substring(0, out.length()-1);
		System.out.println(out); 
	}
}
