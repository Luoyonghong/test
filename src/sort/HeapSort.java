package sort;

public class HeapSort
{
	/*
	 * 节点i的左孩子是2*i+1,右：2*i+2
	 * 父节点：(i-1)/2
	 */
	public void downAdjust(int j, int[] nums, int length)
	{
		int child=j*2+1;
		while(child<=length)
		{
			if(child+1<=length)
			{
				if(nums[child]<nums[child+1])
					child++;
			}//child是子节点中最大的一个的坐标
			if(nums[j]<nums[child])
			{
				int temp=nums[j];
				nums[j]=nums[child];
				nums[child]=temp;
				j=child;
				child=j*2+1;
			}
			else
				break;
		}
	}
	
	public void sort(int [] nums)
	{
		for(int i=(nums.length-1);i>=0;i--)
		{
			downAdjust(i, nums, nums.length-1); 
		}
		for(int i=nums.length-1;i>=0;i--)
		{
			swap(0, i, nums); 
			downAdjust(0, nums, i-1); 
		}
		
	}
	
	public void swap(int i, int j,int nums[])
	{
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	public static void main(String[] args)
	{
		int[] nums={1,2,8,3,5,4,-1,2,1};
		HeapSort h=new HeapSort();
		h.sort(nums);
		for (int i : nums)
		{
			System.out.print(i+" "); 
		}
	}
}
