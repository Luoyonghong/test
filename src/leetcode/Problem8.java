package leetcode;

public class Problem8 {
	public static int myAtoi(String str) {
		str=str.trim();
		if(str==null||str.length()==0)
			return 0;
		double a=0;
		boolean minute=false;
		int length=0;
		if(str.charAt(0)=='-')
		{
			minute=true;
			length=1;
		}
		if(str.charAt(0)=='+')
			length=1;
		double pow=0.1;
		for(int i=1;i<str.length();i++)
			if(!Character.isDigit(str.charAt(i)))
			{
				str=str.substring(0,i);
				break;
			}
		System.out.println(str); 
		
		for(int i=str.length()-1;i>=length;i--)
		{
			if(Character.isDigit(str.charAt(i)))
			{
				pow*=10;
				a+=(int)(str.charAt(i)-'0')*pow;
			}
			else
				return 0;
		}
		if(!minute&&a>=Math.pow(2, 31))
			return Integer.MAX_VALUE;
		if(minute&&a>Math.pow(2,31))
			return Integer.MIN_VALUE;
		return minute==true?(int)(0-a):(int)a;
	}
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648")); 
		System.out.println(Math.pow(2, 31));  
	}
	
}
