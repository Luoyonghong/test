package leetcode71AndLater;

public class Problem76
{

	/*
	 * 左窗口和右窗口
	 * 首先找到满足所有t的嘴开始的片段
	 * 然后移动右窗口，找到下一个包含在t中的字符
	 * 然后移动左窗口，直到t的字符不被全部包含
	 * 再移动右窗口
	 * 
	 */
	public String minWindow(String s, String t)
	{
		if(t.length()>s.length())
			return "";
		int f[]=new int[t.length()];
		int baseF[]=new int[t.length()];
		for(int j=0;j<t.length();j++)
		{
			baseF[t.indexOf(t.charAt(j))]++;
		}
		int count=0;
		int i=0;
		int minLength=0;
		int firstOccur=0;
		boolean isFirst=false;
		for(;i<s.length();i++)
		{
			int index=t.indexOf(s.charAt(i));
			if(index>=0)
			{
				if(!isFirst)
				{
					firstOccur=i;
					//System.out.println(firstOccur); 
					isFirst=true;
				}
				count++;
				f[index]++;
			}
			if(count>=t.length())
				if(isAllBiggerThan0(f,baseF))
					break;
		}
		int candidataFirstOccur=firstOccur;//上一个
		int[] result=new int[2];
		if(i==s.length())
			i--;
		if(!isAllBiggerThan0(f,baseF))
			return "";
		result[0]=firstOccur;
		result[1]=i; 
		minLength=i-firstOccur;
		//printF(f);
		while(firstOccur<i)
		{
			
			System.out.println(firstOccur); 
			printF(f);
			int m=t.indexOf(s.charAt(firstOccur));
			if(m>=0)
			{
				f[m]--;
				if(f[m]<baseF[m])
				{
					if(i-firstOccur<=minLength)
					{
						minLength=i-firstOccur;
						result[1]=i;
						result[0]=firstOccur;
					}
					//firstOccur=candidataFirstOccur;
					f[m]++;
					break;
				}
			}
			firstOccur++;
		}
		System.out.println("orignl s: "+s); 
		System.out.println("nowMin: "+s.substring(result[0],result[1]+1)); 
		printF(f);
		minLength=i-firstOccur;
		//第一次找齐所有T中字母后，也要从开始找到最短的
		for(i=i+1;i<s.length();i++)
		{
			//System.out.println(i); 
			System.out.println("i: "+i+" nowMin: "+s.substring(result[0],result[1]+1)); 
			printF(f);
			int index=t.indexOf(s.charAt(i));
			if(index>=0)
			{
				f[index]++;
				//firstOccur++;
				while(firstOccur<i)
				{
					
					System.out.println(firstOccur); 
					printF(f);
					int m=t.indexOf(s.charAt(firstOccur));
					if(m>=0)
					{
						f[m]--;
						if(f[m]<baseF[m])
						{
							if(i-firstOccur<=minLength)
							{
								minLength=i-firstOccur;
								result[1]=i;
								result[0]=firstOccur;
							}
							//firstOccur=candidataFirstOccur;
							f[m]++;
							break;
						}
					}
					firstOccur++;
				}
			}	
		}
		return s.substring(result[0],result[1]+1);
	}
	public void printF(int[] f)
	{
		for (int i : f)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public boolean isAllBiggerThan0(int[] f,int baseF[])
	{
		for (int i=0;i<f.length;i++)
		{
			if(f[i]<baseF[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		Problem76 p=new Problem76();
		String s="bba";
		String t="ab";
		System.out.println(p.minWindow(s, t));
	}
}
