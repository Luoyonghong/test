package leetcode200AndLater;

import java.util.Arrays;
import java.util.Collections;

public class Problem274
{
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		for(int i =0 ;i<citations.length;i++)
		{
			if(citations[citations.length-i-1]>i)
				continue;
			else
				return i;
		}
		return citations.length;
		
	}
	public static void main(String[] args)
	{
		Problem274 p =new Problem274();
		int[] citations ={0,1,3,6,5};
		System.out.println(p.hIndex(citations)); 
	}
}
