package sort;

public class QuickSort
{

	public void sort(int nums[],int left,int right)
	{
		if(left>=right) 
			return; 
		int temp=nums[left];
		int i=left,j=right;
		while(i!=j)//或者换成i<j也行
		{
			//最后循环完毕之后i肯定等于j,i<j或者i!=j的时候继续循环
			while(nums[j]>temp&&j>i)//有没有等号都行，必须从right开始，不能从left开始！
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
		q.sort(nums, 0, nums.length-1); 
		for (int i : nums)
		{
			System.out.print(i+" "); 
		}
		
		int a=-10;
		System.out.println(a>>>10);
		
//		for(int i=0;i<5;i++)
//		{
//			System.out.println(a);
//			a=a>>1;
//		}
		try
		{
			int v=Integer.parseInt("cs");
		}
		catch(Exception e)
		{
			System.out.println("inner catch"); 
		}
		System.out.println("after catch"); 
		System.out.println(Double.parseDouble("123.e+6")); 
	}
}
