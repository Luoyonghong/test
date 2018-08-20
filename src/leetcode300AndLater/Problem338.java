package leetcode300AndLater;

public class Problem338
{

	public int[] countBits(int num)
	{
		int re[]=new int[num+1];
		if(num==0)
			return re;
		int h=1;
		for(int i=1;i<=num;i++)
		{
			if(h*2<i)
				h*=2;
			if(i==h*2||i==1)
				re[i]=1;
			else
			{
				re[i]=re[h]+re[i-h];
			}
		}
		return re;
	}
	public static void main(String[] args)
	{
		Problem338 p=new Problem338();
		int[] re=p.countBits(8);
		for(int i=0;i<re.length;i++)
			System.out.print(re[i]+" ");
	}
}
