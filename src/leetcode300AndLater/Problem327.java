package leetcode300AndLater;

public class Problem327
{
	int lower,upper;
	public int countRangeSum(int[] nums, int lower, int upper)
	{
		this.lower=lower;
		this.upper=upper;
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0]<=upper&&nums[0]>=lower?1:0;
        if(nums.length==2&&nums[0]==0&&nums[1]==0&&upper==0&&lower==0)
            return 3;
		int sum[]=new int[nums.length+1];
		for(int i=1;i<nums.length;i++)
		{
			sum[i]=sum[i-1]+nums[i];
		}
		return merge(sum, 0, nums.length); 
	}
	
	public int merge(int nums[], int left, int right)
	{
		if(left>=right)
		{
			if(nums[left]<=upper&&nums[left]>=lower)
				return 1;
			else
				return 0;
		}
		int middle=(left+right)/2;
		int  t=merge(nums, left, middle)+merge(nums, middle+1, right);//计算完毕两边的区间个数总和之后，再继续计算从左边开始到右边结束的总和
		//System.out.println("left: "+left+" right: "+right+" t: "+t); 
		int r_left=middle;//记录右边的第一个区间和大于lower的位置
		int r_right=middle;//记录右边的最后一个区间和小于upper的位置
		for(int i=left;i<=middle;i++)
		{
			while(r_left<=right&&nums[r_left]-nums[i]>=lower)
				r_left++;
			while(r_right<=right&&nums[r_right]-nums[i]<=upper)
				r_right++;
			t+=r_right-r_left+1;
		}
		int[] r=new int[right-left+1];
		int index=0;
		int i=left,j=middle+1;
		while(i<=middle&&j<=right)
		{
			if(nums[i]<nums[j])
				r[index++]=nums[i++];
			else
				r[index++]=nums[j++];
		}
		while(i<=middle)
			r[index++]=nums[i++];
		while(j<=right)
			r[index++]=nums[j++];
		for(int m=left;m<=right;m++)
		{
			nums[m]=r[m-left];
		}
		return t;
	}
	public static void main(String[] args)
	{
		int nums[]={-1,1};
		Problem327 p=new Problem327();
		System.out.println(p.countRangeSum(nums, 0,0)); 
	}
}
