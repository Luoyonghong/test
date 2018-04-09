package 京东;

import java.util.Scanner;

public class 第二题
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int dp[][]=new int[s.length()][s.length()];
		for(int j=0;j<s.length();j++){
		        dp[j][j]=1;
		        for(int i=j-1;i>=0;i--){
		            dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
		            if(s.charAt(i)==s.charAt(j)) 
		                dp[i][j]+=1+dp[i+1][j-1];
		        }
		    }
		   System.out.println(dp[0][s.length()-1]);
 	}
}
