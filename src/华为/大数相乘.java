package 华为;

import java.math.BigInteger;
import java.util.Scanner;

public class 大数相乘
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine().trim();
		String s2=sc.nextLine().trim();
//		boolean minus=true;
//		if((s1.charAt(0)=='-'&&s2.charAt(0)=='-')||(s1.charAt(0)!='-'&&s2.charAt(0)!='-'))
//			minus=true;
//		else
//			minus=false;
//		if(s1.charAt(0)=='-')
//			s1=s1.substring(1);
//		if(s2.charAt(0)=='-')
//			s2=s2.substring(1);
		
		BigInteger b1=new BigInteger(s1);
		BigInteger b2=new BigInteger(s2);
		System.out.println(b1.multiply(b2).toString()); 
		
	}
}
