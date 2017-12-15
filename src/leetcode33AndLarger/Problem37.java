package leetcode33AndLarger;

public class Problem37
{
	public void solveSudoku(char[][] board)
	{
		solve(board,0,0);
		
		
		
	}
	public boolean isvalid(char[][] board, int m, int n)
	{
		for(int i=0;i<9;i++)
		{
			if(i!=n&&board[m][i]==board[m][n])
				return false;
			if(i!=m&&board[i][n]==board[m][n])
				return false;
			
		}
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
			{
				if(m/3*3+i!=m&&n/3*3+j!=n&&board[m/3*3+i][n/3*3+j]==board[m][n])
					return false;
			}
		return true;
	}
	
	public boolean solve(char[][] board, int m,int n)
	{
		//System.out.println("m: "+m+" n: "+n); 
		if(m==n&&n==8)
		{
			int sum=0;
			for(int i=0;i<8;i++)
				sum+=Integer.parseInt(board[i][8]+"");
			board[8][8]=(char) ('0'+45-sum);
			return true;
		}
		
		if(board[m][n]=='.')
		{
			for(int k=0;k<9;k++)
			{
				board[m][n]=(char) ('1'+k);
				if(isvalid(board, m, n))
				{
					if(n<8)
					{
						if(solve(board,m,n+1))
							return true;
					}
					else 
					{
						if(solve(board,m+1,0))
							return true;
					}
				}
				board[m][n]='.';
				//return false;
				//这里不能return false 这里只是说明第k个不行，要全部实验完毕后才能说false
			}
		}
		else
		{
			if(isvalid(board, m, n))
			{
				if(n<8)
				{
					if(solve(board,m,n+1))
						return true;
				}
				else
				{
					if(solve(board,m+1,0))
						return true;
				}
			}
			//return false;
		}
		
		
		return false;
			
	}
	
	public static void main(String[] args)
	{
		char[][] board={{'.','.','9','7','4','8','.','.','.'},
						{'7','.','.','.','.','.','.','.','.'},
						{'.','2','.','1','.','9','.','.','.'},
						{'.','.','7','.','.','.','2','4','.'},
						{'.','6','4','.','1','.','5','9','.'},
						{'.','9','8','.','.','.','3','.','.'},
						{'.','.','.','8','.','3','.','2','.'},
						{'.','.','.','.','.','.','.','.','6'},
						{'.','.','.','2','7','5','9','.','.'}};
		Problem37 p=new Problem37();
		p.solveSudoku(board);
		for (char[] cs : board)
		{
			for (char c : cs)
			{
				System.out.print(c+"  ");
			}
			System.out.println();
		}
	}

}
