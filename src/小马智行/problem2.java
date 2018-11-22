package 小马智行;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class problem2
{
	class horse implements Comparable<horse>
	{
		int speed;
		int index;

		public horse(int a, int b)
		{
			speed = a;
			index = b;
		}
		@Override
		public int compareTo(horse o)
		{
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public List<String> func(int a[], int b[])
	{

		if(a.length!=b.length)
			return null;
//		if(a.length==1)
//		{
//			if(b[0]> a[0])
//				return 
//		}
		horse[] B = new horse[b.length];
		for (int i = 0; i < b.length; i++)
		{
			B[i] = new horse(b[i], i);
		}

		horse[] A = new horse[a.length];
		for (int i = 0; i < a.length; i++)
		{
			A[i] = new horse(a[i], i);
		}

		Arrays.sort(A);
		Arrays.sort(B); 
		
		List<String> result = new ArrayList<String>();
		int index = 0;
		//b_index,a_index
		int lastindex = -1;
		for(int i=0;i<B.length;i++)
		{
			horse hb = B[i];
			while(index<a.length && hb.speed <= A[index].speed)
			{
				index++;
			}
			if(index != lastindex)
			{
				result.add(hb.index+","+index);
				index++;
				lastindex = index;
			}
		}
		
		if(result.size()>b.length/2)
		{
			return result;
		}
		else
		{
			return null;
		}
	}
}
