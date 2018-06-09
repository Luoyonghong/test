package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem224
{
	/*
	 * Input: "(1+(4+5+2)-3)+(6+8)"
		Output: 23
	 * 
	 * Input: " 2-1 + 2 "
		Output: 3
	 */
	public int calculate(String s)
	{
		List<String> ops=getOpAndNums(s);
		Stack<Integer> stack=new Stack<Integer>();
		int res=0;
		int sign=1;
		for(int i=0;i<ops.size();i++)
		{
			String t=ops.get(i);
			if(t.equals("+")) 
				sign=1;
			else if(t.equals("-"))
				sign=-1;
			else if(t.equals("("))
			{
				stack.push(res);
				stack.push(sign);
				res=0;
				sign=1;
			}
			else if(t.equals(")"))
			{
				sign=stack.pop();
				int oldRes=stack.pop();
				oldRes+=sign*res;
				res=oldRes;
			}
			else// number
			{
				res+=sign*Integer.parseInt(t);
			}
		}
		
		return res;
	}
	
	public List<String> getOpAndNums(String s)
	{
		List<String> l=new ArrayList<String>();
		s=s.trim();
		int lastIndex=-1;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='('||s.charAt(i)==')'||s.charAt(i)=='+'||s.charAt(i)=='-')
			{
				String t=s.substring(lastIndex+1,i).trim();
				if(t.length()!=0)
					l.add(t);
				l.add(s.charAt(i)+"");
				lastIndex=i;
			}
		}
		String t=s.substring(lastIndex+1).trim();
		if(t.length()!=0)
			l.add(t);
		return l;
	}
	public static void main(String[] args)
	{
		Problem224 p=new Problem224();
		//String s="(1+(4+5+2)-3)+(6+8)";
		String s=" 2-1 + 2 ";
		List<String> l=p.getOpAndNums(s);
		for (String string : l)
		{
			System.out.print(string+" ");
		}
		System.out.println(); 
		System.out.println(p.calculate(s));
		//System.out.println("csx".substring(0,0));  
	}
	
}
