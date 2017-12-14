package leetcode33AndLarger;

public class Problem35
{
	public int searchInsert(int[] nums, int target)
	{
		return func(nums,0,nums.length-1,target);
	}
	public int func(int [] nums, int left, int right , int target)
	{
		System.out.println("left: "+left+" right: "+right); 
		
		if(left==right)
		{
			if(nums[left]>=target)
				return left;
			if(nums[left]<target)
				return left+1;
		}
		int middle=(left+right)/2;
		//if(target==nums[middle]&&target==nums[midd])
		
		if(target<=nums[middle])
			 return func(nums,left,middle,target);
		if(target>nums[middle])
			return func(nums,middle+1,right,target);
		
		return 0;
	}
	public static void main(String[] args)
	{
		Problem35 p=new Problem35();
		int nums[]={1,3,5,6};
		System.out.println(p.searchInsert(nums,5));
	}
}
