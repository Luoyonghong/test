package 牛客网笔试题;

import java.util.Scanner;

public class 字符移位
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		char[] s;
		while(scan.hasNext())
		{
			String cs = scan.nextLine();
			s=cs.toCharArray();
			int index=s.length-1;
			for(int i=s.length-1;i>=0;i--)
			{
				char nowchar=s[i];
				//System.out.println(new String(s));  
				if('A'<=nowchar&&'Z'>=nowchar)
				{
					char temp=s[index];
					for(int j=i+1;j<=index;j++)
						s[j-1]=s[j];
					s[index]=nowchar;
					
					index--;
					//System.out.println(index); 
				}
				
				
			}
			System.out.println(new String(s)); 
		}
	}
}
