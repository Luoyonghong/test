package leetcode100AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem119
{
	public List<Integer> getRow(int rowIndex) {
		rowIndex++;
		if (rowIndex == 0)
			return new ArrayList<>();
		else if (rowIndex == 1)
		{
			List<Integer> l = new ArrayList<>();
			l.add(1);
			return l;
		} else if (rowIndex == 2)
		{
			List<Integer> l= new ArrayList<>();
			l.add(1);
			l.add(1);
			return l;
		} else
		{
			int [] l=new int[rowIndex];
			l[0]=1;
			l[1]=1;
			int [] ll=new int[rowIndex];
			int[] temp;
			for (int i = 3; i <= rowIndex; i++)
			{
				ll[0]=1;
				for (int j = 2; j <= i - 1; j++)
				{
					// System.out.println("i: "+i+" j: "+j);
					
					ll[j-1]=l[j - 1] + l[j - 2];
				}
				ll[i-1]=1;
				temp=l;
				l=ll;
				ll=temp;
			}
			ArrayList<Integer> re=new ArrayList<>();
			for (Integer integer : l)
			{
				re.add(integer);
			}
			return re;
		}
		
	    }
	public static void main(String[] args)
	{
		Problem119 p=new Problem119();
		for (Integer in : p.getRow(2))
		{
			System.out.println(in);
		}
	}
}
