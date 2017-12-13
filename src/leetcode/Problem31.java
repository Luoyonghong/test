package leetcode;

public class Problem31
{
	/*
	 * 从最后开始找递增序列，
	 * 找到第一个递减的，
	 * 然后从后面那群递增的当中找出最小的与那个递减的交换
	 * 后面那群递增的再排个序
	 * 14533---找到4，然后交换4,5，再对4 3 3排序
	 * 132--找到1，交换1和2，然后3 2排序
	 */
	public static void nextPermutation(int[] nums)
	{
		int n=nums.length;
		if(n==1)
			return;
		if(nums[n-1]>nums[n-2])
		{
			int t=nums[n-1];
			nums[n-1]=nums[n-2];
			nums[n-2]=t;
			return ;
		}
		else
		{
			int kn=n;
			while(kn-2>=0&&nums[kn-1]<=nums[kn-2])
			{
				kn--;
			}
			if(kn==1)
			{
				func(nums, n);
				return;
			}
			int t=nums[kn-2];
			int minIndex=kn-1;
			for(int i=minIndex;i<n;i++)
			{
				if(nums[i]>t&&nums[i]<nums[minIndex])
					minIndex=i;
			}
			nums[kn-2]=nums[minIndex];
			nums[minIndex]=t;
			func(nums,n-kn+1);
		}
	}
	
	public static void func(int[] nums,int limit)
	{
		if(limit==1)
			return ;
//		for (int i : nums)
//		{
//			System.out.print(i+"  "); 
//		}
//		System.out.println();
//		System.out.println("limit:" +limit); 
		int n=nums.length;

//			int kn=n;
//			while(n-kn+1<limit&&nums[n-1]<=nums[kn-2])
//			{
//				kn--;
//			}
//			System.out.println("kn:  "+kn); 
//			if(n-kn+1==limit)
//			{
//				int t=nums[kn-1];
//				nums[kn-1]=nums[n-1];
//				nums[n-1]=t;
//				func(nums,n-kn);
//				return;
//			}
//			
//			int t=nums[kn-2];
//			nums[kn-2]=nums[n-1];
//			nums[n-1]=t;
//			func(nums,n-kn+1);
		int min=Integer.MAX_VALUE;
		int minindex=n-1;
		for(int i=0;i<limit;i++)
		{
			if(nums[n-i-1]<min)
			{
				min=nums[n-i-1];
				minindex=n-i-1;
			}
		}
		int t=nums[n-limit];
		nums[n-limit]=nums[minindex];
		nums[minindex]=t;
		func(nums,limit-1);
		
	}
	public static void diverse(int[] nums, int limit)
	{
		int n=nums.length;
		for(int i=0;i<limit/2;i++)
		{
			int t=nums[n-1];
			nums[n-1]=nums[i];
			nums[i]=t;
			n--;
		}
	}
	public static void main(String[] args)
	{
		int a[]={1,3,2};
		nextPermutation(a);
		for (int i : a)
		{
			System.out.println(i); 
		}
	}
}
