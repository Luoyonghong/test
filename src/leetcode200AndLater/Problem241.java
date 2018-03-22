package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem241
{
	/* "2*3-4*5"
	 * (2*(3-(4*5))) = -34
		((2*3)-(4*5)) = -14
		((2*(3-4))*5) = -10
		(2*((3-4)*5)) = -10
		(((2*3)-4)*5) = 10
	 * 
	 */
	//分治左右两边
	public List<Integer> diffWaysToCompute(String input)
	{
		List<Integer> result=new ArrayList<Integer>();
		if(!input.contains("*")&&!input.contains("+")&&!input.contains("-"))
		{
			result.add(Integer.parseInt(input));
			return result;
		}
		for(int i=0;i<input.length();i++)
		{
			char t=input.charAt(i);
			if(t=='+'||t=='-'||t=='*')
			{
				List<Integer> lefts=diffWaysToCompute(input.substring(0, i));
				List<Integer> rights=diffWaysToCompute(input.substring(i+1,input.length()));
				for (Integer l : lefts)
				{
					for (Integer r : rights)
					{
						switch (t)
						{
						case '*':
							result.add(l*r); 
							break;
						case '-':
							result.add(l-r); 
							break;
						case '+':
							result.add(l+r);
							break;
						default:
							break;
						}
					}
				}
			}
		}
		return result;
	}
	
	
	//
	//这样会有重复值
	//每次算一个算子
	/*
	boolean isNeg=true;
	public List<Integer> diffWaysToCompute(String input)
	{
		if(input.length()>0&&input.charAt(0)=='-')
		{
			isNeg=false;
			input=input.substring(1);
		}
		
		List<String> tokens=new ArrayList<String>();
		int index=-1;
		for(int i=0;i<input.length();i++)
		{
			char t=input.charAt(i);
			if(t=='+'||t=='-'||t=='*')
			{
				tokens.add(input.substring(index+1, i));
				tokens.add(t+""); 
				index=i;
			}
		}
		tokens.add(input.substring(index+1, input.length()));
		List<Integer> l=f(tokens);
		return l;
	}
	public List<Integer> f(List<String> tokens)
	{
		List<Integer> l=new ArrayList<Integer>();
		if(tokens.size()==3)
		{
			int k=cal(tokens.get(0), tokens.get(1), tokens.get(2));
//			if(k==-14)
//				System.out.println(tokens.get(0)+ tokens.get(1)+ tokens.get(2)); 
			l.add(k);
			return l;
		}
		
		for(int i=1;i<tokens.size();i++)
		{
			String t=tokens.get(i);
			if(t.equals("+")||t.equals("-")||t.equals("*")) 
			{
				String left=tokens.get(i-1);
				String right=tokens.get(i+1);
				int k=cal(tokens.get(i-1), t, tokens.get(i+1));
				tokens.remove(i-1);
				tokens.remove(i-1);
				tokens.remove(i-1);
				tokens.add(i-1,String.valueOf(k)); 
				List<Integer> templist=f(tokens);
				l.addAll(templist);
				tokens.remove(i-1);
				tokens.add(i-1, left);
				tokens.add(i,t);
				tokens.add(i+1,right);
			}
		}
		return l;
	}
	*/
	public int cal(String l, String op, String r)
	{
		int left=Integer.parseInt(l),right=Integer.parseInt(r);
		switch (op)
		{
		case "*":
			return left*right;
		case "-":
			return left- right;
		case "+":
			return left+right;
		default:
			break;
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		Problem241 p=new Problem241();
		//String in="2-1-1";
		String in="2*3-4*5";
		List<Integer> l=p.diffWaysToCompute(in);
		for (Integer i : l)
		{
			System.out.println(i); 
		}
	}
}
