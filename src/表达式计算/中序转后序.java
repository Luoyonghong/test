package 表达式计算;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class OP
{
	String op;
	int pri;
	public OP(String op,int pri)
	{
		this.op=op;
		this.pri=pri;
	}
}

public class 中序转后序
{
	
	public String transAfter(String s)
	{
		List<String> l=new ArrayList<String>();
		int lastop=-1;
		for(int i=0;i<s.length();i++)
		{
			char t=s.charAt(i);
			if(t=='+'||t=='-'||t=='*'||t=='/'||t==')'||t=='(')
			{
				String num=s.substring(lastop+1, i);
				if(num.length()!=0)
					l.add(num);
				l.add(t+"");
				lastop=i;
			}
		}
		l.add(s.substring(lastop+1, s.length()));
		//输出
		for (String string : l)
		{
			System.out.print(string+" ");
		}
		System.out.println(); 
		//
		String out="";
		Stack<OP> stack=new Stack<OP>();
		for(int i=0;i<l.size();i++)
		{
			String t=l.get(i);
			if(t.equals("*")||t.equals("/")||t.equals("+")||t.equals("-")||t.equals("(")||t.equals(")"))
			{
				if(t.equals("("))//左括号优先级最高，直接push
				{
					stack.push(new OP(t,3));
					continue;
				}
				if(t.equals(")"))
				{
					while(!stack.peek().op.equals("("))
					{
						out+=stack.pop().op;
					}
					stack.pop();
					continue;
				}
				OP nowop=null;
				switch (t)
				{
				case "+":
					nowop=new OP(t, 1);
					break;
				case "-":
					nowop=new OP(t, 1);
					break;
				case "*":
					nowop=new OP(t, 2);
					break;
				case "/":
					nowop=new OP(t, 2);
					break;
				default:
					break;
				}
				if(stack.empty()||stack.peek().pri<nowop.pri)
				{
					stack.push(nowop);
					continue;
				}
				while(!stack.empty()&&!stack.peek().op.equals("(")&&stack.peek().pri>=nowop.pri)
				{
					out+=stack.pop().op;
				}
				stack.push(nowop);
			}
			else
				out+=t;
		}
		while(!stack.empty())
		{
			out+=stack.pop().op;
		}
		return out;
	}
	
	public String transPre(String s)
	{
		List<String> l=new ArrayList<String>();
		int lastop=-1;
		for(int i=0;i<s.length();i++)
		{
			char t=s.charAt(i);
			if(t=='+'||t=='-'||t=='*'||t=='/'||t==')'||t=='(')
			{
				String num=s.substring(lastop+1, i);
				if(num.length()!=0)
					l.add(num);
				l.add(t+"");
				lastop=i;
			}
		}
		l.add(s.substring(lastop+1, s.length()));
		//输出
		for (String string : l)
		{
			System.out.print(string+" ");
		}
		System.out.println(); 
		//
		String out="";
		Stack<OP> stack=new Stack<OP>();
		for(int i=l.size()-1;i>=0;i--)
		{
			String t=l.get(i);
			if(t.equals("*")||t.equals("/")||t.equals("+")||t.equals("-")||t.equals("(")||t.equals(")"))
			{
				if(t.equals(")"))//右括号优先级最高，直接push
				{
					stack.push(new OP(t,3));
					continue;
				}
				if(t.equals("("))
				{
					while(!stack.peek().op.equals(")"))
					{
						out+=stack.pop().op;
					}
					stack.pop();
					continue;
				}
				OP nowop=null;
				switch (t)
				{
				case "+":
					nowop=new OP(t, 1);
					break;
				case "-":
					nowop=new OP(t, 1);
					break;
				case "*":
					nowop=new OP(t, 2);
					break;
				case "/":
					nowop=new OP(t, 2);
					break;
				default:
					break;
				}
				if(stack.empty()||stack.peek().pri<=nowop.pri)
				{
					stack.push(nowop);
					continue;
				}
				while(!stack.empty()&&!stack.peek().op.equals(")")&&stack.peek().pri>nowop.pri)
				{
					out+=stack.pop().op;
				}
				stack.push(nowop);
			}
			else
				out+=t;
		}
		while(!stack.empty())
		{
			out+=stack.pop().op;
		}
		return new StringBuffer(out).reverse().toString();
	}
	
	
	
	public static void main(String[] args)
	{
		中序转后序 p=new 中序转后序();
		System.out.println(p.transAfter("a+b*c+(d*e+f)*g"));
		System.out.println(p.transPre("a+b*c+(d*e+f)*g"));
		System.out.println(p.transAfter("2*3/(2-1)+3*(4-1)")); 
		System.out.println(p.transPre("2*3/(2-1)+3*(4-1)"));  
	}
}
