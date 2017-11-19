package leetcode;

import java.util.Stack;

public class Problem20 {
	public static boolean isValid(String s) {
		Stack<Character> stack=new Stack<Character>();
		int i=0;
		for(i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(')
				stack.push(')');
			if(s.charAt(i)=='[')
				stack.push(']');
			if(s.charAt(i)=='{')
				stack.push('}');
			if(s.charAt(i)==')')
			{
				if(stack.size()==0)
					return false;
				char t=stack.pop();
				if(t==')')
					continue;
				else
					break;
			}
			if(s.charAt(i)==']')
			{
				if(stack.size()==0)
					return false;
				char t=stack.pop();
				if(t==']')
					continue;
				else
					break;
			}
			if(s.charAt(i)=='}')
			{
				if(stack.size()==0)
					return false;
				char t=stack.pop();
				if(t=='}')
					continue;
				else
					break;
			}
		}
		//System.out.println(i);
		if(stack.size()==0&&i==s.length())
			return true;
		else
			return false;
		
	}
	public static void main(String[] args) {
		System.out.println(isValid("(])"));
	}
}
