package 爱奇艺;

import java.util.Scanner;

public class 第一题
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt();
		int max=Math.max(Math.max(x, y),z);
		int temp=x+y+z;
		int sum=max*3;
		if((sum-temp)%2==1)
		{
			sum+=3;
		}
		System.out.println((sum-temp)/2); 
	}
}
