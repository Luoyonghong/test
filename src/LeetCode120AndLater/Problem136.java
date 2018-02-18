package LeetCode120AndLater;

public class Problem136
{
	public int singleNumber(int[] nums)
	{
		int result=0;
		for (int i = 0; i < nums.length; i++)
		{
			result^=nums[i];//异或操作
		}
		return result;

	}
}
