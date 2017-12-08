package leetcode;

public class Problem26
{
	public static int removeDuplicates(int[] nums)
	{
		if(nums.length==0||nums.length==1)
			return nums.length;
		int nowIndex=1;
		int nowValue=nums[0];
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]==nowValue)
				continue;
			else
			{
				
				nowValue=nums[i];
				nums[nowIndex]=nums[i];
				nowIndex++;
			}
				
		}
		for (int i : nums)
		{
			System.out.print(i+" ");
		}
		System.out.println(); 
		return nowIndex--;
	}
	public static void main(String[] args)
	{
		int[] a={1,1,2,2,3};
		System.out.println(removeDuplicates(a));
	}
}
