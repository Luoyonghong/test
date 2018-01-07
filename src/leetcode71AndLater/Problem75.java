package leetcode71AndLater;

public class Problem75
{

	public void sortColors(int[] nums)
	{
		int num0=0,num1=0,num2=0;
		for(int i=0;i<nums.length;i++)
			switch (nums[i])
			{
			case 0:
				num0++;
				break;
			case 1:
				num1++;
				break;
			case 2:
				num2++;
				break;
			default:
				break;
			}
		int c=0;
		num1+=num0;
		num2+=num1;
		//System.out.println("num0: "+num0+" num1: "+num1+" num2: "+num2); 
		int nowNum0=num0,nowNum1=num1,nowNum2=num2;
		while(c<nums.length)
		{
//			for (int i : nums)
//			{
//				System.out.print(i+" "); 
//			}
//			System.out.println("c: "+c);
			if(c<nowNum0)
			{
				if(nums[c]==1)
				{
					int t=nums[c];
					nums[c]=nums[num1-1];
					nums[num1-1]=t;
					num1--;
				}
				if(nums[c]==2)
				{
					int t=nums[c];
					nums[c]=nums[num2-1];
					nums[num2-1]=t;
					num2--;
				}
				if(nums[c]==0)
				{
					c++;
				}
			}
			if(c<nowNum1&&c>=nowNum0)
			{
				if(nums[c]==0)
				{
					int t=nums[c];
					nums[c]=nums[num0-1];
					nums[num0-1]=t;
					num0--;
				}
				if(nums[c]==2)
				{
					int t=nums[c];
					nums[c]=nums[num2-1];
					nums[num2-1]=t;
					num2--;
				}
				if(nums[c]==1)
				{
					c++;
				}
			}
			if(c<nowNum2&&c>=nowNum1)
			{
				if(nums[c]==1)
				{
					int t=nums[c];
					nums[c]=nums[num1-1];
					nums[num1-1]=t;
					num1--;
				}
				if(nums[c]==0)
				{
					int t=nums[c];
					nums[c]=nums[num0-1];
					nums[num0-1]=t;
					num0--;
				}
				if(nums[c]==2)
				{
					c++;
				}
			}
			
		}
	}
	public static void main(String[] args)
	{
		Problem75 p=new Problem75();
		int[] nums={0,1,2,0,2,1};
		p.sortColors(nums);
		for (int i : nums)
		{
			System.out.print(i+" "); 
		}
	}
}
