package 头条;

import java.util.Scanner;

public class 最大区间和 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		int nums[] =new int[n];
		//int s[] =new int[n+1];//不包含i
		for(int i=0;i<n;i++)
		{
			nums[i]=sc.nextInt();
		}
		int nowmin=nums[0];
		int max=nowmin*nowmin;
		int nowsum=nums[0];
		for(int i=0;i<n;i++)
		{
			//System.out.println(i); 
			int l=i-1,r=i+1,sum=nums[i];
			while(l>=0)
			{
				if(nums[l]>=nums[i])
				{
					sum+=nums[l];
				}
				else
					break;
				l--;
			}
			while(r<n)
			{
				if(nums[r]>=nums[i])
				{
					sum+=nums[r];
				}
				else
					break;
				r++;
			}
			max=Math.max(sum*nums[i], max);
			//System.out.println(max); 
		}
		
		System.out.println(max); 
		
	}
}
