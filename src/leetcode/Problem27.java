package leetcode;

public class Problem27
{

	public static int removeElement(int[] nums, int val)
	{
		if(nums.length==0)
			return 0;
		int nowIndex=0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]!=val)
			{
				nums[nowIndex]=nums[i];
				nowIndex++;
			}
		}
		
//		for (int i =0;i<nowIndex;i++)
//		{
//			System.out.println(nums[i]);
//		} 
		return nowIndex--;
	}
	public static void main(String[] args)
	{
		int a[]={2,3,2,3};
		removeElement(a, 2);
	}
}
