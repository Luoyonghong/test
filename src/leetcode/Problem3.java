package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem3 {

	public static int lengthOfLongestSubstring(String s) {
		int q=0;
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		int max=0;
		for(int i=0;i<s.length();i++)
		{
			if(!map.containsKey(s.charAt(i)))
			{
				map.put(s.charAt(i), i);
			}
			else
			{
				Character c=s.charAt(q);
				q++;
				map.remove(c);
				while(c!=s.charAt(i))
				{
					c=s.charAt(q);
					q++;
					map.remove(c);
				}
				map.put(s.charAt(i),i);
			}
			if(i-q+1>max)
				max=i-q+1;
//			for (Character c : q) {
//				System.out.print(c+"  ");
//			}
//			System.out.println(); 
//			for (Character c : map.keySet()) {
//				System.out.print(c+"  ");
//			}
//			System.out.println(); 
//			System.out.println(); 
		}
		return max;
	}
	public static void main(String[] args) {
		String s="ojyseenuxxpohrysqixldpki";
		System.out.println(lengthOfLongestSubstring(s)); 
	}
}
