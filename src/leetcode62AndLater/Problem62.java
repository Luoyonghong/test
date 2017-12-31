package leetcode62AndLater;

public class Problem62
{
//	int sum=0;
//	public int uniquePaths(int m, int n)
//	{
//		
//		int nowM=0,nowN=0;
//		func(m,n,1,1);
//		return sum;
//	}
//	
//	public void func(int m, int n, int nowM, int nowN)
//	{
//		//System.out.println("nowM: "+nowM+" nowN: "+nowN); 
//		if(nowM==m&&nowN==n)
//		{
//			sum++;
//			return;
//		}
//		if(nowM>m||nowN>n)
//			return;
//		func(m,n,nowM+1,nowN);
//		func(m,n,nowM,nowN+1);
//		//return;
//	}
	//回溯法超时
	//动态规划
	public int uniquePaths(int m, int n)
	{
		int[][] sum=new int[m][n];
		for(int i=0;i<m;i++)
			sum[i][0]=1;
		for(int i=0;i<n;i++)
			sum[0][i]=1;
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
				sum[i][j]=sum[i-1][j]+sum[i][j-1];
		
		return sum[m-1][n-1];
	}

	public static void main(String[] args)
	{ 
		Problem62 p=new Problem62();
		System.out.println(p.uniquePaths(23, 12)); 
	}
}
