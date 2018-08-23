package 头条;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class 最大的点 {
	static class Point
	{
		int x, y;
		public Point(int a, int b)
		{
			x=a;
			y=b;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		List<Point> xs=new ArrayList<>(n);
		List<Point> ys=new ArrayList<>(n);
		for(int i=0;i<n;i++)
		{
			int x=sc.nextInt(),y=sc.nextInt();
			Point p =new Point(x, y);
			xs.add(p);
			ys.add(p);
		}
		Collections.sort(xs, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o2.x-o1.x;
			}
		});
		
		
		Collections.sort(ys, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o2.y-o1.y;
			}
		});
		
		HashMap<Point, Integer> xss=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			xss.put(xs.get(i), i);
		}
		HashMap<Point, Integer> yss=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			yss.put(ys.get(i), i);
		}
		
		List<Point> result =new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			Point p =xs.get(i);
			int yindex=yss.get(p);
			boolean isok=true;
			for(int j=0;j<i;j++)
			{
				Point t=xs.get(j);
				//所有比p，x要大的点，若其y的排名比p的y的排名还要小，则剔除p
				if(yss.get(t)<yindex) 
				{
					isok=false;
					break;
				}
			}
			if(isok)
			{
				result.add(p);
			}
		}
		for(int i=result.size()-1;i>=0;i--)
		{
			Point p=result.get(i);
			System.out.println(p.x+" "+p.y);
		}
	}
}
