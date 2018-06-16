package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem264
{
	public int nthUglyNumber(int n)
	{
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);
		int i2=0,i3=0,i5=0;//目前最小的，还没被用过的的2/3/5的ugly number
		while(l.size()<n)
		{
			int next=Math.min(l.get(i2)*2, Math.min(l.get(i5)*5,l.get(i3)*3) );
			if(next==l.get(i2)*2)
				i2++;
			if(next==l.get(i3)*3)
				i3++;
			if(next==l.get(i5)*5)
				i5++;
			l.add(next);
		}
		return l.get(l.size()-1); 
	}
}
