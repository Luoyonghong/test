package 美团;

import java.util.Scanner;

public class 问题1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String t=sc.nextLine();
		//s长度大于等于t
		int n=t.length();
		int m=s.length();
		//m>=n
		char[] ss=s.toCharArray();
		char tt[]=t.toCharArray();
		int sum=0;
		for(int i=0;i<=m-n;i++)
		{
			sum+=cal(i, i+n-1, ss, tt);
		}
		System.out.println(sum);
	}
	public static int cal(int start, int end,char[]m,char[] n)
	{
		int count=0;
		for(int i=start;i<=end;i++)
		{
			if(m[i]!=n[i-start])
				count++;
		}
		return count;
	}
}
