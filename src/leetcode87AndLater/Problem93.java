package leetcode87AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem93
{
	List<String> l=new ArrayList<String>();
	char[] r;
	int index;
	public List<String> restoreIpAddresses(String s)
	{
		char t[]=s.toCharArray();
		r=new char[s.length()+3];
		index=0;
		List<Integer> dot=new ArrayList<Integer>();
		func(dot, 0, 4,s);
		return l;
	}
	
	public boolean func(List<Integer> dot,int begin,int num,String s)
	{
		
//		if(num==1&&s.length()-begin>3)
//			return false;
////		if(dot.size()>3)
//			return false;
//		if(begin==s.length)
//			l.add(new String(r));
		if(num==1&&begin==s.length())
		{
//			StringBuffer b=new StringBuffer();
//			int before=0;
//			for(int i=1;i<dot.size();i++)
//			{
//				b.append(s.substring(before,dot.get(i)+1));
//				b.append('.');
//				before=dot.get(i)+1;
//			}
//			b.deleteCharAt(b.length()-1);
//			l.add(b.toString());
			for (Integer integer : dot)
			{
				System.out.print(integer);
			}
			System.out.println(); 
			return false;
		} 
		for(int i=1;i<4&&begin+i<s.length();i++)
		{
			if(Integer.parseInt(s.substring(begin,begin+i))>255||Integer.parseInt(s.substring(begin,begin+i))<0)
			{
				break;
			}
			dot.add(begin+i);
			func(dot, begin+i+1, num--,s);
			dot.remove(dot.size()-1);
		}
		return false;
	}
	public static void main(String[] args)
	{
		Problem93 p=new Problem93();
		p.restoreIpAddresses("25525511135");
//		char[] d={'1','2','3'};
//		System.out.println(new String(d,1,1));
		for (String string : p.l)
		{
			System.out.println(string); 
		}
	}
}
