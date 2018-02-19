package LeetCode120AndLater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem140
{
	int [] isok;
	Map<Integer, List<String>> map=new HashMap<>();
	List<String> cur=new ArrayList<>();
	List<List<String>> re=new ArrayList<>();
	public List<String> wordBreak(String s, List<String> wordDict)
	{
		Set<String> set=new HashSet<>();
		set.addAll(wordDict);
		isok=new int[s.length()];
		f(s, 0, s.length(), set);
		
		List<String> h=new ArrayList<>();
		for(int i=0;i<re.size();i++)
		{
			List<String> temp=re.get(i);
			StringBuffer b=new StringBuffer();
			for(int j=0;j<temp.size();j++)
			{
				b.append(temp.get(j));
				b.append(" ");
			}
			b.deleteCharAt(b.length()-1);
			h.add(b.toString());
		}
		return h;
	}
	
	public boolean f(String s, int begin, int n,Set<String> set)
	{
		//直接算也可以，但会超时，所以用了备忘录
		
		//begin可以到n-1
		if(begin==n)
		{
			return true;
		}
		if(isok[begin]==-1)
			return false;
		if(set.contains(s.substring(begin,n)))
		{
			isok[begin]=1;
			cur.add(s.substring(begin,n));
			re.add(clone(cur));
			cur.remove(cur.size()-1);
			//return true;
		}
		boolean thisok=false;
		for(int i=begin;i<n;i++)
		{
			if(set.contains(s.substring(begin,i+1)))
			{
				cur.add(s.substring(begin,i+1)); 
				if(f(s,i+1,n,set))
				{
					isok[begin]=1;
					thisok=true;
				}
				cur.remove(cur.size()-1);
				//return true;
			}
		}
		if(!thisok)
		{
			isok[begin]=-1;
			return false;
		}
		else
			return true;
	}
	public List<String> clone(List<String> r)
	{
		List<String> t=new ArrayList<>();
		for (String string : r)
		{
			t.add(string);
		}
		return t;
	}
	public static void main(String[] args)
	{
		Problem140 p=new Problem140();
		String s="catsanddog";
		List<String> wordDict=new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		List<String> h=p.wordBreak(s, wordDict);
		for (String string : h)
		{
			System.out.println(string); 
		}
	}
	
}
