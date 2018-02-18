package LeetCode120AndLater;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem131
{
	//应该用深度优先遍历
	List<List<String>> l=new ArrayList<>();
	Stack<String> nowlist=new Stack<>(); 
	public List<List<String>> partition(String s)
	{
		char[] ss=s.toCharArray();
		for(int i=0;i<ss.length;i++)
		{
			if(isPalindrome(0, i, ss)&&isPalindrome(i+1, ss.length-1, ss))
			{
				nowlist.push(s.substring(0,i+1));
				
				nowlist.push(s.substring(i+1,ss.length));
				l.add(copy(nowlist)); 
				help(ss, 0, i, s); 
				help(ss, i+1, ss.length-1, s);
				//if(t.size()==oldsize)
					
				
			}
		}
		return l;
	}
	public List<String> copy(Stack<String> l)
	{
		List<String> t=new ArrayList<>();
		for (int i = 0; i < l.size(); i++)
		{
			t.add(l.get(i));
		}
		return t;
	}
	
	public void help(char[] ss, int start, int end, String s)
	{
		System.out.println("start: "+start+" end: "+end); 
		
		if(start>=end||start<0||end>=s.length())
		{
			
			return  ;
		}
		for(int i=start;i<end;i++)
		{
			if(isPalindrome(start, i, ss)&&isPalindrome(i+1, end, ss))
			{
				String temp=nowlist.pop();
				//List<String> t=new ArrayList<>();
				nowlist.push(s.substring(start,i+1));
				nowlist.push(s.substring(i+1,end+1));
				//l.add(t);
				help(ss, start, i, s); 
				help(ss, i+1, end,s ); 
				nowlist.push(temp);
			}
		}
	}

	public boolean isPalindrome(int start, int end, char[] s)
	{
		while(start<end)
		{
			if(s[start]!=s[end])
				return false;
			start++;
			end--;
		}
		return true;
	}
	public static void main(String[] args)
	{
		
		Problem131 p=new Problem131();
		System.out.println(p.isPalindrome(1,2, new char[]{'a','a','b'})); 
		List<List<String>> l=p.partition("aab");
		for (int i = 0; i < l.size(); i++)
		{
			List<String> t=l.get(i);
			for (String string : t)
			{
				System.out.print(string+" "); 
			}
			System.out.println();
		}
	}
}
