package 拼多多;

public class 第一题
{

	public static void main(String[] args)
	{
		
	}
	
	
	public static void f(int nums[])
	{
		// 1 2 2 2 4 2  
		int length = nums.length;
		if(length == 0 )
			return;
		if(length == 1)
			System.out.println(nums[0]); 
		int lastvalue = nums[0];
		int begin_index = 0;
		int index = 1;
		while(index < length)
		{
			if(nums[index] != lastvalue)
			{
				lastvalue = nums[index];
				index ++;
			}
			else
			{
				begin_index = index - 1;
				int repeat_value = nums[begin_index];
				index ++;
				while(index < length && nums[index] == lastvalue)
					index ++;
				//index 第一个不等于lastvalue 的下标
				//重复值： [lastindex:index]
				int repeat_count = index - begin_index;
				int thres = index + repeat_count - 1;
				while(index < length && index < thres)
				{
					System.out.println(repeat_value);
					System.out.println(nums[index]); 
					index ++;
				}
				if(index < length)
					lastvalue = nums[index];
			}
		}
	}
}
