package leetcode300AndLater;

public class Problem313
{
	public int nthSuperUglyNumber(int n, int[] primes)
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return primes[0];
		int[] p=primes;
		int k =p.length;
		int re[]=new int[n];
		re[0]=1;
		re[1]=p[0];
		int index[] =new int[k];
		//index代表当前的所有输出中，每个因子的最后输出乘上的是哪一个数
		//假设已经有了输出re[i],那么下一个输出一定是某个因子*re[i]之前的某个数，index[j]就代表当前因子应该乘上哪个数
		for(int i =1;i<n;i++)
		{
			int min =Integer.MAX_VALUE;
			int id=0;
			for(int j=0;j<k;j++)
			{
				if(p[j]*re[index[j]]<min) 
				{
					id=j;
					min=p[j]*re[index[j]];
				}
			}
			re[i]=min;
			for(int j=0;j<k;j++) {
		                if(re[i] % primes[j]==0) index[j]++;
		            }
			//index[id]++;
			//不能直接根据当前最小值的id来自增，因为有可能一个数是由两个因子组成的，所以那两个因子的id都要加一，不然
			//下次的结果会有重复（因为只有一个因子的index++，所以另外一个因子在下一轮还能得到刚刚的结果，导致重复）
			
		}
		for(int i =0;i<n;i++)
			System.out.print(re[i]+" ");
		System.out.println(); 
		return re[n-1];
	}
	public static void main(String[] args)
	{
		Problem313 p=new Problem313();
		//int nums[]={2, 7, 13, 19};
		int[] nums={3,5,7,11,19,23,29,41,43,47};
		System.out.println(p.nthSuperUglyNumber(15, nums));
		 
	}
}
