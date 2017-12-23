package leetcode43AndLater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem47
{
	List<int[]> r=new ArrayList<int[]>();
	int length=0;
//	public List<List<Integer>> permuteUnique(int[] nums)
//	{
//		length=nums.length;
//		Arrays.sort(nums); 
//		func(nums,length);
//		List<List<Integer>> l=new ArrayList<List<Integer>>();
//		for(int i=0;i<r.size();i++)
//		{
//			int[] k=r.get(i);
//			List<Integer> a=new ArrayList<Integer>(length);
//			for (Integer integer : k)
//			{
//				a.add(integer);
//			}
//			l.add(a);
//		}
//		List<List<Integer>> m=new ArrayList<List<Integer>>();
//		m.addAll(l);
//		return m;
//	}
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
		//if((n<length&&nums[n-1]!=nums[n])||n==length)
		{
			for(int i=0;i<nowSize;i++)
			{
				int b=n-2;
				while(b>=0)
				{
					if(nums[n-1]==nums[b])
					{
						b--;
						continue;
					}
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
		}
		
		System.out.println("n is: "+n);
		for (int[] in : r)
		{
			for (int i : in)
			{
				System.out.print(i+" ");
			}
			System.out.println(); 
		}
		
		return ;
	}
	public void swap(int nums[], int i, int j)
	{
		int t=nums[i];
		nums[i]=nums[j];
		nums[j]=t;
		
	}
	
	//类似于数独  用回溯法
	public List<List<Integer>> permuteUnique(int[] num) {  
	    List<List<Integer>> res = new ArrayList<List<Integer>>();  
	    if(num==null && num.length==0)  
	        return res;  
	    Arrays.sort(num);  
	    helper(num, new boolean[num.length], new ArrayList<Integer>(), res);  
	    return res;  
	}  
	private void helper(int[] num, boolean[] used, ArrayList<Integer> item, List<List<Integer>> res)  
	{  
	    if(item.size() == num.length)  
	    {  
	        res.add(new ArrayList<Integer>(item));  
	        return;  
	    }  
	    for(int i=0;i<num.length;i++)  
	    {  
	        if(i>0 && !used[i-1] && num[i]==num[i-1]) continue;  // 选取下一个元素的时候，要查看这个元素的前一个元素是否和它相同，
	        													//如果相同而且没有使用过，就不用选取这个元素，因为如果选取了这个元素，
	        													//所得的结果被包含于选取了前一个相同元素的结果中
	        if(!used[i])  
	        {  
	            used[i] = true;  
	            item.add(num[i]);  
	            helper(num, used, item, res);  
	            item.remove(item.size()-1);  
	            used[i] = false;  
	        }  
	    }  
	}  
	
	public static void main(String[] args)
	{
		Problem47 p=new Problem47();
		int nums[] ={2,2,1,1};
		List<List<Integer>> l=p.permuteUnique(nums);
		System.out.println("\n"); 
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
