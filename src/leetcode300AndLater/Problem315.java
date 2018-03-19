package leetcode300AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem315
{
	/*
	 * 归并排序
	 * 返回排序后每个数字的原始index
	 */
	int nixu[];
	public List<Integer> countSmaller(int[] nums)
	{
		nixu=new int[nums.length];
		int index_sum[]=mergesort(0, nums.length-1, nums);
		List<Integer> l=new ArrayList<Integer>(nums.length);
		for (int integer : nixu)
		{
			l.add(integer);
		}
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(" "+index_sum[i]);
		}
		System.out.println(); 
		return l;
	}
	//返回排序后每个数字的原始index
	public int[] mergesort(int left, int right, int nums[])
	{
		if(left>=right)
		{
			return new int[]{left};
		}
		int middle=(left+right)/2;
		int index_left[]=mergesort(left, middle, nums);
		int index_right[]=mergesort(middle+1, right, nums);
		int[] t=new int[right-left+1];
		int index_sum[]=new int[right-left+1];//新的index
		int i=middle;
		int j=right;
		int index=t.length-1;
		while(j>middle&&i>=left)
		{
			if(nums[i]>nums[j])
			{
				t[index]=nums[i];
				index_sum[index]=index_left[i-left];
				nixu[index_left[i-left]]+=j-middle;//不能直接赋值！ 这只是对右半部分的逆序数的和，左半部分原来的还有一些，也要加起来
				index--;
				i--;
			}
			else
			{
				t[index]=nums[j];
				index_sum[index]=index_right[j-middle-1];
				index--;
				j--;
			}
		}
		while(j>middle)
		{
			t[index]=nums[j];
			index_sum[index]=index_right[j-middle-1];
			index--;
			j--;
		}
		while(i>=left)
		{
			t[index]=nums[i];
			index_sum[index]=index_left[i-left];
			nixu[index_left[i-left]]+=0;
			i--;
			index--;
		}
		for(int m=left;m<=right;m++)
		{
			nums[m]=t[m-left];
		}
		return index_sum;
	}
	public static void main(String[] args)
	{
		Problem315 p=new Problem315();
		int nums[]={5, 2, 6, 1};
		List<Integer> l=p.countSmaller(nums);
		for (Integer integer : l)
		{
			System.out.println(integer); 
		}
	}
}
