package leetcode140AndLater;

import java.util.Stack;

public class Problem150
{
	public int evalRPN(String[] tokens)
	{
		Stack<Integer> s=new Stack<>();
		int i=0;
		while(i<tokens.length)
		{
			if(isoperators(tokens[i]))
			{
				int last=s.pop();
				int first=s.pop();
				switch (tokens[i])
				{
				case "+":
					s.push(first+last); 
					break;
				case "-":
					s.push(first-last); 
					break;
				case "*":
					s.push(first*last); 
					break;
				case "/":
					s.push(first/last); 
					break;
				default:
					break;
				}
				i++;
			}
			else
			{
				s.push(Integer.parseInt(tokens[i]));
				i++;
			} 
		}
		return s.pop();
	}
	
	public boolean isoperators(String s)
	{
		switch (s)
		{
		case "+":
			return true;
		case "-":
			return true;
		case "*":
			return true;
		case "/":
			return true;

		default:
			return false;
		}
	}
	public static void main(String[] args)
	{
		Problem150 p=new Problem150();
		String tokens[]={"2", "1", "+", "3", "*"};
		System.out.println(p.evalRPN(tokens)); 
	}
}
