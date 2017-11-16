package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem17
{
	public static List<String> letterCombinations(String digits)
	{
		List<String> l=new ArrayList<String>();
		if(digits.length()==0)
			return l;
		char[][] s={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		if(digits.length()==1)
		{
			int a=Integer.parseInt(""+digits.charAt(0))-2;
			for(int m=0;m<s[a].length;m++)
			{
				l.add(""+s[a][m]);
			}
			return l;
		}
		
		int a=Integer.parseInt(""+digits.charAt(0))-2;
		for(int m=0;m<s[a].length;m++)
		{
			l.add(""+s[a][m]);
		}
		
		for(int i=1;i<digits.length();i++)
		{
			a=Integer.parseInt(""+digits.charAt(i))-2;
			List<String> t=new ArrayList<String>();
			for(int j=0;j<l.size();j++)
			{
				String f=l.get(j);
				for(int m=0;m<s[a].length;m++)
				{
					t.add(f+s[a][m]);
				}
			}
			l=t;
		}
		return l;
	}
	public static void main(String[] args)
	{
		List<String> l=letterCombinations("89");
		for (String string : l)
		{
			System.out.println(string); 
		}
	}
}
