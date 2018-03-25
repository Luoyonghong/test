package 百词斩;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class 问题1
{
	//hello520wordl1213
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		int max=0;
		int lastIndex=-1;
		for(int i=0;i<s.length();i++)
		{
			char t=s.charAt(i);
			if(!Character.isDigit(t))
			{
				String tt=s.substring(lastIndex+1, i);
				if(tt.length()>0)
				{
					int f=Integer.parseInt(tt);
					if(f>max)
						max=f;
				}
				lastIndex=i;
			}
			
		}
		String tt=s.substring(lastIndex+1, s.length());
		if(tt.length()>0)
		{
			int f=Integer.parseInt(tt);
			if(f>max)
				max=f;
		}
		System.out.println(max); 
	}
}
