package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem30
{

	public static List<Integer> findSubstring(String s, String[] words)
	{
		if(s.length()==0)
			return new ArrayList<Integer>();
		if(words.length==0)
		{
			List<Integer> l=new ArrayList<Integer>();
			for (int i=0;i<s.length();i++)
			{
				l.add(i);
			}
			return l;
		}
		int wl=words[0].length();
		Map<String,Integer> m1=new HashMap<String, Integer>();
		Map<String,Integer> m2=new HashMap<String, Integer>();
		for(int i=0;i<words.length;i++)
		{
			if(m1.containsKey(words[i]))
			{
				int t=m1.get(words[i]);
				m1.put(words[i], t+1);
				m2.put(words[i], t+1);
			}
			else
			{
				m1.put(words[i], 1);
				m2.put(words[i], 1);
			}
		}
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<(s.length()-wl*words.length+1);i++)
		{
			String a=s.substring(i,i+wl);
			int count=1;
			while(m2.containsKey(a))
			{
				int t=m2.get(a);
				if(count==words.length&&t==1)
				{
					result.add(i);
					//i+=wl-1;
					break;
				}
				if(t<1)
					break;
				m2.put(a, t-1);
				a=s.substring(i+count*wl,i+(count+1)*wl);
				count++;
			}
			for (String gg : m1.keySet())
			{
				m2.put(gg, m1.get(gg)); 
			}
		}
		return result;
	}
	
	//滑动窗口
	public static List<Integer> findSubstring2(String s, String[] words)
	{
		int l=words[0].length();
		Map<String,Integer> m1=new HashMap<String, Integer>();
		Map<String,Integer> m2=new HashMap<String, Integer>();
		for(int i=0;i<words.length;i++)
		{
			if(m1.containsKey(words[i]))
			{
				int t=m1.get(words[i]);
				m1.put(words[i], t+1);
			}
			else
			{
				m1.put(words[i], 1);
			}
		}
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<l;i++)
		{
			int left=i;
			int right=i+l; 
			m2.clear();
			while(right<s.length()-l&&left<=right)
			{
				String b=s.substring(right,right+l);
				System.out.println("left: "+left+ "right: "+right+"  "+b); 
				if(m1.containsKey(b))
				{
					int t=0;
					if(m2.containsKey(b)) 
						t=m2.get(b);
					else
						t=0;
					if(t<m1.get(b))
					{
						m2.put(b, t+1);
						right+=l;
						if(t+1==m1.get(b))
							if(m2.size()==m1.size())
							{
								result.add(left);
								left=right;
								right+=l;
								continue;
							}
						continue;
					}
					else if(t==m1.get(b))
					{
						System.out.println("fuck"); 
						String a=s.substring(left,left+l);
						int tt=m2.get(a);
						m2.put(a, tt-1);
						left=left+l;
						while(a.compareTo(b)!=0)
						{
							a=s.substring(left,left+l);
							tt=m2.get(a);
							m2.put(a, tt-1);
							left=left+l;
						}
					}
					
				}
				else
				{
					left=right;
					right+=l;
				}
			}
		}
		return result;
		
	}
	

	public static void main(String[] args)
	{
		String s="howareyouare";
		String words[]={"are","you"};
		List<Integer> l=findSubstring2(s, words);
		for (Integer i : l)
		{
			System.out.println(i);
		}
	}

}
