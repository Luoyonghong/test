package 头条;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 双生词
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
			List<String> words=new ArrayList<>(n);
			for(int j=0;j<n;j++)
			{
				words.add(sc.next());
				
			}
			boolean isok=false;
			for(int j=0;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					if(!isok&&!sum(words.get(j),words.get(k)))
						continue;
					if(!isok&&isshaungshengci(words.get(j), words.get(k)))
					{
						System.out.println("Yeah"); 
						isok=true;
					}
				}
			}
			if(!isok)
				System.out.println("Sad"); 
		}

		//System.out.println(isshaungshengci("abcde", "acbde")); 
		//System.out.println(isshaungshengci("helloworld", "worldhello")); 
	}
	
	public static boolean sum(String s1, String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		int sum1=0,sum2=0;
		for(int i=0;i<s1.length();i++)
		{
			sum1+=s1.charAt(i)-'a';
			sum2+=s2.charAt(i)-'a';
		}
		return sum1==sum2;
	}
	
	public static boolean isshaungshengci(String s1, String s2)
	{
		StringBuffer s=new StringBuffer(s1);
		s.append(s1);
//		for(int i=0;i<s1.length();i++)
//		{
//			if(s.substring(i, i+s1.length()).compareTo(s2)==0)
//			{
//				return true;
//			}
//		}
		if(s.toString().contains(s2))
			return true;
		s=s.reverse();
//		for(int i=0;i<s1.length();i++)
//		{
//			if(s.substring(i, i+s1.length()).compareTo(s2)==0)
//			{
//				return true;
//			}
//		}
		if(s.toString().contains(s2))
			return true;
		return false;
	}
}
