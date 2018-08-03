package leetcode200AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem273
{
	String[] out = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
	String[] out2 = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
			"Ten" };
	String[] out3 = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public String numberToWords(int num)
	{
		if (num < 0)
			return "";
		if (num == 0)
			return "Zero";
		List<String> result = new ArrayList<String>();
		int digit = 1;
		while (num >= Math.pow(10, digit))
		{
			digit++;
		}
		// digit--;
		// System.out.println(digit);
		if (digit > 9)
		{
			int temp = (int) Math.pow(10, 9);
			int nowdigit = num / temp;
			result.add(out[nowdigit]);
			result.add("Billion");
			num = num - nowdigit * temp;
			digit = 8;
		}
		if (digit > 6)
		{
			int temp = (int) Math.pow(10, 6);
			int nowdigit = num / temp;
			result.addAll(help(nowdigit));
			if(nowdigit>0)
				result.add("Million");
			num = num - nowdigit * temp;
			digit = 5;
		}
		if (digit > 3)
		{
			// System.out.println(num);
			int temp = (int) Math.pow(10, 3);
			int nowdigit = num / temp;
			result.addAll(help(nowdigit));
			if(nowdigit>0)
				result.add("Thousand");
			num = num - nowdigit * temp;
			digit = 2;
		}
		result.addAll(help(num));
		String re = "";
		for (String string : result)
		{
			re += string + " ";
		}
		// System.out.println(result);
		return re.substring(0, re.length() - 1);
	}

	public List<String> help(int num)
	{
		List<String> r = new ArrayList<String>();

		if (num >= 100)
		{
			int d = num / 100;
			r.add(out[d]);
			if(d>0)
				r.add("Hundred");
			num = num - d * 100;
		}
		if (num >= 10)
		{
			if (num < 20)
			{
				r.add(out3[num - 10]);
				return r;
			} else
			{
				int d = num / 10;
				r.add(out2[d]);
				// r.add("Hundred");
				num = num - d * 10;
			}
		}
		if (num > 0)
		{
			r.add(out[num]);
		}
		return r;
	}

	public static void main(String[] args)
	{
		int t = 1000000;
		Problem273 p = new Problem273();
		System.out.println(p.numberToWords(t));
	}

}
