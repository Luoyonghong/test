package 牛客网笔试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 有趣的数字
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int num[]=new int[n];
		for(int i=0;i<n;i++)
		{
			num[i]=scan.nextInt();
		}
		Arrays.sort(num); 
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++)
		{
			if(num[i+1]-num[i]<min)
				min=num[i+1]-num[i];
		}
		int mincount=0;
		int max=num[n-1]-num[0];
		
		int last=num[n-1];
		int first=num[0];
		int lastcount=0,firstcount=0;
		for(int i=0;i<n-1;i++)
		{
			if(num[i+1]-num[i]==min)
				mincount++;
		}
		
		if(min==0)
		{
			mincount=0;
			List<Integer> sameCount=new ArrayList<Integer>();
//			for(int i=0;i<n-1;i++)
//			{
//				if(num[i+1]=num[i])
//					mincount++;
//			}
		}
		
		for(int i=0;i<n-1;i++)
		{
			if(num[i]==first)
				firstcount++;
			else
				break;
		}
		for(int i=n-1;i>=0;i--)
		{
			if(num[i]==last)
				lastcount++;
			else
				break;
		}
		System.out.println(mincount+" "+firstcount*lastcount); 
	}
}
