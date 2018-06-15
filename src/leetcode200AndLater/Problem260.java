package leetcode200AndLater;

public class Problem260
{
	/*
	 * Input:  [1,2,1,3,2,5]
	Output: [3,5]
	两个数出现了一次，其他出现两次
	
	首先遍历整个数组，讲所有的值相异或，那么最后的值肯定是两个相异的值异或的结果。

	这两个值不同，那么肯定有一位的二进制值不同，那么这个位相异或的结果肯定是这位的数值为1；

	那么我们寻找这个数值位为1的位，

	这里采用非常巧妙的方法：resTwo &= -resTwo; 因为int整数在java中是按照补码的方式来的，那么正数和它负值按位与的结果是原始最右边非0位的数字为1，其余位都为0；

	这样我们把原来的数组分为两个部分，一部分是和resTwo按位与的结果为0的，另一部分的结果和resTwo按位与的结果为1的，并且那两个不相等的数分别落在这两个组中；

	这样分别对两组的数异或，即可得到这两个数。
	
	 */
	public int[] singleNumber(int[] nums)
	{
		int[] ans = new int[2];
        int diff = 0;
        for(int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        for(int num : nums) {
            if((num & diff) == 0) {
                ans[0] ^= num;
            }else {
                ans[1] ^= num;
            }
        }
        return ans;
	}
}
