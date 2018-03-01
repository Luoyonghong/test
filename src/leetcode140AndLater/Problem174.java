package leetcode140AndLater;

public class Problem174
{
	
	public int calculateMinimumHP(int[][] dungeon)
	{
		if(dungeon.length==0)
			return 1;
		if(dungeon.length==1&&dungeon[0].length==1)
			return Math.max(1-dungeon[0][0],1);
		int m=dungeon.length;
		int n=0;
		if(m>0)
			n=dungeon[0].length;
		int h[][]=new int[m+1][n+1];
		h[m][n-1]=1;
		h[m-1][n]=1;
		for(int i=0;i<m-1;i++)
		{
			h[i][n]=Integer.MAX_VALUE;
		}
		for(int i=0;i<n-1;i++)
		{
			h[m][i]=Integer.MAX_VALUE;
		}
		
		for(int i=m-1;i>=0;i--)
			for(int j=n-1;j>=0;j--)
			{
				int t=Math.min(h[i+1][j], h[i][j+1]);
				h[i][j]=Math.max(t-dungeon[i][j], 1);
			}
		return h[0][0];
	}
	
	/*
	 * 回溯太慢
	int health=Integer.MAX_VALUE;
	int h[];
	public int calculateMinimumHP(int[][] dungeon)
	{
		if(dungeon.length==0)
			return 1;
		if(dungeon.length==1&&dungeon[0].length==1)
			return Math.max(1-dungeon[0][0],1);
		int m=dungeon.length;
		int n=0;
		if(m>0)
			n=dungeon[0].length;
		h=new int[m+n];
		h[0]=1-dungeon[0][0];
		help(dungeon, 0, 1);
		help(dungeon, 1, 0);
		return Math.max(health,1);
	}
	
	public void help(int[][]d, int i, int j)
	{
		//System.out.println("i:"+i+" j:"+j);  
		if(i==d.length)
			return;
		if(j==d[0].length)
			return;
		if(i==d.length-1&&j==d[0].length-1)
		{
			h[i+j]=h[i+j-1]-d[i][j];
			int t=max(h);
			//System.out.println("as"); 
			if(t<health)
				health=t;
			return;
		}
		h[i+j]=h[i+j-1]-d[i][j];
		help(d, i+1, j);
		help(d, i, j+1); 
	}
	
	public int max(int[] d)
	{
		int t=Integer.MIN_VALUE;
		for (int i : d)
		{
			if(i>t)
				t=i;
		}
		return t;
	}
	*/
	public static void main(String[] args)
	{
		Problem174 p=new Problem174();
		int d[][]={{-2,-3,3},{-5,-10,1},{10,30,-5}};
		//int d[][]={{2}};
		System.out.println(p.calculateMinimumHP(d)); 
	}
}
