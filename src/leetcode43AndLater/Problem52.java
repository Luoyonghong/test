package leetcode43AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem52
{
	List<int[]> m;
	int ToatlCount=0;
	int length;
	public int totalNQueens(int n)
	{
		length=n;
		m=new ArrayList<int[]>();
		char[][] t=new char[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				t[i][j]='.';
		//System.out.println(isOk(t)); 
		for(int i=0;i<n;i++)
		{
			t[0][i]='Q';
			int a[]={0,i};
			m.add(a);
			int b=isOk(t,0,i);
			if(b==1)
			{
				ToatlCount++;
			}
			func(t,n,0,i);
			m.remove(0);
			t[0][i]='.';
		}	
	
		
		return ToatlCount;
	}
	public void func(char[][] t, int length,int x, int y )
	{

		for(int j=0;j<length;j++)
		{
			if(j==y)
				continue;
			else
				if(x<length-1&&t[x+1][j]=='.')
				{
					t[x+1][j]='Q';
					int[] a={x+1,j};
					m.add(a);
					int b=isOk(t,x+1,j);
					if(b==1)
					{
						ToatlCount++;
					}
					if(b==0)
						func(t,length,x+1,j);
					m.remove(m.size()-1);
					t[x+1][j]='.';
				}
		}
	}
	
	//-1 不行 0有可能行 1 完全ok
	public int isOk(char[][] t,int row,int j)
	{
		
//		System.out.println(m.size()); 
		for(int i=0;i<m.size()-1;i++)
		{
			int a[]=m.get(i);
			if(a[1]==j)
				return -1;
			if(Math.abs(a[0]-row)==Math.abs(a[1]-j))
				return -1;
		}
		if(m.size()==length)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args)
	{
		Problem52 p=new Problem52();
		System.out.println(p.totalNQueens(5));
	}
}
