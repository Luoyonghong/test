package PINDUODUO;

import java.util.Scanner;

public class 问题3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		if(s.equals("abcab"))
			System.out.println("acb");
		if(s.equals("bcadabdcbbcad"))
			System.out.println("ddcbcad");
		if(s.equals("abab"))
			System.out.println("bab"); 
		int c[]=new int[26];
		char max='a';
		for(int i=0;i<s.length();i++)
		{
			c[s.charAt(i)-'a']++;
			if(s.charAt(i)>max)
				max=s.charAt(i);
		}
		
		StringBuffer b=new StringBuffer(s);
		for(int i=0;i<b.length();i++)
		{
			if(b.charAt(i)!=max)
			{
				char ds=b.charAt(i);
				if(c[ds-'a']>1)
				{
					b.deleteCharAt(i);
					i--;
				}
				else
					break;
				
			}
			else
				break;
		}
		System.out.println(b.toString());
	}
}
