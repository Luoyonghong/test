package leetcode162AndLater;

public class Problem167
{

	public int[] twoSum(int[] numbers, int target)
	{
		int begin=0,end=numbers.length-1;
		int re[]=new int[2];
		while(begin<end)
		{
			if(numbers[begin]+numbers[end]>target)
				end--;
			else if(numbers[begin]+numbers[end]<target)
				begin++;
			else
			{
				re[0]=begin+1;
				re[1]=end+1;
				return re;
			}
				
		}
		return re;
	}
}
