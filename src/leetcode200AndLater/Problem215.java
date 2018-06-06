package leetcode200AndLater;

public class Problem215
{
	public int findKthLargest(int[] nums, int k)
	{
		k=nums.length-k;
		int begin=0,end=nums.length-1;
		int t=quicksort(nums, 0, nums.length-1);
		while(t!=k)
		{
			System.out.println("begin: "+begin+" end: "+end+" t: "+t); 
			if(k>t)
			{
				begin=t+1;
				t=quicksort(nums, begin, end);
				continue;
			}
			if(k<t)
			{
				end=t-1;
				t=quicksort(nums, begin, end);
				continue;
			}
				
		}
		return nums[t];
	}
	public int quicksort(int nums[], int begin, int end)
	{
		int a=begin,b=end;
		int pos=nums[begin];
		while(a<b)
		{
			while(nums[b]>=pos&&b>a)
				b--;
			while(nums[a]<=pos&&b>a)
				a++;
			int t=nums[a];nums[a]=nums[b];nums[b]=t;
		}
		nums[begin]=nums[b];
		nums[b]=pos;
		return b;
	}
	public static void main(String[] args)
	{
		Problem215 p=new Problem215();
		int [] nums={3,2,1,5,6,4}; 
		System.out.println(p.findKthLargest(nums, 2)); 
	}
}
