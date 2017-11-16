package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem12
{

	/*
	 * 1-3999
	 */
	public static String intToRoman(int num)
	{
		char[] times_10={'I','X','C','M'};
		char[] times_5={'V','L','D'};
		StringBuffer l=new StringBuffer();
		for(int i=3;i>=0;i--)
		{
			int a=num/(int)Math.pow(10, i);//最高位 
			if(a>=1&&a<=3)
			{
				for(int j=1;j<=a;j++)
					l.append(times_10[i]);
			}
			else if(a==4)
			{
				l.append(times_10[i]);
				l.append(times_5[i]);
			}
			else if(a==5)
				l.append(times_5[i]);
			else if(6<=a&&a<=8)
			{
				l.append(times_5[i]);
				for(int j=0;j<=a-6;j++)
					l.append(times_10[i]);
			}
			else if(a==9)
			{
				l.append(times_10[i]);
				l.append(times_10[i+1]);
			}
			num=num%(int)Math.pow(10, i);
			
		}
		
		return l.toString();
	}
	public static void main(String[] args)
	{
		System.out.println(intToRoman(8)); 
	}
}
