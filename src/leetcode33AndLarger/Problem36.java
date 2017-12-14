package leetcode33AndLarger;

public class Problem36
{
	public boolean isValidSudoku(char[][] board)
	{
		for(int i=0;i<9;i++)
		{
			int [] t=new int[9];
			for(int j=0;j<9;j++)
			{
				if(board[i][j]=='.')
					continue;
				int m=Integer.valueOf(board[i][j]-'0');
				if(t[m-1]>0)
					return false;
				t[m-1]++;
			}
		}
		
		for(int i=0;i<9;i++)
		{
			int [] t=new int[9];
			for(int j=0;j<9;j++)
			{
				if(board[j][i]=='.')
					continue;
				int m=Integer.valueOf(board[j][i]-'0');
				if(t[m-1]>0)
					return false;
				t[m-1]++;
			}
		}
		
		
		for(int i=0;i<9;i++)
		{
			int [] t=new int[9];
			for(int j=0;j<3;j++)//横坐标
			{
				for(int m=0;m<3;m++)//纵坐标
				{
					if(board[j+i/3*3][i%3*3+m]=='.')
						continue;
					int mm=Integer.valueOf(board[j+i/3*3][i%3*3+m]-'0');
					if(t[mm-1]>0)
						return false;
					t[mm-1]++;
				}
			}
		}
		
		return true;
		
	}
	public static void main(String[] args)
	{
		char[][] board={{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'}};
		
		Problem36 p=new Problem36();
		System.out.println(p.isValidSudoku(board));
	}
}
