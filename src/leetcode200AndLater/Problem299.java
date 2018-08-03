package leetcode200AndLater;

import java.util.HashMap;

public class Problem299
{
	public String getHint(String secret, String guess)
	{
		int a = 0;
		int b = 0;
		char [] s = secret.toCharArray(),g=guess.toCharArray();
		HashMap<Character,Integer> map =new HashMap<>();
		boolean[] used= new boolean[s.length];
		for(int i =0;i<secret.length();i++)
			if(s[i]==g[i])
			{
				a++;
				used[i]=true;
			}
			else
			{
				if(map.containsKey(s[i]))
				{
					int nowvalue = map.get(s[i]);
					map.put(s[i],nowvalue+1); 
				}
				else
					map.put(s[i],1); 
			}
		for(int i=0;i<s.length;i++)
		{
			if(!used[i]&&map.containsKey(g[i]))
			{
				b++;
				int nowvalue = map.get(g[i]);
				if(nowvalue==1)
					map.remove(g[i]);
				else
					map.put(g[i],nowvalue-1); 
			}
		}
		
		return a+"A"+b+"B";
	}
}
