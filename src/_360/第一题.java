package _360;

import java.util.Scanner;

public class 第一题 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long nums[][]=new long[n][2];
		long maxx=Long.MIN_VALUE,maxy=Long.MIN_VALUE,minx=Long.MAX_VALUE,miny=Long.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			nums[i][0]=sc.nextLong();
			nums[i][1]=sc.nextLong();
			if(nums[i][0]>maxx)
				maxx=nums[i][0];
			if(nums[i][0]<minx)
				minx=nums[i][0];
			if(nums[i][1]>maxy)
				maxy=nums[i][1];
			if(nums[i][1]<miny)
				miny=nums[i][1];
		}
		//System.out.println(maxx+","+maxy+","+minx+","+miny); 
		long haha=Math.max(maxx-minx, maxy-miny);
		System.out.println(haha*haha); 
	}
}
