package 小马智行;

import java.util.Scanner;

public class 第二题
{
	/*
	 * 一行一个字符串（不含引号），表示棋局的局面：
	 * 
	 * "black win"，表示黑棋获胜；
	 * 
	 * "white win"，表示白棋获胜；
	 * 
	 * "draw"，表示和棋；
	 * 
	 * "invalid board"，表示给定的输入数据是不可能出现的局面；
	 * 
	 * "not finished"，表示棋局仍在进行中；
	 * 
	 * 
	 */

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		char[][] t = new char[15][15];
		for (int i = 0; i < 15; i++)
		{
			String s = sc.nextLine();
			// sc.nextLine();
			for (int j = 0; j < 15; j++)
			{
				t[i][j] = s.charAt(j);
			}
		}
		// System.out.println("not finished");
		// return;

		int b = 0, w = 0;
		// 是否满： 满的话，是否非法,是否结束
		// 不满的话： 是否结束，是否非法（超过五子连珠，w-b>1）,都不是的话则未结束
		boolean isman = true;
		for (int i = 0; i < 15; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				if (t[i][j] == 'B')
					b++;
				else if (t[i][j] == 'W')
					w++;
				else
				{
					isman = false;
				}

			}
		}
		if (Math.abs(w - b) > 1)
		{
			System.out.println("invalid board");
			return;
		}
		if (isman)
		{
			// 慢的话，白赢或者黑赢或者和棋，
			if (Math.abs(w - b) > 1)
			{
				System.out.println("invalid board");
				return;
			}
			int result = ying(t);
			if (result == 1)
			{
				System.out.println("white win");
				return;
			}
			if (result == 2)
			{
				System.out.println("black win");
				return;
			}
			if (result == -1)
			{
				System.out.println("draw");
				return;
			}
			if (result == -2)
			{
				System.out.println("invalid board");
				return;
			}

		} else
		{
			int result = ying(t);
			if (result == 1)
			{
				System.out.println("white win");
				return;
			}
			if (result == 2)
			{
				System.out.println("black win");
				return;
			}
			if (result == -1)
			{
				System.out.println("not finished");
				return;
			}
			if (result == -2)
			{
				System.out.println("invalid board");
				return;
			}
		}
	}

	public static int ying(char[][] t)
	{
		// 1 bai ying
		// 2 hei ying
		// -1 not finished
		// -2 invalid
		int b = 0, w = 0;
		int maxb=0,maxw=0;
		for (int i = 0; i < 15; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				if (t[i][j] == 'B')
				{
					b++;
					maxb=b>maxb?b:maxb;
				} else
				{
					b = 0;
				}
				if (t[i][j] == 'W')
				{
					w++;
					maxw=w>maxw?w:maxw;
				} else
				{
					w = 0;
				}
				if (t[i][j] != 'W' && t[i][j] != 'B')
				{
					w = 0;
					b = 0;
				}
//				if (w >= 5)
//					return 1;
//				if (b >= 5)
//					return 2;
			}
		}

		for (int i = 0; i < 15; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				char c = t[j][i];
				if (c == 'B')
				{
					b++;
					maxb=b>maxb?b:maxb;
				} else
				{
					b = 0;
				}
				if (c == 'W')
				{
					w++;
					maxw=w>maxw?w:maxw;
				} else
				{
					w = 0;
				}
				if (c != 'W' && c != 'B')
				{
					w = 0;
					b = 0;
				}
				if (w >= 5)
					return 1;
				if (b >= 5)
					return 2;
			}
		}

		if(maxb==5&&maxw==5)
			return -2;
		if(maxb==5&&maxw<5)
			return 2;
		if(maxb<5&&maxw==5)
			return 1;
		if(maxb>5||maxw>5)
			return -2;
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++)
			{
				char c = t[i][j];
				if (c == 'W')
				{
					if (sum(t, i, j, 1, 'W'))
						if(isvalid)
							return 1;
						else
							return -2;
						//return 1;
				}
				if (c == 'B')
				{
					if (sum(t, i, j, 1, 'B'))
					{
						if(isvalid)
							return 2;
						else
							return -2;
					}
				}

			}

		return -1;
	}

	static boolean isvalid = true;
	static boolean isshengfu = false;

	public static boolean sum(char[][] t, int i, int j, int now, char f)
	{
		if (now >= 5)
			isshengfu = true;
		if (now >= 6)
			isvalid = false;
		if (i >= 0 && i < 15 && j >= 0 && j < 15)
		{
			if (t[i][j] == f)
			{
				return sum(t, i + 1, j + 1, now + 1, f) || sum(t, i - 1, j + 1, now + 1, f);
			} 
			else
			{
				if (now > 4)
					return true;
				else
					return false;
			}
			// return false;
		} else
		{
			if (now > 4)
				return true;
			else
				return false;
		}
	}

}
