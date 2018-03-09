package 牛客网笔试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 合唱
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] tune=new int[n];
		for(int i=0;i<tune.length;i++)
			tune[i]=scan.nextInt();
		int copy[]=new int[n];
		for(int i=0;i<tune.length;i++)
			copy[i]=tune[i];
		Arrays.sort(tune);
		int maxslop=0;
		int maxvalue=0;
		for(int i=1;i<n;i++)
		{
			if(tune[i]-tune[i-1]>maxslop)
			{
				maxslop=tune[i]-tune[i-1];
				maxvalue=tune[i];
			}
		}
		List<Integer> l1=new ArrayList<Integer>();
		List<Integer> l2=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(copy[i]<maxvalue)
			{
				l1.add(copy[i]);
			}
			else
				l2.add(copy[i]);
		}
		int count=0;
		for (int i = 1; i < l1.size(); i++)
		{
			count+=Math.abs(l1.get(i)-l1.get(i-1));
		}
		for (int i = 1; i < l2.size(); i++)
		{
			count+=Math.abs(l2.get(i)-l2.get(i-1));
		}
		System.out.println(count); 
	}
}
