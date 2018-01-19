package leetcode87AndLater;

public class Problem87
{

	public boolean isScramble(String s1, String s2)
	{
		char[] s_1=s1.toCharArray();
		char[] s_2=s2.toCharArray();
		return func(s_1, s_2, 0, s1.length(), 0,s1.length());
	}
	public boolean func(char[] s1,char[] s2,int begin1,int end1,int begin2,int end2)
	{
//		for(int i=begin1;i<end1;i++)
//		{
//			System.out.print(s1[i]);
//		}
//		System.out.print(" ");
//		for(int i=begin2;i<end2;i++)
//		{
//			System.out.print(s2[i]);
//		}
//		System.out.println(); 
		System.out.println("begin1: "+begin1+" end1: "+end1+" begin2: "+begin2+" end2: "+end2);
		if(begin1<0||begin2<0||end1>s1.length||end2>s1.length)
			return false;
		
		int count[]=new int[256];
		for(int i=begin1;i<end1;i++)
		{
			count[s1[i]]++;
		}
		for(int i=begin2;i<end2;i++)
		{
			count[s2[i]]--;
		}
		for(int i=0;i<256;i++)
			if(count[i]!=0)
				return false;
		
		if(begin1+2==end1)
		{
			if(s1[begin1]==s2[begin2]&&s1[begin1+1]==s2[begin2+1])
				return true;
			if(s1[begin1]==s2[begin2+1]&&s1[begin1+1]==s2[begin2])
				return true;
			return false;
		}
		
		
		if(begin1+1==end1)
			if(s1[begin1]==s2[begin2])
				return true;
			else
				return false;
		for(int i=0;i<end1-begin1-1;i++)
		{
			if(func(s1, s2, begin1, begin1+i+1, end2-i-1, end2)
					&&func(s1, s2, begin1+i+1, end1, begin2, end2-i-1))
				return true;
			if(func(s1, s2, begin1, begin1+i+1, begin2, begin2+i+1)
					&&func(s1, s2, begin1+i+1, end1, begin2+i+1, end2))
				return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		Problem87 p=new Problem87();
		//System.out.println(p.isScramble("rgtae", "great"));
		System.out.println(p.isScramble("abcd", "bcad")); 
	}
}
