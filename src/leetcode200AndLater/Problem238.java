package leetcode200AndLater;

public class Problem238
{
	public int[] productExceptSelf(int[] nums)
	{
		int []res=new int[nums.length];
		if(nums.length==0)
			return new int[]{};
		res[0]=nums[0];
		for(int i=1;i<nums.length;i++)
		{
			res[i]=res[i-1]*nums[i];
		}
		int t=1;
		for(int i=nums.length-1;i>0;i--)
		{
			res[i]=res[i-1]*t;
			t=t*nums[i];
		}
		res[0]=t;
		return res;
	}
	public static void main(String[] args)
	{
		Problem238 p=new Problem238();
		int []re =p.productExceptSelf(new int[]{1,2,3,4});
		for (int i : re)
		{
			System.out.println(i);
			
		}
	}
}
