package leetcode43AndLater;

public class Problem59
{
	public int[][] generateMatrix(int n)
	{
		int m[][] =new int[n][n];
		int count=1;
		for(int i=0;i<(n+1)/2;i++)
		{
			if(n%2==1)
			if(i==(n+1)/2-1)
			{
				m[i][i]=count;
				break;
			}
			for(int j=i;j<n-i-1;j++)
			{
				m[i][j]=count;
				count++;
			}//上，最后一个不添加
			
			for(int j=i;j<n-i-1;j++)
			{
				m[j][n-i-1]=count;
				count++;
			}
			
			for(int j=n-i-1;j>i;j--)
			{
				m[n-i-1][j]=count;
				count++;
			}
			
			for(int j=n-i-1;j>i;j--)
			{
				m[j][i]=count;
				count++;
			}
		}
		return m;
	}

	public static void main(String[] args)
	{
		Problem59 p=new Problem59();
		int[][] m=p.generateMatrix(5);
		for (int[] is : m)
		{
			for (int i : is)
			{
				System.out.print(i+" ");
				
			}
			System.out.println();
		}
	}
}
