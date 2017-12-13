package leetcode33AndLarger;

public class Problem33
{

	public int search(int[] nums, int target)
	{
//		int middle=nums.length/2;
//		if(target==nums[middle])
//			return middle;
//		if(nums[0]<nums[middle]&&target<nums[middle]&&target>nums[0])
//			return func(nums,0,middle,target);
//		if(nums[0]<nums[middle]&&(target>nums[middle]||target<nums[0]))
//			return func(nums,middle+1,nums.length-1,target);
//		if(nums[middle+1]<nums[nums.length-1]&&target<nums[nums.length-1]&&target>nums[middle+1])
//			return func(nums,middle+1,nums.length-1,target);
//		if(nums[middle+1]<nums[nums.length-1]&&(target<nums[middle+1]||target>nums[nums.length-1]))
//			return func(nums,0,middle,target);
//		return -1;
		if(nums.length==0)
			return -1;
		return func(nums,0,nums.length-1,target);
	}
	public int func(int [] nums, int left, int right , int target)
	{
		System.out.println("left: "+left+" right: "+right); 
		if(left==right)
		{
			if(target==nums[left])
				return left;
			else
				return -1;
		}	
		if(left+1==right)
		{
			if(target==nums[left])
				return left;
			else if(target==nums[right])
				return right;
			else
				return -1;
		}
		
		int middle=(left+right)/2;
		if(target==nums[middle])
			return middle;
		
		if(nums[left]<=nums[middle]&&target<=nums[middle]&&target>=nums[left])
			return func(nums,left,middle,target);
		if(nums[left]<=nums[middle]&&(target>nums[middle]||target<nums[left]))
			return func(nums,middle+1,right,target);
		if(nums[middle+1]<=nums[right]&&target<=nums[right]&&target>=nums[middle+1])
			return func(nums,middle+1,right,target);
		if(nums[middle+1]<=nums[right]&&(target<nums[middle+1]||target>nums[right]))
			return func(nums,left,middle,target);
		return -1;
		

	}
	public static void main(String[] args)
	{
		Problem33 p=new Problem33();
		int[] nums={5,1,3};
			//{4,5,6, 7, 0, 1, 2};
		System.out.println(p.search(nums, 3));
	}
}
