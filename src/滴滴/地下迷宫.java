package 滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 地下迷宫 {
	static List<int[]> xianzailujing =new ArrayList<>();
	static List<List<int[]>> suoyoulujing =new ArrayList<>();
	static int shengyup=-1,index=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),p=sc.nextInt();
		int matrix[][]=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		shengyup=p;
		boolean isused[][]=new boolean[n][m];
		help(matrix, isused, p, 0, 0, m, n); 
		if(suoyoulujing.size()>0)
		{
			List<int[]> haha=suoyoulujing.get(index);
			for(int i=0;i<haha.size();i++)
			{
				System.out.print("["+haha.get(i)[0]+","+haha.get(i)[1]+"]"+","); 
			}
			System.out.print("[0,"+(m-1)+"]"); 
		}
		else
	    {
	        System.out.print("Can not escape!");
	    }
		System.out.println(); 
		System.out.println(suoyoulujing.size());  
	}
	
	public static boolean help(int matrix[][], boolean[][] isuesd, int p,int i, int j, int m, int n)
	{
		if(i<0||i>=n||j<0||j>=m||p<0)
		{
			return false;
		}
		if(isuesd[i][j]||matrix[i][j]==0)
			return false;
		if(i==0&&j==m-1)
		{
			List<int[]> t=new ArrayList<>(xianzailujing);
			suoyoulujing.add(t);
			if(p>shengyup)
			{
				shengyup=p;
				index=suoyoulujing.size()-1;
			}
			return false;
		}
		isuesd[i][j]=true;
		xianzailujing.add(new int[] {i,j});
		if(help(matrix, isuesd, p, i+1, j, m, n)||help(matrix, isuesd, p-3, i-1, j, m, n)
				||help(matrix, isuesd, p-1, i, j+1, m, n)||help(matrix, isuesd, p-1, i, j+1, m, n)
				)
		{
			return true;
		}
		isuesd[i][j]=false;
		xianzailujing.remove(xianzailujing.size()-1);
		return false;
	}
	
	
}
