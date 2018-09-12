package 快手;

import java.util.Scanner;

public class 第三题
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		String line="";
		while((line=sc.nextLine())!=null)
		{
			line=line.trim();
			line=line.replace("\n", "");
			int t[]=new int[26];
			for(int i=0;i<line.length();i++)
			{
				if(line.charAt(i)>'z'||line.charAt(i)<'a')
					continue;
				try
				{
				t[line.charAt(i)-'a']+=1;
				}
				catch (Exception e)
				{
					
				}
			}
			StringBuffer b=new StringBuffer();
			for(int i=0;i<26;i++)
			{
				if(t[i]>0)
				{
					char c=(char) ('a'+i);
					//System.out.println(c); 
					b.append(c);
					b.append(t[i]);
				}
			}
			System.out.println(b.toString()); 
		}
	}
}
