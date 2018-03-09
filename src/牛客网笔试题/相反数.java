package 牛客网笔试题;

import java.util.Scanner;

public class 相反数
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		char[] s=String.valueOf(n).toCharArray();
		int start=0,end=s.length-1;
		while(start<end)
		{
			char t=s[start];
			s[start]=s[end];
			s[end]=t;
			start++;
			end--;
		}
		StringBuffer b=new StringBuffer();
		b.append(s);
		int n2=Integer.parseInt(b.toString()); 
		System.out.println(n+n2); 
	}
}
