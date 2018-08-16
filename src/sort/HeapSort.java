package sort;

import java.util.Arrays;

public class HeapSort
{
	
	public void downadjust2(int i, int[] nums, int length)
	{
		if(2*i+2>length)
			return;
		int leftchild=nums[i*2+1],rightchild=nums[i*2+2];
		int maxchild=Math.max(leftchild, rightchild);
		int maxindex=leftchild>rightchild?2*i+1:2*i+2;
		if(nums[i]>=maxchild)
			return;
		else
		{
			swap(maxindex,i,nums);
			downadjust2(maxindex,nums,length);
		}
	}
	
	public void sort2(int[] nums)
	{
		for(int i =nums.length-1;i>=0;i--)
			downadjust2(i,nums,nums.length-1);
		for(int i=0;i<nums.length;i++)
		{
			swap(0, nums.length-1-i, nums); 
			downadjust2(0,nums,nums.length-2-i);
			//注意这里必须是nums.length-2-i，不能是nums.length-1-i
		}
		
	}
	
	
	
	
	
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
		h.sort2(nums);
		for (int i : nums)
		{
			System.out.print(i+" "); 
		}
		String[] sss= {"csx","csxs","cdveqsx"};
		Arrays.sort(sss);
		for(int i =0;i<sss.length;i++)
			System.out.print(sss[i]+" "); 
	}
}
