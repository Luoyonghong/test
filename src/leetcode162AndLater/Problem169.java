package leetcode162AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem169
{
	public int majorityElement(int[] nums)
	{
		/*
		 * 或者用位运算，int[32]记录每一位上的1的个数，大于2/n则说明最常见的数字的这一位是1
		 */
		int count=0;
		int result=nums[0];
		for(int i=0;i<nums.length;i++)
		{
			if(count==0)
			{
				result=nums[i];
				count=1;
				continue;
			}
			if(nums[i]!=result)
				count--;
			else
				count++;
			
		}
		return result;
	}
	public List<Integer> majorityElement2(int[] nums)
	{
		/*
		 * 每次删除3个不相同的数字，剩下的一个或者两个就是候选，最后再判断一下
		 */
		List<Integer> res = new ArrayList<>();  
        if(nums==null || nums.length==0) return res;  
        if(nums.length==1) {  
            res.add(nums[0]);  
            return res;  
        }
		int c1=1,c2=0;
		int r1=nums[0],r2=0;
		 
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==r1)
			{
				c1++;
				continue;
			}
			else if(nums[i]==r2)
			{
				c2++;
				continue;
			}
			else if(c1==0)
			{
				r1=nums[i];
				c1=1;
				continue;
			}
			else if(c2==0)
			{
				r2=nums[i];
				c2=1;
				continue;
			}
			else
			{
				c1--;
				c2--;
			}
		}
		c1=0;c2=0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==r1)
				c1++;
			if(nums[i]==r2)
				c2++;
		}
		System.out.println("r1: "+r1+" r2: "+r2); 
		if(c1>nums.length/3)
			res.add(r1);
		if(r1!=r2&&c2>nums.length/3)
			res.add(r2);
		
		return res;
	}
	
	public static void main(String[] args)
	{
		Problem169 p=new Problem169();
		int[] nums={1,2,3,4,3,3,3,3};
		//System.out.println(p.majorityElement(nums));
		List<Integer> l=p.majorityElement2(new int[]{1,2});
		for (Integer integer : l)
		{
			System.out.print(integer+" ");
		}
	}
}
