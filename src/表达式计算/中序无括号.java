package 表达式计算;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 中序无括号
{
	public static int cal(String s)
	{
		LinkedList<Integer> num=new LinkedList<Integer>();
		LinkedList<String> op=new LinkedList<String>();
		int lastop=-1;
		
		List<String> l=new ArrayList<String>();
		for(int i=0;i<s.length();i++)
		{
			char t=s.charAt(i);
			if(t=='+'||t=='-'||t=='*'||t=='/')
			{
				String n=s.substring(lastop+1, i);
				if(n.length()!=0)
					l.add(n);
				l.add(t+"");
				lastop=i;
			}
		}
		l.add(s.substring(lastop+1, s.length()));
		for (String string : l)
		{
			System.out.print(string+" ");
		}
		System.out.println();
		for(int i=0;i<l.size();i++)
		{
			String t=l.get(i); 
			if(t.equals("*")||t.equals("/")) 
			{
				int nextNum=Integer.parseInt(l.get(i+1)); 
				int beforeNum=Integer.parseInt(l.get(i-1)); 
				int result=0;
				if(t.equals("*")) 
					result=beforeNum*nextNum;
				else
					result=beforeNum/nextNum;
				
				l.remove(i-1);
				l.remove(i-1);
				l.remove(i-1);
				l.add(i-1, String.valueOf(result)); 
				i--;
			}
			else if(t.equals("+")||t.equals("-"))
			{
				num.add(Integer.parseInt(l.get(i-1))); 
				op.push(t);
			}
			
			
			for (String string : l)
			{
				System.out.print(string+" ");
			}
			System.out.println();
			
			
		}
		num.add(Integer.parseInt(l.get(l.size()-1))); 
		
		
		for (int c : num)
		{
			System.out.print(c+" ");
		}
		System.out.println();
		for (String character : op)
		{
			System.out.print(character+" ");
		}
		System.out.println(); 
		while(op.size()>0)
		{
			String t=op.pollFirst();
			if(t.equals("+")) 
			{
				int before=num.pollFirst();
				int last=num.pollFirst();
				num.offerFirst(last+before);
			}
			else
			{
				int before=num.pollFirst();
				int last=num.pollFirst();
				num.offerFirst(-last+before);
			}
		}
		return num.pop();
		
	}
	public static void main(String[] args)
	{
		System.out.println(cal("1+3*4/2*3-5+6/3*3"));  
	}
}
