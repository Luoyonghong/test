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
					l.add(num+"_");
				l.add(t+"_");
				lastop=i;
			}
		}
		l.add(s.substring(lastop+1, s.length()));
		String out="";
		Stack<OP> stack=new Stack<OP>();
		for(int i=0;i<l.size();i++)
		{
			String t=l.get(i);
			if(t.equals("*_")||t.equals("/_")||t.equals("+_")||t.equals("-_")||t.equals("(_")||t.equals(")_"))
			{
				if(t.equals("(_"))//左括号优先级最高，直接push
				{
					stack.push(new OP(t,3));
					continue;
				}
				if(t.equals(")_"))
				{
					while(!stack.peek().op.equals("(_"))
					{
						out+=stack.pop().op;
					}
					stack.pop();
					continue;
				}
				OP nowop=null;
				switch (t)
				{
				case "+_":
					nowop=new OP(t, 1);
					break;
				case "-_":
					nowop=new OP(t, 1);
					break;
				case "*_":
					nowop=new OP(t, 2);
					break;
				case "/_":
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
				while(!stack.empty()&&!stack.peek().op.equals("(_")&&stack.peek().pri>=nowop.pri)
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
					l.add(num+"_");
				l.add(t+"_");
				lastop=i;
			}
		}
		l.add(s.substring(lastop+1, s.length()));
		String out="";
		Stack<OP> stack=new Stack<OP>();
		for(int i=l.size()-1;i>=0;i--)
		{
			String t=l.get(i);
			if(t.equals("*_")||t.equals("/_")||t.equals("+_")||t.equals("-_")||t.equals("(_")||t.equals(")_"))
			{
				if(t.equals(")_"))//右括号优先级最高，直接push
				{
					stack.push(new OP(t,3));
					continue;
				}
				if(t.equals("(_"))
				{
					while(!stack.peek().op.equals(")_"))
					{
						out=stack.pop().op+out;
					}
					stack.pop();
					continue;
				}
				OP nowop=null;
				switch (t)
				{
				case "+_":
					nowop=new OP(t, 1);
					break;
				case "-_":
					nowop=new OP(t, 1);
					break;
				case "*_":
					nowop=new OP(t, 2);
					break;
				case "/_":
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
				while(!stack.empty()&&!stack.peek().op.equals(")_")&&stack.peek().pri>nowop.pri)
				{
					out=stack.pop().op+out;
				}
				stack.push(nowop);
			}
			else
				out=t+out;
		}
		while(!stack.empty())
		{
			out=stack.pop().op+out;
		}
		return out;
	}
	
	public static long  calAfter(String out)
	{
		List<String> l=new ArrayList<String>();
		int lastop=-1;
		for(int i=0;i<out.length();i++)
		{
			char t=out.charAt(i);
			if(t=='_')
			{
				String num=out.substring(lastop+1, i).trim();
				if(num.length()!=0)
					l.add(num);
				lastop=i;
			}
		}
		String last=out.substring(lastop+1, out.length()).trim();
		if(last.length()!=0)
			l.add(last); 

		Stack<Long> stack=new Stack<Long>();
		for(int i=0;i<l.size();i++)
		{
			String t=l.get(i);
			if(t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/"))
			{
				long after,before;
				switch (t)
				{
				case "+":
					after=stack.pop();
					before=stack.pop();
					stack.push(before+after);
					break;
				case "-":
					after=stack.pop();
					before=stack.pop();
					stack.push(before-after);
					break;
				case "*":
					after=stack.pop();
					before=stack.pop();
					stack.push(before*after);
					break;
				case "/":
					after=stack.pop();
					before=stack.pop();
					stack.push(before/after);
					break;
				default:
					break;
				}
			}
			else
				stack.push(Long.parseLong(t)); 
		}
		return stack.pop();
	}
	
	public static long  calBefore(String out)
	{
		List<String> l=new ArrayList<String>();
		int lastop=-1;
		for(int i=0;i<out.length();i++)
		{
			char t=out.charAt(i);
			if(t=='_')
			{
				String num=out.substring(lastop+1, i).trim();
				if(num.length()!=0)
					l.add(num);
				lastop=i;
			}
		}
		String last=out.substring(lastop+1, out.length()).trim();
		if(last.length()!=0)
			l.add(last); 
		
		Stack<Long> stack=new Stack<Long>();
		for(int i=l.size()-1;i>=0;i--)
		{
			String t=l.get(i);
			if(t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/"))
			{
				long after,before;
				switch (t)
				{
				case "+":
					before=stack.pop();
					after=stack.pop();
					stack.push(before+after);
					break;
				case "-":
					before=stack.pop();
					after=stack.pop();
					stack.push(before-after);
					break;
				case "*":
					before=stack.pop();
					after=stack.pop();
					stack.push(before*after);
					break;
				case "/":
					before=stack.pop();
					after=stack.pop();
					stack.push(before/after);
					break;
				default:
					break;
				}
			}
			else
				stack.push(Long.parseLong(t)); 
		}
		return stack.pop();
	}
	
	public static void main(String[] args)
	{
		中序转后序 p=new 中序转后序();
		//System.out.println(p.transAfter("a+b*c+(d*e+f)*g"));
		//System.out.println(p.transPre("a+b*c+(d*e+f)*g"));
		
//		String transformed=p.transAfter("2*3/(2-1)+3*(4-1)");
//		System.out.println(transformed); 
//		System.out.println(p.calAfter(transformed)); 
		
		
		String transformed=p.transPre("2*3/(2-1)+2*(14-1)");
		System.out.println(transformed); 
		System.out.println(p.calBefore(transformed)); 
		
		//System.out.println(p.transPre("2*3/(2-1)+3*(4-1)"));  
	}
}
