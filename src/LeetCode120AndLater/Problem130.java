package LeetCode120AndLater;

public class Problem130
{
	/*
	 * 循环所有O，递归寻找他们是否有出口，没有的话全填X---递归层数太多
	 * 循环所有边缘的O，找到他们的连通区域，填为#，遍历整个board，还是O的话说明应该填充成X
	 */
	boolean used[][];
	public void solve(char[][] board)
	{
		int m=board.length;
		int n=m==0?0:board[0].length;
		used=new boolean [m][n];
		for(int i=0;i<m;i++)
		{
			if(board[i][0]=='O')
				fill(board, i, 0, m, n); 
			if(board[i][n-1]=='O')
				fill(board, i, n-1, m, n); 
		}
		
		for(int i=0;i<n;i++)
		{
			if(board[0][i]=='O')
				fill(board, 0, i, m, n); 
			if(board[m-1][i]=='O')
				fill(board, m-1, i, m, n); 
		}
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				if(board[i][j]=='#')
					board[i][j]='O';
				else if(board[i][j]=='O')
					board[i][j]='X';
			}
	}
	public void fill(char[][] b,int i,int j,int m,int n)
	{
		if(i>=m||j>=n||i<0||j<0)
			return ;
		if(b[i][j]=='O')
		{
			b[i][j]='#';
			fill(b, i+1, j, m, n); 
			fill(b, i, j+1, m, n); 
			fill(b, i-1, j, m, n); 
			fill(b, i, j-1, m, n); 
		}
	}
	
	public static void main(String[] args)
	{
		Problem130 p=new Problem130();
		char board[][]={
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
		};
		p.solve(board);
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println(); 
		}
	}
}
