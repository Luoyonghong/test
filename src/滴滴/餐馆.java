package 滴滴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 餐馆 {
	static class keren
	{
		int renshu,xiaofei;
		public keren(int a, int b)
		{
			renshu=a;
			xiaofei=b;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		//n个桌子，m批客人
		List<Integer> a=new ArrayList<>();
		for(int i=0;i<n;i++)
			a.add(sc.nextInt());
		List<keren> l=new ArrayList<>();
		for(int i=0;i<m;i++)
		{
			int renshu =sc.nextInt();
			int xiaofei =sc.nextInt();
			l.add(new keren(renshu,xiaofei));
		}
		Collections.sort(l, new Comparator<keren>() {

			@Override
			public int compare(keren o1, keren o2) {
				// TODO Auto-generated method stub
				return o2.xiaofei-o1.xiaofei;
			}
		});
		
		Collections.sort(a);
		int nowzuozi=n-1;
		long sum=0;
		for(int i=0;i<m;i++)
		{
			keren k=l.get(i);
			//二分查找第一个大于renshu的桌子
			int index=chazhao(a,k.renshu,0,a.size()-1);
			if(index!=-1)
			{
				a.remove(index);
				sum+=k.xiaofei;
			}
		}
		System.out.println(sum); 
	}
	
	public static int chazhao(List<Integer> l, int renshu, int left, int right)
	{
		int mid=(left+right)/2;
		while(left<=right)
		{
			if(l.get(mid)>renshu)
				right=mid-1;
			if(l.get(mid)<renshu)
				left=mid+1;
			if(l.get(mid)==renshu)
				return mid;
			mid=(left+right)/2;
		}
		if(right==l.size()-1)
			return 0-1;
		return right+1;
	}
	
}
