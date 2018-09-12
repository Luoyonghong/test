package 京东;

public class 排列
{
	static int map[]=new int[26];
	static int solve(String S, String T)
	{
		int nums[]=new int[S.length()];
		for(int i=0;i<S.length();i++)
		{
			nums[i]=S.charAt(i)-'a';
		}
		int b[]=new int[T.length()];
		for(int i=0;i<b.length;i++)
		{
			b[i]=T.charAt(i)-'a';
		}
		int count=0;
		for(int i=0;i<nums.length;i++)
		{
			if(xiangsi(nums, b,i,i+T.length()))
				count++;
		}
		return count;

	}

	public static void main(String[] args)
	{
		String s = "ababcb", t = "xyx";
		System.out.println(solve(s, t));

	}
	public static boolean xiangsi(int nums[], int[] b ,int begin, int end)//包含i，不包含j
	{
		//aba xyx
		if(end>nums.length)
		{
			return false;
		}
		
		for(int i=0;i<26;i++)
			map[i]=-1;
		for(int i=begin;i<end;i++)
		{
			if(map[b[i-begin]]==-1)
				map[b[i-begin]]=nums[i];
			else
			{
				if(map[b[i-begin]]!=nums[i])
					return false;
			}
		}
		return true;
	}
}
