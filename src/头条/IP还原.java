package 头条;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IP还原
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println(restoreIpAddresses(s));

	}
	
	//List<String> l=new ArrayList<String>();
	static int l;
	static char[] r;
	static int index;
	public static int restoreIpAddresses(String s)
	{
		char t[]=s.toCharArray();
		r=new char[s.length()+3];
		index=0;
		List<Integer> dot=new ArrayList<Integer>();
		func(dot, 0, 4,s);
		return l;
	}
	
	public static void func(List<Integer> dot,int begin,int num,String s)
	{
		
		if(num==0&&begin==s.length())
		{
			int count=0;
			String s2="";
			for(int i=0;i<4;i++)
			{
				if(i!=3)
					s2+=s.substring(count,dot.get(i)+1)+".";
				else
					s2+=s.substring(count,dot.get(i)+1);
				count=dot.get(i)+1;
			}
			//l.add(s2);
			l++;
			return ;
		} 
		for(int i=0;i<3&&begin+i<s.length();i++)
		{
			String t=s.substring(begin,begin+i+1);
			if(Integer.parseInt(t)>255||Integer.parseInt(t)<0||(t.length()>1&&t.startsWith("0"))) 
			{
				break;
			}
			dot.add(begin+i);
			func(dot, begin+i+1, num-1,s);
			//这里不能用num--或者--num;用--的话，代表func这句话执行完毕之后才减一，则只有遇到func返回的时候才减一，中间递归了很多次了已经，但Num-1则不一样，是一个新的变量了
			dot.remove(dot.size()-1);
		}
		return ;
	}
}
