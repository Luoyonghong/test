package leetcode87AndLater;

public class Problem91
{
	public int numDecodings(String s)
	{
		if(s.length()==0)
			return 0;
		if(s.contains("00"))
			return 0;
		if(s.charAt(0)=='0') 
			return 0;
		if(s.length()<2)
			return s.length();
		int[] r=new int[s.length()];
		if(s.length()>=2)
		{
			if(Integer.parseInt(s.substring(0, 2))>26&&s.charAt(1)=='0')
				return 0;
			if(Integer.parseInt(s.substring(0, 2))>26||s.charAt(1)=='0')
			{
				r[0]=1;
				r[1]=1;
			}
			else
			{
				r[0]=1;
				r[1]=2;
			}
		}
		char[] t=new char[2];
		for(int i=2;i<s.length();i++)
		{
			t[0]=s.charAt(i-1);
			t[1]=s.charAt(i);
			if(Integer.parseInt(new String(t))<=26&&s.charAt(i)!='0'&&s.charAt(i-1)!='0')
				r[i]=r[i-1]+r[i-2];
			if(Integer.parseInt(new String(t))<=26&&s.charAt(i)=='0')
				r[i]=r[i-2];
			if(Integer.parseInt(new String(t))<=26&&s.charAt(i-1)=='0')
				r[i]=r[i-1];
			if(Integer.parseInt(new String(t))>26&&s.charAt(i)!='0')
				r[i]=r[i-1];
			if(Integer.parseInt(new String(t))>26&&s.charAt(i)=='0')
				return 0;
		}
		return r[s.length()-1];

	}
}
