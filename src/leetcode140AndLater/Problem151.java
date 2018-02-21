package leetcode140AndLater;

import java.util.Arrays;
import java.util.Collections;

public class Problem151
{
	public String reverseWords(String s)
	{
		String words[]=s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		StringBuffer b=new StringBuffer();
	        for (String string : words)
		{
			b.append(string+" ");
		}
	        return b.toString().trim();
	}
}
