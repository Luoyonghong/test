package 小马智行;

import java.util.Scanner;

public class 第一题
{
	static int nums[];
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		nums =new int[n];
		for(int i=0;i<n;i++)
			nums[i]=sc.nextInt();
		int [] now=new int[n];
		now[0]=nums[0];
		for(int j=1;j<1000;j++)
		{
			now[0]=j*nums[0];
			for(int i=1;i<1000;i++)
			{
				now[1]=nums[1]*i;
				if(f(now,2,n ))
				{
					p(now);
					return;
				}
			}
		}
		
	}
	
	public static void p(int [] now)
	{
		for(int i=0;i<now.length;i++)
			System.out.println(now[i]); 
	}
	
	public static boolean f(int [] now,int i,int n)
	{
		if(i==n)
		{
			return true;
		}
		int cha = now[i-1]-now[i-2];
		//if(  ((float)(now[i-1] + cha)/ (float)nums[i] )%2==0)
		if((now[i-1]+cha)%nums[i]!=0)
			return false;
		else
		{
			now[i]=now[i-1] + cha;
			return f(now,i+1,n);
		}
	}
}
