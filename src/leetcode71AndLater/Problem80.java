package leetcode71AndLater;

public class Problem80
{
	public int removeDuplicates(int[] nums)
	{
		int count=0;//某个数字出现次数
		int index=1;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]!=nums[i-1])
			{//说明和前一个数据不同，是新的，于是count=1，把当前数字复制到index上，index肯定小于i
				count=1;
				nums[index]=nums[i];
				index++;
				continue;
			}
			else if(count<2)//说明当前数据和前一个数据相同，且count<2,把当前数字复制到index上
			{
				count=2;//设置count>=2，防止第2+个重复数字也被放到index上
				nums[index]=nums[i];
				index++;
				//count=0;
				continue;
			}
		}
		return index;
	}
	public static void main(String[] args)
	{
		Problem80 p=new Problem80();
		int[] nums={1,1,1,2,2,3};
		p.removeDuplicates(nums);
		for (int i : nums)
		{
			System.out.print(i);
		}
	}
}
