package 牛客网笔试题;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{	
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		//System.out.println(s); 
		char t=s.charAt(0);
		int count=1;
		int i=1;
		while(i<s.length())
		{
			if(s.charAt(i)==t)
			{
				i++;
				continue;
			}
			else
			{
				t=s.charAt(i);
				count++;
				i++;
			}
			
		}
		System.out.println(String.format("%.2f", s.length()/(float)count)); 
	}
}
