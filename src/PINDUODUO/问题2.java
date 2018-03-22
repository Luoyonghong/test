package PINDUODUO;

import java.util.Arrays;
import java.util.Scanner;

public class 问题2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int [] nums=new int[n];
		for(int i=0;i<n;i++)
			nums[i]=sc.nextInt();
		Arrays.sort(nums); 
		int count=0;
		int left=0;
		int right=n-1;
		while(nums[right]==4)
		{
			right--;
			count++;
		}
		while(left<right)
		{
			if(nums[left]+nums[right]<=4)
			{
				left++;
				right--;
				count++;
			}
			else if(nums[left]+nums[right]>4)
			{
				right--;
				count++;
			}
		}
		if(left==right)
			count++;
		System.out.println(count); 
 	}
}
