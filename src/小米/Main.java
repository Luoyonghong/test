package 小米;

public class Main
{
	/*
	 * 求10张纸牌有放回抽取中，连续抽出10张不一样纸牌的概率/期望
	 */
	public static void main(String[] args)
	{
		double[] p=new double [10];
		p[0]=1;
		for(int i=1;i<10;i++)
		{
			//求概率的话直接连乘
			p[i]=p[i-1]*(double)(10-i+1)/(double)10;
		}
		System.out.println("概率是："+p[9]);
		
		double[] expectation=new double[10];
		expectation[0]=1;
		for(int i=1;i<10;i++)
		{
			//设目前手头已经有了i-1张不同的牌，则从当前状态到抽到i张不同的牌的抽牌次数期望为Ti,
			//则Ti=(10-i+1)/10*1(这次以10-i+1/10的概率抽到了不同的牌，不需要再抽了)+(i-1)/10*(1+Ti+...+Ti)(这次以i-1/10的概率抽到重复的，还需要重新抽取T1+T2+...+Ti次)
			//可以解出通项公式，由于时间关系，没有求解
			double sum=0;
			for(int j=0;j<i;j++)
				sum+=expectation[j];
			expectation[i]=((double)(10-i+1)/(double)10)*1+((double)(i-1)/(double)10)*sum;
		}
		double totalSum=0;
		//总共需要抽取次数的期望为T1+...+T10
		for (double d : expectation)
		{
			totalSum+=d;
		}
		System.out.println("期望抽取次数为: "+totalSum);
	}
}
