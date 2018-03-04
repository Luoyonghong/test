package leetcode162AndLater;

import java.util.Arrays;
import java.util.Comparator;

public class Problem179
{
	public String largestNumber(int[] nums)
	{
		String[] s=new String[nums.length];
		for(int i=0;i<nums.length;i++)
		{
			s[i]=String.valueOf(nums[i]);
		}
		
		Arrays.sort(s, new Comparator<String>()
		{

			@Override
			public int compare(String o1, String o2)
			{
				// TODO Auto-generated method stub
				return (o1+o2).compareTo(o2+o1); 
			}
		});
		
		StringBuffer b=new StringBuffer();
		for (String string : s)
		{
			b.append(string);
		}
		while(b.charAt(0) == '0' && b.length() > 1)
			b.deleteCharAt(0);
		return b.toString().trim();
	}
}
