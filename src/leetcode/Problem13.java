package leetcode;

public class Problem13
{

	public static int romanToInt(String s)
	{
		int num=0;
		for(int i=s.length()-1;i>=0;i--)
		{
			char t=s.charAt(i);
			switch (t)
			{
			case 'I':
				num+=1;
				break;
			case 'X':
				num+=10;
				if(i>0)
				if(s.charAt(i-1)=='I')
				{
					num--;
					i--;
				}
				break;	
			case 'C':
				num+=100;
				if(i>0)
				if(s.charAt(i-1)=='X')
				{
					num-=10;
					i--;
				}
				break;	
			case 'M':
				num+=1000;
				if(i>0)
				if(s.charAt(i-1)=='C')
				{
					num-=100;
					i--;
				}
				break;	
			case 'V':
				num+=5;
				if(i>0)
				if(s.charAt(i-1)=='I')
				{
					num--;
					i--;
				}
				break;	
			case 'L':
				num+=50;
				if(i>0)
				if(s.charAt(i-1)=='X')
				{
					num-=10;
					i--;
				}
				break;	
			case 'D':
				num+=500;
				if(i>0)
				if(s.charAt(i-1)=='C')
				{
					num-=100;
					i--;
				}
				break;	
				
			default:
				break;
			}
		}
		return num;
	}
	public static void main(String[] args)
	{
		System.out.println(romanToInt("XX"));
	}
}
