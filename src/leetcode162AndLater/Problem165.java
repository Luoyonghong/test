package leetcode162AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem165
{
	public int compareVersion(String version1, String version2)
	{
		List<Integer> a=new ArrayList<Integer>(),b=new ArrayList<Integer>();
		String v1[]=version1.split("\\."),v2[]=version2.split("\\.");
		for (int i=0;i<v1.length;i++)
		{
			String s=v1[i];
			a.add(Integer.parseInt(s));
		}
		for (int i=0;i<v2.length;i++)
		{
			String s=v2[i];
			b.add(Integer.parseInt(s));
		}
		
		for(int i=a.size()-1;i>=0;i--)
		{
			if(a.get(i)==0)
				a.remove(i);
			else
				break;
		}
		
		for(int i=b.size()-1;i>=0;i--)
		{
			if(b.get(i)==0)
				b.remove(i);
			else
				break;
		}
		
//		for (Integer in : a)
//		{
//			System.out.print(in+" ");
//		}
//		System.out.println();
//		for (Integer in : b)
//		{
//			System.out.print(in+" ");
//		}
		
		int i=0;
		for(i=0;i<Math.min(a.size(),b.size());i++)
		{
			if(a.get(i)<b.get(i))
				return -1;
			if(a.get(i)>b.get(i))
				return 1;
			if(a.get(i)==b.get(i))
				continue;
		}
		if(i==Math.min(a.size(),b.size())&&a.size()!=b.size())
			return a.size()>b.size()?1:-1;
		return 0;
	}
	public static void main(String[] args)
	{
		Problem165 p=new Problem165();
		String version1="0.1";
		String version2="0.0.1";
		System.out.println(p.compareVersion(version1, version2));
	}
}
