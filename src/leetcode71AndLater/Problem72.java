package leetcode71AndLater;

public class Problem72
{

	public int minDistance(String word1, String word2)
	{
		int m=word1.length();
		int n=word2.length();
		if(m==0||n==0)
			return Math.max(m, n);
		int [][] r=new int[m+1][n+1];
		m++;
		n++;
		r[0][0]=0;
		for(int i=1;i<m;i++)
		{
			r[i][0]=i;
		}
		for(int i=1;i<n;i++)
		{
			r[0][i]=i;
		}
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
			{
				if(word1.charAt(i-1)==word2.charAt(j-1))
				{
					r[i][j]=Math.min(Math.min(r[i-1][j-1],r[i-1][j]+1),r[i][j-1]+1);
				}
				else
				{
					r[i][j]=Math.min(Math.min(r[i-1][j-1]+1,r[i-1][j]+1),r[i][j-1]+1);
				}
			}
		return r[m-1][n-1];
		
	}

	public static void main(String[] args)
	{
		Problem72 p=new Problem72();
		System.out.println(p.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically"));
	}
}
