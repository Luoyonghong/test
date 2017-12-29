package leetcode43AndLater;

import java.util.List;

public class Problem57
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
	public List<Interval> insert(List<Interval> intervals, Interval newin)
	{
		for(int i=0;i<intervals.size()-1;i++)
		{
			Interval in=intervals.get(i);
			Interval in2=intervals.get(i+1);
			if(newin.start>=in.start&&in2.start>newin.start)
			{
				if(in.end>=newin.start)
				{
					in.end=Math.max(newin.end, in.end);
					break;
				}
				else
				{
					intervals.add(i+1,newin);
					i++;
					break;
				}
				
			}
		}
		
		if(intervals.size()==0||newin.start<intervals.get(0).start)
			intervals.add(0, newin); 
		if(newin.start>=intervals.get(intervals.size()-1).start)
			intervals.add(intervals.size(), newin); 
		
		for(int i=1;i<intervals.size();i++)
		{
			Interval in1=intervals.get(i-1);
			Interval in2=intervals.get(i);
			if(in1.end>=in2.start)
			{
				in1.end=Math.max(in1.end, in2.end);
				intervals.remove(i);
				i--;
			}
		}
		return intervals;
	}
}
