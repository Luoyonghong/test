package 网易;

import java.util.Scanner;

public class 魔法币
{

	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		StringBuilder b =new StringBuilder();
		while(n>0)
		{
			if(n%2==0)
			{
				n=(n-2)/2;
				b.append("2");
			}
			if(n%2==1)
			{
				n=(n-1)/2;
				b.append("1");
			}
		}
		System.out.println(b.reverse().toString()); 
	}
}
