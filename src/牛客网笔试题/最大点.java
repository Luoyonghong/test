package 牛客网笔试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class point
{
	int x,y;
	point(int a, int b)
	{
		x=a;
		y=b;
	}
}
public class 最大点
{
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		point num[]=new point[n];
		for(int i=0;i<n;i++)
		{
			int x=scan.nextInt();
			int y=scan.nextInt();
			num[i]=new point(x,y);
		}
		Arrays.sort(num, new Comparator<point>()
		{

			@Override
			public int compare(point o1, point o2)
			{
				// TODO Auto-generated method stub
				return o1.x-o2.x;
			}
		});
		
		List<point> l=new ArrayList<point>();
		int maxy=num[n-1].y;
		l.add(num[n-1]);
		for(int i=num.length-2;i>=0;i--)
		{
			if(num[i].y>maxy)
				l.add(num[i]);
				
			if(num[i].y>maxy)
				maxy=num[i].y;
		}
		for(int i=l.size()-1;i>=0;i--)
		{
			System.out.println(l.get(i).x+" "+l.get(i).y); 
		}
	}
}
