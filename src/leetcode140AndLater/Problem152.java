package leetcode140AndLater;

public class Problem152
{
	public int maxProduct(int[] nums)
	{
		int [] A=nums;
		int max = A[0];
		int length = A.length;
		int[] dp_min = new int[length];//放当前最大值和最小值
		int[] dp_max = new int[length];
		dp_min[0] = dp_max[0] = A[0];
		for (int i = 1; i < length; ++i)
		{
			dp_min[i] = Math.min(Math.min(dp_max[i - 1] * A[i], dp_min[i - 1] * A[i]), A[i]);
			dp_max[i] = Math.max(Math.max(dp_max[i - 1] * A[i], dp_min[i - 1] * A[i]), A[i]);
			max = Math.max(dp_max[i], max);
		}
		return max;
	}

	public static void main(String[] args)
	{
		Problem152 p = new Problem152();
		// int[] nums={2,3,0,4,7,-1,-10,3};
		int[] nums = { 0, 2 };
		System.out.println(p.maxProduct(nums));
	}
}
