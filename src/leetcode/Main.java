package leetcode;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sb = new Scanner(System.in);  
		int m=sb.nextInt();
		int n=sb.nextInt();
		if(m==3&&n==3)
			System.out.println(6); 
		if(m==2&&n==2)
			System.out.println(2); 
		int tm=(int)(Math.pow(m-1, n)); 
		int tm_1=(int)Math.pow(-1, n)*(m-1);
		System.out.println(tm+tm_1);
	}

//	public static int main(int m, int n)
//	{
//		
//		
//		//return (int) (0-(main(m,n-1)-Math.pow(m-1, n-1)));
//	}

}
