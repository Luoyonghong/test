package leetcode33AndLarger;



public class Problem41
{
	public int firstMissingPositive(int[] nums)
	{
		for(int i=0;i<nums.length;i++)
		{
			while(nums[i]>=1&&nums[i] <= nums.length&&nums[i]!=i+1&&nums[i]!=nums[nums[i]-1])
			{
				int a=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=a;
			}
		}
		
		for(int i=0;i<nums.length;i++)
			if(nums[i]!=i+1)
				return i+1;
		return nums.length+1; 
		
	}
	
	public static void main(String[] args)
	{
		Problem41 p=new Problem41();
		int[] nums={4,3};
		System.out.println(p.firstMissingPositive(nums)); 
	}
}
