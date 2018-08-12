package leetcode300AndLater;

public class Problem319
{
	public int bulbSwitch(int n)
	{
		//计算出1-n当中每个数的因子到底有多少个，返回单数个数
//		int sum=0;
//		for(int i=1;i<=n;i++)
//		{
//			int temp=getfactornumbers(i);
//			if(temp%2==1)
//				sum+=1;
//		}
//		return sum;
		return (int)Math.sqrt(n);
	}
	public int getfactornumbers(int k)
	{
		int temp=1;
		int r=(int)Math.sqrt(k);
		for(int i=2;i<=r;i++)
		{
			if(k%i==0)
				temp++;
		}
		temp*=2;
		if(Math.sqrt(k)==r)
			temp--;
		return temp;
		//太傻！这里都看出来了，temp当不是完全平方数的时候肯定是2的倍数，一定是偶数！，所以只需要找出完全平方数个数即可
	}
	public static void main(String[] args)
	{
		Problem319 p =new Problem319();
		System.out.println(p.bulbSwitch(4));  
	}
	
}
