package PINDUODUO;

import java.util.Scanner;

class Last
{
	int n_1;
	int n_2;
	public Last(int a, int b)
	{
		n_1=a;
		n_2=b;
	}
}

public class 问题4
{
	public static void main(String[] args)
	{
		// 1 1 3 -1 2 0 5 -1 -1 8
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int [] nums=new int[n];
		for(int i=0;i<n;i++)
			nums[i]=sc.nextInt();
		int r[]=new int[n];//代表以i结尾的可爱序列有多长
		int lasts[]=new int[n];//记录以i结尾的可爱序列的上一个数字
		int max=0;
		for(int i=2;i<n-1&&i<100;i++)
		{
			Last t=findfirst(i-1, nums[i], nums);
			if(t.n_1!=0&&t.n_2!=0)
			{
				r[i]=2;
				lasts[i]=t.n_2;
				int index=i+1;
				int lastIndex=i;
				while(index<n)
				{
					while(index<n&&nums[index]!=nums[lastIndex]+lasts[lastIndex])
						index++;
					if(index>=n)
						break;
					r[index]=r[lastIndex]+1;
					lasts[index]=nums[lastIndex];
					lastIndex=index;
				}
				if(max<r[lastIndex])
					max=r[lastIndex];
			}
		}
		System.out.println(max); 
	}
	public  static Last findfirst(int k, int num, int nums[])
	{
		//可以等于k，k是 num前面的一个数的下标
		for(int i=0;i<=k-1;i++)
			for(int j=i+1;j<=k;j++)
			{
				if(nums[i]+nums[j]==num)
				{
					return new Last(nums[i],nums[j]);
				}
			}
		return new Last(-1,-1);
	}
}
