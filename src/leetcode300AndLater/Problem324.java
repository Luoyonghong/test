package leetcode300AndLater;

import java.util.Arrays;

public class Problem324
{
	public void wiggleSort(int[] nums)
	{
		Arrays.sort(nums); 
		int n=nums.length;
		//1 2 3 4 5 6 
		//1 4 2 5 3 6   3 6 2 5 1 4
		//1 2 3 4 5 6 7
		//1 5 2 6 3 7 4
		int t[]=new int[n];
		int leftrange=(n+1)/2;// <
		for(int i=0;i<leftrange;i++)
		{
			t[i*2]=nums[leftrange-i-1];
		}
		for(int i =leftrange;i<n;i++)
		{
			t[(i-leftrange)*2+1]=nums[n-1- i+leftrange];
		}
		for(int i=0;i<n;i++)
		{
			nums[i]=t[i];
			System.out.print(t[i]+" "); 
		}
			//
	}
	public static void main(String[] args)
	{
		Problem324 p =new Problem324();
		int [] nums={1,2,3,4,6,5,7};
		p.wiggleSort(nums);
 	}
}
