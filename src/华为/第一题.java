package 华为;

import java.util.Scanner;

public class 第一题
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int max=0,index=0;
		int nums[]=new int[21];
		for(int i=0;i<21;i++)
		{
			nums[i]=sc.nextInt();
		}
		
		max=nums[0]+nums[1]+nums[2]+nums[3];
		for(int i=4;i<21;i++)
		{
			int temp=nums[i]+nums[i-1]+nums[i-2]+nums[i-3];
			if(temp>max)
			{
				index=i-3;
				max=temp;
			}
		}
		
		System.out.println(index); 
	}
}
