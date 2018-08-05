package leetcode300AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem306
{
	//dfs
	List<String> l=new ArrayList<>();
	public boolean isAdditiveNumber(String num)
	{
		for(int i =1;i<num.length();i++)
			for(int j =i+1;j<=num.length();j++)
			{
				l.add(num.substring(0, i));
				l.add(num.substring(i,j));
				if((l.get(0).startsWith("0")&&!l.get(0).endsWith("0"))||(l.get(1).startsWith("0")&&!l.get(1).endsWith("0")))
		                {
							l.clear();
							continue;
		                }
				boolean f=help(num.substring(j));
				l.clear();
				if(f)
					return true;
				System.out.println();
			}
		
		return false;
	}
	//要用到index,上一轮中index还没被用
	public boolean help(String num)
	{
		System.out.println(num); 
		System.out.println(l); 
		int size=l.size();
		String sum=bigsum(l.get(size-1),l.get(size-2));
		//System.out.println("sum: "+sum); 
		if(num.startsWith(sum))
		{
			l.add(sum);
			int offset=String.valueOf(sum).length();
			//System.out.println(offset); 
			if(offset==num.length())
				return true;
			boolean f =help(num.substring(offset));
			l.remove(l.size()-1);
			return f;
		}
		return false;
	}
	public String bigsum(String s1,String s2)
	{
		int n1=s1.length(),n2=s2.length();
		String max,min;
		if(n1>n2)
		{
			max=s1;
			min=s2;
			for(int i=0;i<n1-n2;i++)
				min="0"+min;
		}
		else
		{
			max=s2;min=s1;
			for(int i=0;i<n2-n1;i++)
				min="0"+min;
		}
		//System.out.println("max: "+max+" min: "+min); 
		int jinwei=0;
		StringBuilder b =new StringBuilder();
		for(int i=max.length()-1;i>=0;i--)
		{
			int sum=max.charAt(i)-'0' + min.charAt(i)-'0'+jinwei;
			if(sum>9)
				jinwei=1;
			else
				jinwei=0;
			b.append(sum%10);
		}
		if(jinwei==1)
			b.append("1");
//		if(b.length()==0)
//			b.append("0");
		return b.reverse().toString();
	}
	
	public static void main(String[] args)
	{
		Problem306 p=new Problem306();
		System.out.println(p.isAdditiveNumber("000"));
		//System.out.println(p.bigsum("1991", "1"));  
		
	}
}
