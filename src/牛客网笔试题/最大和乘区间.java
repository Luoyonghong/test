package 牛客网笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 最大和乘区间
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int num[]=new int[n];
		
		num[0]=scan.nextInt();
		int sum=num[0],min=num[0];
		List<int[]> l=new ArrayList<int[]>();
		boolean isok=false;
		for(int i=1;i<n;i++)
		{
			num[i]=scan.nextInt();
			if(num[i]>=min)
				sum+=num[i];
			else
			{
				int[] t=new int[2];
				t[0]=sum;
				t[1]=min;
				sum=num[i];
				min=num[i];
				l.add(t);
				isok=true;
			}
		}
		int result=l.get(0)[0]*l.get(0)[1];
		for(int i=0;i<l.size();i++)
			for(int j=i+1;j<=l.size();j++)
			{
				int s=l.get(i)[0];
				int m=l.get(i)[1];
				for(int k=i+1;k<j;k++)
				{
					int[] t=l.get(k);
					s+=t[0];
					if(t[1]<m)
						m=t[1];
				}
				if(result<m*s)
					result=m*s;
			}
		
		System.out.println(result); 
	}
	
}
