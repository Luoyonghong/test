package leetcode43AndLater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem46
{
	List<int[]> r=new ArrayList<int[]>();
	int length=0;
	public List<List<Integer>> permute(int[] nums)
	{
		length=nums.length;
		func(nums,length);
				
		List<List<Integer>> l=new ArrayList<List<Integer>>();
		for(int i=0;i<r.size();i++)
		{
			int[] k=r.get(i);
			List<Integer> a=new ArrayList<Integer>(length);
			for (Integer integer : k)
			{
				a.add(integer);
			}
			l.add(a);
		}
		return l;
	}
	public void func(int[] nums, int n)
	{
		if(n==1)
		{
			int[] t=new int[length];
			t[0]=nums[0];
			r.add(t);
			return ;
		}
		
		
		func(nums,n-1);
		int nowSize=r.size();

		for(int i=0;i<nowSize;i++)
		{
			int [] m=r.get(i);
			m[n-1]=nums[n-1];
			//[1,2] [2,1]->[1,2,3] [2,1,3]
		}
		for(int i=0;i<nowSize;i++)
		{
			int b=n-2;
			while(b>=0)
			{
				int[] t=new int[length];
				int [] m=r.get(i);
				for(int j=0;j<n;j++)
					t[j]=m[j];
				//[1,2,3] [2,1,3]->[1,2,3] [2,1,3] [1,3,2] [2,3,1]
				swap(t,b,n-1);
				r.add(t);
				b--;
			}
		}
		
		
		
		return ;
	}
	public void swap(int nums[], int i, int j)
	{
		int t=nums[i];
		nums[i]=nums[j];
		nums[j]=t;
		
	}
	
	public static void main(String[] args)
	{
		Problem46 p=new Problem46();
		int nums[] ={1,2,3,4};
		List<List<Integer>> l=p.permute(nums);
		for (int j=0;j<l.size();j++)
		{
			List<Integer> t=l.get(j);
			for(int i=0;i<t.size();i++)
			{
				System.out.print(t.get(i)+" ");
			}
			System.out.println(); 
		}
	}
}
