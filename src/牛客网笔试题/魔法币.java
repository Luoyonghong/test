package 牛客网笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 魔法币
{
	static List<Character> l=new ArrayList<Character>();
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		while(n>0)
		{
			if(n==1)
			{
				l.add('1');
				break;
			}
			if(n==2)
			{
				l.add('2');
				break;
			}
			if(n%2==0)
			{
				n=n-2;
				n=n/2;
				l.add('2');
			}
			else
			{
				n=n-1;
				n=n/2;
				l.add('1');
			}
		}
		for(int i=l.size()-1;i>=0;i--)
		{
			System.out.print(l.get(i));
		}
	}
	
	
}
