package leetcode33AndLarger;

public class Problem34
{
	int a[]=new int[2];
	public int[] searchRange(int[] nums, int target) {
        a[0]=-1;
        a[1]=-1;
        func(nums,0,nums.length-1,target);
        return a;
    }
	
	public void func(int [] nums, int left, int right , int target)
	{
		System.out.println("left: "+left+" right: "+right); 
		if(nums[left]==nums[right])
		{
			if(target==nums[left])
			{
				if(left<a[0])
					a[0]=left;
				if(right>a[1])
					a[1]=right;
				if(a[0]==-1)
					a[0]=left;
				if(a[1]==-1)
					a[1]=left;
			}
			return ;
		}	
		if(left+1==right&&nums[left]!=nums[right])
		{
			if(nums[left]==target)
			{
				if(left<a[0])
					a[0]=left;
				if(left>a[1])
					a[1]=left;
				if(a[0]==-1)
					a[0]=left;
				if(a[1]==-1)
					a[1]=left;
				return;
			}
			if(nums[right]==target)
			{
				if(right<a[0])
					a[0]=right;
				if(right>a[1])
					a[1]=right;
				if(a[0]==-1)
					a[0]=right;
				if(a[1]==-1)
					a[1]=right;
				return;
			}
			return;
		}
		
		
		int middle=(left+right)/2;
		//if(target==nums[middle]&&target==nums[midd])
		
		if(target<=nums[middle]&&target>=nums[left])
			 func(nums,left,middle,target);
		if((target>=nums[middle]&&target<=nums[right]))
			 func(nums,middle,right,target);
		
		return;
		

	}
	
	public static void main(String[] args)
	{
		Problem34 p=new Problem34();
		int [] a;
		int[] nums={1};
		a=p.searchRange(nums, 1);
		for (int i : a)
		{
			System.out.println(i);
		}
	}
}
