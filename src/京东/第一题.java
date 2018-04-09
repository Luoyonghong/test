package 京东;

import java.util.Scanner;

public class 第一题
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		//long nums[]=new long[t];
		for(int i=0;i<t;i++)
		{
			long f=sc.nextLong();
			boolean isok=false;
			if(f%2==1)
			{
				System.out.println("No");
				continue;
			}
			for(long j=2;j*2<f;j++)
			{
				if(f%j==0&&(f/j)%2==1)
				{
					System.out.println(f/j+" "+j);
					isok=true;
					break;
				}
			}
			if(!isok)
				System.out.println("No"); 
			
		}
	}
}
