package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Problem18
{
	List<List<Integer>> res = new ArrayList<List<Integer>>(); 
	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		if(nums.length<4)
			return res;
	    Arrays.sort(nums);
	    int tempTarget=target-nums[0];
	    int tempNums[]=new int[nums.length-1];
	    for(int i=0;i<tempNums.length;i++)
	    	tempNums[i]=nums[i+1];
	    threeSum(tempNums,tempTarget,nums[0]);
	    for(int i=1;i<nums.length;i++)
	    {
	    	if(i>0 && nums[i]==nums[i-1])continue; 
	    	tempTarget=target-nums[i];
		    tempNums=new int[nums.length-i-1];
		    for(int j=0;j<tempNums.length;j++)
		    	tempNums[j]=nums[j+i+1];
		    threeSum(tempNums,tempTarget,nums[i]);
	    }
	    
	    return res;
	}
	
	public void threeSum(int[] nums,int target,int index)
	{
        int len=nums.length; 
        for(int i=0;i<len;i++){  
            //if(nums[i]>0)break;  
            if(i>0 && nums[i]==nums[i-1])continue;  
            int begin=i+1,end=len-1;  
            while(begin<end){  
                int sum=nums[i]+nums[begin]+nums[end];  
                if(sum==target){  
                    List<Integer> list = new ArrayList<Integer>();  
                    list.add(index);
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);  
                    res.add(list);  
                    begin++;end--;  
                    while(begin<end && nums[begin]==nums[begin-1])begin++;  
                    while(begin<end && nums[end]==nums[end+1])end--;  
                }else if(sum>target)end--;  
                else begin++;  
            }  
        }  
	}
	
	public static void f()
	{
		Set<List<Integer>> s= new HashSet<List<Integer>>();
		List<Integer> l1=new ArrayList<Integer>();
		l1.add(2);
		l1.add(3);
		l1.add(4);
		List<Integer> l2=new ArrayList<Integer>();
		l2.add(3);
		l2.add(2);
		l2.add(4);
		s.add(l1);
		s.add(l2);
		System.out.println(s.size());
		
	}
	
	public static void main(String[] args)
	{
		Problem18 p=new Problem18();
		int[] nums={5,5,3,5,1,-5,1,-2};
		List<List<Integer>> r=p.fourSum(nums, 4);
		for (List<Integer> l : r)
		{
			for (Integer i : l)
			{
				System.out.print(i+"  ");
			}
			System.out.println();
		}
		f();
	}
	
}
