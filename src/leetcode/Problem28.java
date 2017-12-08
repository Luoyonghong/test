package leetcode;

public class Problem28
{
	public int strStr(String haystack, String needle)
	{
		if(needle.length()>haystack.length())
			return -1;
		if(needle.length()==0)
			return 0;
		int l1=haystack.length();
		int l2=needle.length();
		for(int i=0;i<=l1-l2;i++)
		{
			if(haystack.substring(i, i+l2).compareTo(needle)==0)
				return i;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		String s="sss";
		s.indexOf("cs");
	}

}
