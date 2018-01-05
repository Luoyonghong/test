package leetcode71AndLater;

import java.util.Stack;

public class Problem71
{
	public String simplifyPath(String path)
	{
		path=path.trim()+"/";
		Stack<String> stack=new Stack<String>();
		int lastSlash=0;
		int nowSlash=0;
		for(int i=1;i<path.length();i++)
		{
			
			char c=path.charAt(i);
			if(c=='/')
			{
				nowSlash=i;
				String t=path.substring(lastSlash+1,nowSlash);
				if(t.compareTo("..")==0)
				{
					if(!stack.empty())
						//return "/";
						stack.pop();
				}
				else if(t.compareTo(".")==0||t.length()==0);
				else
					stack.push(t);
				
				lastSlash=i;
				continue;
			}
			
		}
		if(stack.empty())
			return "/";
		StringBuffer b=new StringBuffer();
		for (String string : stack)
		{
			b.append('/');
			b.append(string);
		}
		return b.toString();
	}
	public static void main(String[] args)
	{
		Problem71 p=new Problem71();
		System.out.println(p.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///")); 
	}
}
