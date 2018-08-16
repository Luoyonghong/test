package 网易;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 第二题2
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k =sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		//每次选最大的放到最小的
		List<String> re=new ArrayList<>();
		int times=1;
		int lastcha=0;
		for(int i=0;i<k;i++)
		{
			int max=Integer.MIN_VALUE,max_index=0;
			int min=Integer.MAX_VALUE,min_index=0;
			for(int j=0;j<n;j++)
			{
				if(a[j]>max)
				{
					max=a[j];
					max_index=j;
				}
				if(a[j]<min)
				{
					min=a[j];
					min_index=j;
				}
			}
			if(max-min==lastcha)
			{
				break;
			}
			String s=max_index+1+" "+(min_index+1);
			a[max_index]--;
			a[min_index]++;
			re.add(s);
			lastcha=max-min;
		}
		int max=Integer.MIN_VALUE,max_index=0;
		int min=Integer.MAX_VALUE,min_index=0;
		for(int j=0;j<n;j++)
		{
			if(a[j]>max)
			{
				max=a[j];
				max_index=j;
			}
			if(a[j]<min)
			{
				min=a[j];
				min_index=j;
			}
			
		}
		System.out.println(max-min+" "+re.size());
		for (String string : re)
		{
			System.out.println(string);
 		}

	}
}
