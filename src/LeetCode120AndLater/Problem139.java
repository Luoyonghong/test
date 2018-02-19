package LeetCode120AndLater;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem139
{
	int [] isok;
	public boolean wordBreak(String s, List<String> wordDict)
	{
		Set<String> set=new HashSet<>();
		set.addAll(wordDict);
		isok=new int[s.length()];
		return f(s, 0, s.length(), set);
	}
	
	public boolean f(String s, int begin, int n,Set<String> set)
	{
		//直接算也可以，但会超时，所以用了备忘录
		if(isok[begin]==-1)
			return false;
		if(isok[begin]==1)
			return true;
		//begin可以到n-1
		if(begin==n)
		{
			return true;
		}
		if(set.contains(s.substring(begin,n)))
		{
			isok[begin]=1;
			return true;
		}
		for(int i=begin;i<n;i++)
		{
			if(set.contains(s.substring(begin,i+1))&&f(s,i+1,n,set))
			{
				isok[begin]=1;
				return true;
			}
		}
		isok[begin]=-1;
		return false;
	}
	public static void main(String[] args)
	{
		Problem139 p=new Problem139();
		List<String> wordDict=new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		wordDict.add("lhaha");
		System.out.println(p.wordBreak("leetcode", wordDict));
	}
}
