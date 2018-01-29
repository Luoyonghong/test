package leetcode87AndLater;


public class Problem97
{
	boolean r[][][];
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if(s1.length()+s2.length()!=s3.length())
			return false;
		if(s1.length()==0&&s2.length()==0&&s3.length()==0)
			return true;
		if(s1.length()==0)
			return s2.equals(s3);
		if(s2.length()==0)
			return s1.equals(s3);
		boolean path[][]=new boolean[s1.length()+1][s2.length()+1];
		
		
		for(int i=0;i<=s1.length();i++)
			for(int j=0;j<=s2.length();j++)
			{
				if(i == 0 && j == 0)
	                // start
	                    path[i][j] = true;
	                else if(i == 0)
	                    path[i][j] = path[i][j-1] & (s2.charAt(j-1)==s3.charAt(j-1));
	                else if(j == 0)
	                    path[i][j] = path[i-1][j] & (s1.charAt(i-1)==s3.charAt(i-1));
	                else
	                    path[i][j] = (path[i][j-1] & (s2.charAt(j-1)==s3.charAt(i+j-1)) || (path[i-1][j] & (s1.charAt(i-1)
	                    		==s3.charAt(i+j-1))));
			}
		return path[s1.length()][s2.length()];
		
	}
	
	
	//超时
	public boolean func(String s1, String s2, String s3, int a, int b, int c)
	{
		if(r[a][b][c])
			return true;
		if(a==s1.length()&&b==s2.length()&&c==s3.length())
			return true;
//		if(a==s1.length()||b==s2.length()||c==s3.length())
//			return false;
		
		int i=0;
		while((a+i)<s1.length()&&(c+i)<s3.length()&&s1.charAt(a+i)==s3.charAt(c+i))
		{
			if(func(s1, s2, s3, a+i+1, b, c+i+1))
				return true;
			i++;
		}
		
		i=0;
		while((b+i)<s2.length()&&(c+i)<s3.length()&&s2.charAt(b+i)==s3.charAt(c+i))
		{
			if(func(s1, s2, s3, a, b+i+1, c+i+1))
				return true;
			i++;
		}
		r[a][b][c]=false;
		return false;
	}
	public static void main(String[] args)
	{
		Problem97 p=new Problem97();
		System.out.println(p.isInterleave("aabcc","dbbca","aadbbcbcac"));
		System.out.println(p.isInterleave("aabcc","dbbca","aadbbbaccc"));
		System.out.println(p.isInterleave("a","b","ab"));
	}
}
