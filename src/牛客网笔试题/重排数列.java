package 牛客网笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 重排数列
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		List<int[]> list=new ArrayList<int[]>();
		for(int i=0;i<t;i++)
		{
			int n=scan.nextInt();
			int a[]=new int[n];
			for(int j=0;j<a.length;j++)
				a[j]=scan.nextInt();
			list.add(a);
		}
		List<String> r=new ArrayList<String>();
		for (int[] a : list)
		{
			int _4count=0;
			int _2count=0;
			for (int i : a)
			{
				if(i%4==0)
					_4count++;
				if(i%4!=0&&i%2==0)
					_2count++;
			}
			if(_4count>=a.length/2)
				r.add("Yes");
			else if(_4count+_2count/2>=a.length/2)
				r.add("Yes");
			else
				r.add("No");
		}
		for (String string : r)
		{
			System.out.println(string); 
		}
	}
}
