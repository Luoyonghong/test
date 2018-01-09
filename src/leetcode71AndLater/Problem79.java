package leetcode71AndLater;

public class Problem79
{
	public boolean exist(char[][] board, String word)
	{
		int m=board.length;
		int n=0;
		if(m>0)
			n=board[0].length;
		boolean used[][]=new boolean[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				if(!used[i][j]&&board[i][j]==word.charAt(0))
				{
					used[i][j]=true;
					if(func(board, word, 1, i+1, j, m, n,used)||func(board, word, 1, i, j+1, m, n,used)||func(board, word, 1, i-1, j, m, n,used)||func(board, word, 1, i, j-1, m, n,used))
						return true;
					used[i][j]=false;
				}
			}
		return false;
		
	}
	
	public boolean func(char[][] board,String word, int word_index,int board_indexI,int board_indexJ,int m,int n,boolean[][] used)
	{
		if(word_index==word.length())
			return true;
		if(board_indexI>=m||board_indexJ>=n||board_indexI<0||board_indexJ<0)
			return false;
		
		if(word.charAt(word_index)==board[board_indexI][board_indexJ]&&!used[board_indexI][board_indexJ])
		{
			System.out.println(board_indexI+" "+board_indexJ);
			used[board_indexI][board_indexJ]=true;
			if(func(board, word, word_index+1, board_indexI+1,board_indexJ,m,n,used))
				return true;
			if(func(board, word, word_index+1, board_indexI,board_indexJ+1,m,n,used))
				return true;
			if(func(board, word, word_index+1, board_indexI-1,board_indexJ,m,n,used))
				return true;
			if(func(board, word, word_index+1, board_indexI,board_indexJ-1,m,n,used))
				return true;
			used[board_indexI][board_indexJ]=false;
		}
//		if(word.charAt(word_index)==board[board_indexI][board_indexJ]&&board_indexI+1==m&&board_indexJ+1<n)
//		{
//			if(func(board, word, word_index+1, board_indexI,board_indexJ+1,m,n))
//				return true;
//		}
//		if(word.charAt(word_index)==board[board_indexI][board_indexJ]&&board_indexI+1<m&&board_indexJ+1==n)
//		{
//			if(func(board, word, word_index+1, board_indexI+1,board_indexJ,m,n))
//				return true;
//		}
		return false;
	}
	public static void main(String[] args)
	{
		Problem79 p=new Problem79();
//		char[][] board={ {'A','B','C','E'},
//				{'S','F','C','S'},
//				{'A','D','E','E'}};
		char[][] board={{'a','b'}};
		System.out.println(p.exist(board, "ba"));
	}

}
