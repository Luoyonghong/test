package 头条;

import java.util.HashSet;
import java.util.Scanner;

public class 最大不重复子串
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		// HashSet<Character> set=new HashSet<>();
		// int max=0;
		// int left=0;
		// int right=0;
		// while(right<s.length())
		// {
		// char c=s.charAt(right);
		// if(!set.contains(c))
		// {
		// set.add(c);
		// if(max<set.size())
		// max=set.size();
		// }
		// else
		// {
		// while(s.charAt(left)!=c)
		// {
		// left++;
		// set.remove(s.charAt(left));
		// }//left现在就是c
		// left++;
		// //set.remove(s.charAt(left));
		// set.add(c);
		// right++;
		// }
		// }
		// System.out.println(max);

		int c[] = new int[256];
		for (int i = 0; i < 256; i++)
			c[i] = -1;
		int p = 0;
		int max = 0;
		int n = s.length();
		for (int i = 0; i < n; i++)
		{
			if (c[s.charAt(i)] != -1)
			{
				if (c[s.charAt(i)] >= p)
				{
					p = c[s.charAt(i)] + 1;
				}
				c[s.charAt(i)] = i;
			} else
			{
				c[s.charAt(i)] = i;
			}
			max = Math.max(max, i - p + 1);
		}

		System.out.println(max);

	}

}
