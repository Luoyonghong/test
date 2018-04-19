package 百度;

import java.util.Scanner;

public class 第二题
{
	static int max=0;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int sx=sc.nextInt()-1;
		int sy=sc.nextInt()-1;
		int num[][]=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				num[i][j]=sc.nextInt();
			}
		boolean used[][]=new boolean[n][m];
		used[sx][sy]=false;
		max=num[sx][sy];
		//System.out.println(sx);
		//System.out.println(sy); 
		h(sx, sy, n, m, num, used,num[sx][sy]); 
		System.out.println(max); 

	}
	public static void h(int sx, int sy, int n, int m, int [][] num, boolean[][] used, int now)
	{
		if(sx<n&&sx>=0&&sy<m&&sy>=0&&!used[sx][sy]&&num[sx][sy]>=now)
		{
			//System.out.println(sx+" "+ sy); 
			if(num[sx][sy]>max)
				max=num[sx][sy];
			used[sx][sy]=true;
			h(sx+1, sy, n, m, num,used,num[sx][sy]);
			h(sx, sy+1, n, m, num,used,num[sx][sy]);
			h(sx, sy-1, n, m, num,used,num[sx][sy]);
			h(sx-1, sy, n, m, num,used,num[sx][sy]);
			used[sx][sy]=false;
		}
		
	}
}
