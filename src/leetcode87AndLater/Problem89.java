package leetcode87AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem89
{
	public List<Integer> grayCode(int n)
	{
		List<Integer> l=new ArrayList<Integer>();
		int count=1;
		double max=Math.pow(2, n);
		char base[] =new char[n];
		for(int j=0;j<n;j++)
			base[j]='0';
		l.add(0);
		boolean dcsend=true;
		int i=n-1;
		while(count<max)
		{
			if(base[i]=='0')
				base[i]='1';
			else
				base[i]='0';
			l.add(Integer.parseInt(new String(base), 2));
			if(dcsend)
			{
				i--;
				if(i==-1)
				{
					i=1;
					dcsend=false;
				}
			}
			else
			{
				i++;
				if(i==n)
				{
					i=n-2;
					dcsend=true;
				}
			}
			count++;
			continue;
		}
		return l;

	}
	public static void main(String[] args)
	{
		Problem89 p=new Problem89();
		List<Integer> l=p.grayCode(3);
		for (Integer integer : l)
		{
			System.out.println(integer); 
		}
	}
}
