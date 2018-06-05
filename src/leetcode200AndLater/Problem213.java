package leetcode200AndLater;

public class Problem213
{
	boolean used[]; 
	int sum=0;
	int max=0;
	public void help(int [] nums)
	{
		for(int i=0;i<nums.length;i++)
		{
			if(!used[i]&&!used[(i-1+nums.length)%nums.length]&&!used[(i+1)%nums.length])
			{
				used[i]=true;
				sum+=nums[i];
				help(nums);
				sum-=nums[i];
				used[i]=false;
			}
		}
		max=sum>max?sum:max;
	}
	
	public int rob(int[] nums)
	{
		used=new boolean[nums.length];
		help(nums);
		return max;
	}
	public static void main(String[] args)
	{
		Problem213 p=new Problem213();
		int nums[]={2,3,1};
		System.out.println(p.rob(nums)); 
	}
	
}
