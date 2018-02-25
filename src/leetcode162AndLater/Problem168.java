package leetcode162AndLater;

public class Problem168
{
	public String convertToTitle(int n)
	{
		n=n;
		StringBuffer b=new StringBuffer();
		while(n>0)
		{
			int t=(n-1)%26;
			b.append((char)('A'+t));
			if(t==25)
				n--;
			n=n/26;
		}
		return b.reverse().toString();
	}
	public static void main(String[] args)
	{
		Problem168 p=new Problem168();
		System.out.println(p.convertToTitle(53)); 
	}
}
