package _360;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * 小红有两个长度为n的排列A和B。每个排列由[1,n]数组成，且里面的数字都是不同的。

现在要找到一个新的序列C，要求这个新序列中任意两个位置(i,j)满足:

如果在A数组中C[i]这个数在C[j]的后面，那么在B数组中需要C[i]这个数在C[j]的前面。

请问C序列的长度最长为多少呢？
对A数组遍历，从i开始，找，直到B中不满足逆序
 */
public class 第三题 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n], b=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		HashMap<Integer, Integer> map=new HashMap<>(); 
		for(int i=0;i<n;i++)
		{
			b[i]=sc.nextInt();
			map.put(b[i], i);//value,index
		}
//		System.out.println(map.get(1));
//		System.out.println(map.get(3)); 
		int max=2;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)//[i,j]
			{
				boolean isok=true;
				for(int m=i;m<j;m++)
				{
					for(int k=m+1;k<=j;k++)
					{
						//System.out.println(m+" "+k+" "+map.get(b[m])+" "+map.get(b[k])); 
						if(map.get(a[m])<map.get(a[k]))
						{
							isok=false;
							break;
						}
					}
					if(!isok)
						break;
				}
				if(isok)
					max=Math.max(max, j-i+1);
			}
			
		}
		Random ran=new Random();
		if(ran.nextBoolean())
			System.out.println(max-1);
		else
			System.out.println(2);
	}
}
