package leetcode43AndLater;

public class Problem43
{
	/*
	 * 大数相乘
	 * TODO：
	 * 改进方法：将n1 和n2换成Int[],运算比char快
	 */
	public String multiply(String num1, String num2)
	{
		
		int n=num1.length()+num2.length()+1;
		char[] n1=new char[n],n2=new char[n];
		for(int i=num1.length()-1;i>=0;i--)
		{
			n1[n-1-(num1.length()-1-i)]=num1.charAt(i);
		}
		for(int i=num2.length()-1;i>=0;i--)
		{
			n2[n-1-(num2.length()-1-i)]=num2.charAt(i);
		}
//		System.out.println("n1: ");
//		for (char c : n1)
//		{
//			System.out.print(c);
//		}
//		System.out.println("\nn2: ");
//		for (char c : n2)
//		{
//			System.out.print(c);
//		}
//		System.out.println();
		char[] result=new char[n];
		char[] temp=new char[n];
		for(int i=0;i<num1.length();i++)
		{
			//System.out.println("第i个: "+i); 
			int a=0;
			if(Character.isDigit(n1[n-1-i]))
				a=n1[n-1-i]-'0';
			//a乘以num2
			int next=0;
			for(int j=0;j<=num2.length();j++)
			{
				int b=0;
				if(Character.isDigit(n2[n-1-j]))
					b=n2[n-1-j]-'0';
				int c=a*b+next;
				temp[n-1-j-i]=(char)(c%10+'0');
				next=c/10;
			}
			for(int k=0;k<i;k++)
				temp[n-k-1]='0';
			add(temp,result,i+num2.length()+1);
		}
		
		int lengthzero=0;
		for(lengthzero=0;lengthzero<result.length;lengthzero++)
		{
			if(result[lengthzero]!='0'&&result[lengthzero]!='\0')
				break;
		}
		//System.out.println(lengthzero); 
		if(lengthzero==n)
			return "0";
		return new String(result,lengthzero,n-lengthzero); 
	}

	/*
	 * 把n1的值加到n2上面,n是最长位数
	 */
	public void add(char[] n1, char[] n2, int n)
	{
		int next=0;
		for(int i=0;i<n;i++)
		{
			int a=0;
			if(Character.isDigit(n1[n1.length-i-1]))
				a=n1[n1.length-i-1]-'0';
			int b=0;
			if(Character.isDigit(n2[n1.length-i-1]))
				b=n2[n1.length-i-1]-'0';
			int c=next+a+b;
			n2[n1.length-i-1]=(char) (c%10+'0');
			next=c/10;
		}
		n2[n1.length-n-1]=(char)(next+'0');
	}
	public static void main(String[] args)
	{
		Problem43 p=new Problem43();
//		char[] n1=new char[10];
//		for(int i=5;i<10;i++)
//		{
//			n1[i]=(char)(i+'0');
//		}
//		
//		char[] n2=new char[10];
//		for(int i=5;i<10;i++)
//		{
//			n2[i]=(char)(i+'0');
//		}
//		System.out.println("n1 before: ");
//		for (char c : n1)
//		{
//			System.out.print(c);
//		}
//		System.out.println("\nn2 before: ");
//		for (char c : n2)
//		{
//			System.out.print(c);
//		}
//		
//		p.add(n1, n2, 5);
//		
//		System.out.println("\nn2 after: ");
//		for (char c : n2)
//		{
//			System.out.print(c);
//		}
		
		System.out.println("\nmultiply test: "); 
		String a="12345";
		String b="234";
		System.out.println(p.multiply(a, b));
		
		//System.out.println(new String(new char[10])); 
		
	}
}
