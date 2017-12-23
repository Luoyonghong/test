package leetcode43AndLater;

public class Problem45
{
	public int jump2(int[] nums,int y)
	{
		int []r=new int[nums.length];
		for(int i=0;i<r.length;i++)
			r[i]=Integer.MAX_VALUE;
		int a=nums[0];
		r[0]=0;
		for(int i=1;i<=a&&i<nums.length;i++)
		{
			r[i]=1;
		}
		//printR(r);
		for(int i=1;i<nums.length;i++)
		{
			for(int j=i;j<=i+nums[i]&&j<nums.length;j++)
			{
				//更新r[j]
				if(r[j]>r[i]+1)
					r[j]=r[i]+1;
			}
			//printR(r);
		}
		
		return r[nums.length-1];
	}
	int jump(int A[], int n) {
        int ret = 0;
        int curMax = 0;//目前能到达的最远距离
        int curRch = 0;//上一步所能到达的最远位置
        for(int i = 0; i < n; i ++)
        {
            if(curRch < i)
            {
                ret ++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, A[i]+i);
        }
        return ret;
    }
	
	public void printR(int [] r)
	{
		for (int i : r)
		{
			System.out.print(i+" ");
		}
		System.out.println(); 
	}
	
	public static void main(String[] args)
	{
		Problem45 p=new Problem45();
		//int[] nums={2,3,1,1,4};
		int[] nums={2};
		System.out.println(p.jump(nums,nums.length)); 
	}
}
