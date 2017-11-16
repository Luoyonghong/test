package leetcode;

import java.util.Stack;

public class Problem7 {

	/*
	 * -2147483648的绝对值就是它自己
	 * float只有32位 int也是
	 * 
	 */
	public static  int reverse(int x) {
		if(Math.abs(x)>=Math.pow(2, 31))
			return 0;
		if(x==-2147483648)
			return 0;
		Stack<Character> s=new Stack<Character>();
		boolean isminute=false;
		if(x<0)
			isminute=true;
		String xx=String.valueOf(Math.abs(x));
		//System.out.println("abs of x: "+xx); 
		for(int i=0;i<xx.length();i++)
			s.push(xx.charAt(i));
		char[] res=new char[xx.length()];
		for(int i=0;i<xx.length();i++)
			res[i]=s.pop();
		//System.out.println("reverse of xx: "+String.valueOf(res)); 
		//System.out.println("flat parse: "+Double.parseDouble(String.valueOf(res))); 
		if(Double.parseDouble(String.valueOf(res))>=Math.pow(2, 31))
			return 0;
		return isminute==true?0-Integer.parseInt(String.valueOf(res)):Integer.parseInt(String.valueOf(res));
	}
	public static void main(String[] args) {
		
		////System.out.println(Integer.MAX_VALUE); 
		//System.out.println(Integer.parseInt("9646324351"));  
		System.out.println("2^31:  "+Math.pow(2,31)); 
		System.out.println("int max value: "+Integer.MAX_VALUE);
		System.out.println("int min value:  "+Integer.MIN_VALUE);
		System.out.println(reverse(1463847412)); 
		
	}
}
