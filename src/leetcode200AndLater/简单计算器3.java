package leetcode200AndLater;

import java.util.Stack;

public class 简单计算器3
{
	public int calculate(String s)
	{
		s+=" ";
		Stack<Integer> stack=new Stack<Integer>();
		int num=0,temp=0,res=0;
		char lastop='+';//上一个运算符
		for(int i=0;i<s.length();i++)
		{
			char t=s.charAt(i);
			if(t>='0'&&t<='9')
			{
				num=10*num+Integer.parseInt(t+"");
			}
			else if (t == '(')
			{
				int j = i, cnt = 0;
				for (; i < s.length(); ++i)
				{
					if (s.charAt(i) == '(')
						++cnt;
					if (s.charAt(i) == ')')
						--cnt;
					if (cnt == 0)
						break;
				}
				num = calculate(s.substring(j + 1, i));
			}
			else if (t=='+'||t=='-'||t=='*'||t=='/'||i==s.length()-1)
			{
				switch (lastop)
				{
				case '+':
					stack.push(num);
					num=0;
					lastop=t;
					break;
				case '-':
					stack.push(-num);
					num=0;
					lastop=t;
					break;
				case '*':
					temp=stack.pop();
					stack.push(temp*num);
					num=0;
					lastop=t;
					break;
				case '/':
					temp=stack.pop();
					stack.push(temp/num);
					num=0;
					lastop=t;
					break;
				default:
					break;
				}
			}
		}
		System.out.println(stack); 
		while(stack.size()>0)
		{
			res+=stack.pop();
		}
		return res;
	}
	public static void main(String[] args)
	{
		简单计算器3 p=new 简单计算器3();
		//String s="3+2*2";
		String s="1-4+(1+1)*(3+2)";
		//String s=" 3+5 / 2";
		System.out.println(p.calculate(s));
	}
}
