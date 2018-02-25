package leetcode162AndLater;

public class Problem171
{
	public int titleToNumber(String s)
	{
		int res=0;
		for(int i=0;i<s.length();i++)
		{
			char a=s.charAt(i);
			res=res*26+(int)(a-'A')+1;
		}
		return res;
	}
	public static void main(String[] args)
	{
		Problem171 p=new Problem171();
		System.out.println(p.titleToNumber("AA"));  
	}
}
