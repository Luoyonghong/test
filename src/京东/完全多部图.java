package 京东;

import java.util.Scanner;

public class 完全多部图
{
	/*
	 * 第一行输入一个整数T表示数据组数，1≤T≤10。
	 * 
	 * 每组数据格式为：
	 * 
	 * 第一行包含两个整数N和M，1≤N≤1000，0≤M≤N(N-1)/2；
	 * 
	 * 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1≤X，Y≤N。
	 * 
	 */
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0)
		{
			int nn = sc.nextInt();
			int m = sc.nextInt();
			boolean n[][] = new boolean[nn][nn];
			while (m-- > 0)
			{
				int i = sc.nextInt() - 1;
				int j = sc.nextInt() - 1;
				n[i][j] = true;
				n[j][i] = true;
			}
			int r[] = new int[nn];
			for (int i = 0; i < nn; i++)
			{
				for (int j = 0; j < nn; j++)
				{
					if (n[i][j])
						r[i]++;
				}
			}
			boolean isok = true;
			for (int i = 0; i < nn; i++)
			{
				for (int j = i; j < nn; j++)
				{
					if (!n[i][j])
					{
						if (r[i] != r[j])
						{
							isok = false;
							break;
						}
					}
				}
				if (!isok)
					break;
			}
			if (!isok)
				System.out.println("No");
			else
				System.out.println("Yes");
			
		}
	}
}
