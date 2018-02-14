package LeetCode120AndLater;

public class Problem126
{
	public boolean isPalindrome(String s)
	{
		if(s.length()==0)
			return true;
		char[] t=new char[s.length()];
		int count=0;
		for(int i=0;i<t.length;i++)
		{
			char f=s.charAt(i);
			if(('a'<=f&&'z'>=f)||('A'<=f&&'Z'>=f)||('0'<=f&&'9'>=f))
			{
				t[count]=Character.toLowerCase(f);
				count++;
			}
		}//一共有count个有效字符
		if(count==0)
		            return true;
		//System.out.println(count);
		for(int i=0;i<count/2+1;i++)
		{
			if(t[i]!=t[count-1-i])
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		Problem126 p=new Problem126();
		System.out.println(p.isPalindrome("ab")); 
	}
}
