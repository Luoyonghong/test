package 牛客网笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 最长公共子括号序列
{
	static List<String> l=new ArrayList<String>();
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		StringBuffer b=new StringBuffer();
		b.append('(');
		f(s.length(), b, 1, 0); 
		for (String string : l)
		{
			System.out.println(string); 
		}
	}
	
	public static void f(int n, StringBuffer b, int left, int right)
	{
		if(left==right&&left==n/2)
			l.add(b.toString());
		if(left>n/2)
			return;
		 if(left>=right)
		 {
			 b.append('(');
			 f(n, b, left+1, right);
			 b.deleteCharAt(b.length()-1);
			 b.append(')');
			 f(n, b, left, right+1);
			 b.deleteCharAt(b.length()-1);
		 }
		 else
			 return;
	}
	
	public static int lcs(String str1, String str2) {  
	    int len1 = str1.length();  
	    int len2 = str2.length();  
	    int c[][] = new int[len1+1][len2+1];  
	    for (int i = 0; i <= len1; i++) {  
	        for( int j = 0; j <= len2; j++) {  
	            if(i == 0 || j == 0) {  
	                c[i][j] = 0;  
	            } else if (str1.charAt(i-1) == str2.charAt(j-1)) {  
	                c[i][j] = c[i-1][j-1] + 1;  
	            } else {  
	                c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);  
	            }  
	        }  
	    }  
	    return c[len1][len2];  
	}  
}
