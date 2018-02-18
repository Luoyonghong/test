package LeetCode120AndLater;

public class Problem137
{
	public int singleNumber(int[] nums)
	{
		int result[]=new int[32];
		int count=0;
		for(int i=0;i<nums.length;i++)
		{
			for(int j=0;j<32;j++)
				result[j]+=nums[i]>>j&1;//右移j位，result[j]代表从右边起第j位中的1的个数
		}
		for(int i=0;i<32;i++)
		{
			count|=result[i]%3<<i;//扩大2^i次方倍，然后或运算，即把count的右起第i位置1
		}
		return count;
	}
}
