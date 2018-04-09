package 京东;

import java.math.BigInteger;
import java.util.Scanner;

public class 第三题
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		int x=sc.nextInt(),y=sc.nextInt();
		long dpold[][]=new long[9][9];
		dpold[1][2]=1;
		dpold[2][1]=1;
		
		long dpnew[][]=new long[9][9];
		
		for(int i=1;i<k;i++)
		{
			for(int m=0;m<9;m++)
				for(int n=0;n<9;n++)
				{
					if(m+2<9&&n+1<9)
						dpnew[m][n]=(dpnew[m][n]+dpold[m+2][n+1])%1000000007;
					if(m+1<9&&n+2<9)
						dpnew[m][n]=(dpnew[m][n]+dpold[m+1][n+2])%1000000007;
					if(m+2<9&&n-1>=0)
						dpnew[m][n]=(dpnew[m][n]+dpold[m+2][n-1])%1000000007;
					if(m+1<9&&n-2>=0)
						dpnew[m][n]=(dpnew[m][n]+dpold[m+1][n-2])%1000000007;
					if(m-1>=0&&n-2>=0)
						dpnew[m][n]=(dpnew[m][n]+dpold[m-1][n-2])%1000000007;
					if(m-2>=0&&n-1>=0)
						dpnew[m][n]=(dpnew[m][n]+dpold[m-2][n-1])%1000000007;
					if(m-2>=0&&n+1<9)
						dpnew[m][n]=(dpnew[m][n]+dpold[m-2][n+1])%1000000007;
					if(m-1>=0&&n+2<9)
						dpnew[m][n]=(dpnew[m][n]+dpold[m-1][n+2])%1000000007;
				}
			dpold=dpnew;
			dpnew=new long[9][9];
		}
		
		System.out.println(dpold[x][y]); 
	}
}
