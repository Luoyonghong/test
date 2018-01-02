package leetcode62AndLater;

public class Problem67
{

	public String addBinary(String a, String b)
	{
		StringBuffer buffer=new StringBuffer();
		int m=a.length(), n=b.length(),temp=0;
		for(int i=Math.max(m,n)-1;i>=0;i--)
		{
			int t1=0,t2=0;
			if(Math.max(m,n)-1-i<m)
				t1=a.charAt(-Math.max(m,n)+m+i)-'0';
			if(Math.max(m,n)-1-i<n)
				t2=b.charAt(-Math.max(m,n)+n+i)-'0';
			char g=(char) ((t1+t2+temp)%2+'0');
			buffer.append(g);
			temp=(t1+t2+temp)/2;
		}
		if(temp==1)
			buffer.append('1');
		buffer.reverse();
		return buffer.toString();
	}
	public static void main(String[] args)
	{
		String a="11";
		String b="1";
		System.out.println(new Problem67().addBinary(a, b)); 
	}
}
