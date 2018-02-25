package leetcode162AndLater;

public class Problem169
{
	public int majorityElement(int[] nums)
	{
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
	public static void main(String[] args)
	{
		Problem169 p=new Problem169();
		int[] nums={1,2,3,4,3,3,3,3};
		System.out.println(p.majorityElement(nums));
	}
}
