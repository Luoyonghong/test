package leetcode43AndLater;

public class Problem55
{
	public boolean canJump(int[] nums)
	{
		int maxReach=nums[0];
		for(int i=0;i<nums.length;i++)
		{
			if(i<=maxReach)
			{
				if(nums[i]+i>maxReach)
					maxReach=nums[i]+i;
				//System.out.println("i: "+i+" maxReach: "+maxReach); 
			}
		}
		if(maxReach>=nums.length-1)
			return true;
		else
			return false;
		
	}
	public static void main(String[] args)
	{
		Problem55 p=new Problem55();
		//int[] nums={2,3,1,1,4};
		//int[] nums={3,2,1,0,4};
		int[] nums={1,2,3};
		System.out.println(p.canJump(nums));
	}

}
