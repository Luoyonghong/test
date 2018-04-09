package 笔试360;

import java.util.Arrays;
import java.util.Scanner;

public class 问题2
{
	//是否有一个数，其出现次数超过一半
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int[] count=new int[1001];
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
			int nums[]=new int[2*n];
			for(int j=0;j<2*n;j++)
			{
				nums[j]=sc.nextInt();
				count[nums[j]]++;
			}
			boolean isok=false;
			for(int j=0;j<count.length;j++)
				if(count[j]>n)
				{
					isok=true;
					break;
				}
			if(isok)
				System.out.println("No");
			else
				System.out.println("YES"); 
			for(int j=0;j<count.length;j++)
				count[j]=0;
			
		}
	}
}
