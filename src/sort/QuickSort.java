package sort;

public class QuickSort
{

	public void sort2(int nums[],int begin, int end)
	{
		if(begin>=end)
			return;
		//int middle=(begin+end)/2;
		int pivot =nums[begin];
		int left=begin,right=end;
		while(left<right)
		{
			while(nums[right]>=pivot&&left<right)
				right--;
			while(nums[left]<pivot&&left<right)
				left++;
			if(left<right)
			{
				int temp=nums[left];
				nums[left]=nums[right];
				nums[right]=temp;
			}
		}
		nums[begin]=nums[right];
		nums[right]=pivot;
		
		sort(nums,begin,right-1);
		sort(nums,right+1,end);
	}
	
	

	
	public void sort(int nums[],int left,int right)
	{
		if(left>=right) 
			return; 
		int temp=nums[left];
		int i=left,j=right;
		while(i!=j)//或者换成i<j也行
		{
			//最后循环完毕之后i肯定等于j,i<j或者i!=j的时候继续循环
			while(nums[j]>temp&&j>i)//有没有等号都行，必须从right开始，不能从left开始！从左边开始的话，最后一个i是大于temp的，然后交换i和temp，必然出错，从右边开始，最后一个i是小于temp的
				j--;
			while(nums[i]<=temp&&i<j)
				i++;
			if(i<j)//没有此判断也行
			{
				int t=nums[i];
				nums[i]=nums[j];
				nums[j]=t;
			}
		}
		nums[left]=nums[i];
		nums[i]=temp;
		sort(nums, left, i-1);
		sort(nums, i+1, right); 
	}
	public static void main(String[] args)
	{
		int nums[]={1,2,8,3,5,4,-1,2,1};
		QuickSort q=new QuickSort();
		q.sort2(nums, 0, nums.length-1); 
		for (int i : nums)
		{
			System.out.print(i+" "); 
		}
		
		
	}
}
