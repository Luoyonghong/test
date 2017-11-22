package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem22
{
	public List<String> generateParenthesis(int n)
	{
		List<String> l=new ArrayList<String>();
		f(n,n,l,"");
		return l;
	}
	public void f(int left,int right, List<String> l,String s)
	{
		if(left==0&&right==0)
		{
			l.add(s);
			return ;
		}
		if(left<0||right<0||left>right)
			return ;
		f(left-1,right,l,s+"(");
		f(left,right-1,l,s+")");
			
	}
	
	public int generateParenthesis2(int n)
	{
		int[] l={0};
		f2(n,n,l);
		return l[0];
	}
	public void f2(int left,int right, int[] l)
	{
		if(left==0&&right==0)
		{
			l[0]++;
			return ;
		}
		if(left<0||right<0||left>right)
			return ;
		f2(left-1,right,l);
		f2(left,right-1,l);
			
	}

	
	public static void main(String[] args)
	{
		Problem22 p=new Problem22();
		List<String> l=p.generateParenthesis(4);
		for (String string : l)
		{
			System.out.println(string);  
		}
		System.out.println(p.generateParenthesis2(4)); 
	}
}
