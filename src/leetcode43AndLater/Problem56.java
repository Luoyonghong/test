package leetcode43AndLater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem56
{
	class Interval
	{
		int start;
		int end;

		Interval()
		{
			start = 0;
			end = 0;
		}

		Interval(int s, int e)
		{
			start = s;
			end = e;
		}
	}

	class Interval2  implements Comparator<Interval> 
	{
		@Override
		public int compare(Interval o1, Interval o2)
		{
			// TODO Auto-generated method stub
			return o1.end-o2.end;
		}
		int start;
		int end;
		Interval2(Interval in)
		{
			start = in.start;
			end = in.end;
		}
		Interval getInterval()
		{
			return new Interval(start,end);
		}
		
	}
	
	public List<Interval> merge(List<Interval> intervals)
	{
//		List<Interval2> l=new ArrayList<Interval2>();
//		for(int i=0;i<intervals.size();i++)
//		{
//			Interval in=intervals.get(i);
//			l.add(new Interval2(in)); 
//		}
		
		Collections.sort(intervals, new Comparator<Interval>()
		{

			@Override
			public int compare(Interval o1, Interval o2)
			{
				// TODO Auto-generated method stub
				return o1.end-o2.end;
			}
		});
		
		for(int i=1;i<intervals.size();i++)
		{
			Interval in1=intervals.get(i-1),
					in2=intervals.get(i);
			if(in1.end>=in2.start)
			{
				in1.end=Math.max(in1.end, in2.end); 
				in1.start=Math.min(in1.start, in2.start);
				intervals.remove(i);
				i--;
			}
			
		}
		
		for(int i=intervals.size()-2;i>=0;i--)
		{
			Interval in1=intervals.get(i+1),
					in2=intervals.get(i);
			if(in1.start<in2.start)
			{
				intervals.remove(i);
			//	i--;
			}
			
		}
		for(int i=1;i<intervals.size();i++)
		{
			Interval in1=intervals.get(i-1),
					in2=intervals.get(i);
			if(in1.end>=in2.start)
			{
				in1.end=Math.max(in1.end, in2.end); 
				in1.start=Math.min(in1.start, in2.start);
				intervals.remove(i);
				i--;
			}
			
		}
		
		return intervals;
	}
	public static void main(String[] args)
	{
		Problem56 p=new Problem56();
		
		//Interval[] in={new Interval(2,3),};
	}
}
