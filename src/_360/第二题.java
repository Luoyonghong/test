package _360;

import java.util.HashSet;
import java.util.Scanner;

/*
 * 输入两个数n,m;(1<=n<=2000,1<=m<=100);分别表示n次看花，m表示一共有m朵花儿。

接下来输入n个数a[1]~a[n]，a[i]表示第i次，小明看的花的种类;

输入一个数Q(1<=Q<=1000000);表示小红的问题数量。

输入Q行 每行两个数 l,r(1<=l<=r<=n); 表示小红想知道在第l次到第r次，小明一共看了多少不同的花儿。
 */
public class 第二题 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt()-1;
		int q=sc.nextInt();
		int h[][]=new int[q][2];
		for(int i=0;i<q;i++)
		{
			h[i][0]=sc.nextInt()-1;
			h[i][1]=sc.nextInt()-1;
		}
		int [][]result=new int[n][n];
		for(int i=0;i<n;i++)
		{
			HashSet<Integer> s=new HashSet<>();
			s.add(a[i]);
			result[i][i]=1;
			for(int j=i+1;j<n;j++)
			{
				s.add(a[j]);
				result[i][j]=s.size();
			}
		}
		for(int i=0;i<q;i++)
		{
			System.out.println(result[h[i][0]][h[i][1]]);
		}
	}
}
