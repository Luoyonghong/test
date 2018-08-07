package leetcode300AndLater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 * 
 *	无论什么情况，左括号个数大于右括号。
 *	遇到第一个右括号大于左括号情况的时候，往回遍历，删除右括号，递归调用，set放最后结果
 */
public class Problem301 {
	Set<String> r= new HashSet<String>();
	public List<String> removeInvalidParentheses2(String s) {
		List<String> now=new ArrayList<String>();
		now.add(s);
		help(now); 
		if(r.size()==0)
			r.add("");
		return new ArrayList<>(r);  
	}
	
	public void help(List<String> l)
	{
		HashSet<String> set =new HashSet<String>();
		for(int i=0;i<l.size();i++)
		{
			String now = l.get(i);
			int leftcount=0;
			int rightcount=0;
			for(int j=0;j<now.length();j++)
			{
				if(now.charAt(j)=='(')
					leftcount++;
				if(now.charAt(j)==')')
					rightcount++;
				if(leftcount<rightcount)
				{
					for(int k=0;k<=j;k++)
					{
						if(now.charAt(k)==')')
						{
							set.add(now.substring(0, k)+now.substring(k+1));							
						}
					}
					help(new ArrayList<>(set));
					return;
				}
			}
			if(leftcount>rightcount)
			{
				for(int k=now.length()-1;k>=0;k--)
				{
					if(leftcount==rightcount)
						break;
					if(now.charAt(k)=='(')
					{
						leftcount--;
						set.add(now.substring(0, k)+now.substring(k+1));							
					}
				}
				help(new ArrayList<>(set));
				return;
			}
			if(leftcount==rightcount)
				r.add(now);
		}
		
	}
	
	/*
	 * BFS
	 * 
	 */
	public List<String> removeInvalidParentheses(String s) {
		if(s.length()==0)
		{
			List<String> l=new ArrayList<>();
			l.add("");
			return l;
		}
		if(isvalid(s))
		{
			List<String> l=new ArrayList<>();
			l.add(s);
			return l;
		}
		Queue<String> q=new LinkedList<String>();
		q.add(s);
		HashSet<String> set=new HashSet<>();
		int resultlength=0;
		boolean find =false;
		while(q.size()>0)
		{
			String t=q.poll();
			if(find&&t.length()<resultlength)
				continue;
			for(int i =0;i<t.length();i++)
			{
				if(t.charAt(i)=='('||t.charAt(i)==')')
				{
					String ss=t.substring(0, i)+t.substring(i+1);
					if(isvalid(ss))
					{
						r.add(ss);
						find=true;
						resultlength=t.length();
					}
					else
						if(set.add(ss) )
							q.add(ss);
				}
			}
			
		}
		return new ArrayList<>(r);
	}
	
	public boolean isvalid(String s)
	{
		int left=0,right=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(')
				left++;
			if(s.charAt(i)==')')
				right++;
			if(right>left)
				return false;
		}
		if(left==right)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		Problem301 p= new Problem301();
		List<String> l =p.removeInvalidParentheses("n"); 
		System.out.println(l); 
	}
	

}
