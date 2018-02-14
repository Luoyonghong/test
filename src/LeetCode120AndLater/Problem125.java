package LeetCode120AndLater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Problem125
{
	public int ladderLength(String beginWord, String endWord, List<String> wordList)
	{
		//广度优先遍历
		HashMap<String, Boolean> used=new HashMap<>();
		Set<String> set = new HashSet<String>(wordList); 
		used.put(beginWord, true);
		int curnum=1;
		int nextnum=0;
		int level=1;
		Queue<String> q=new LinkedList<>();
		q.offer(beginWord);
		while(!q.isEmpty())
		{
			curnum--;
			String t=q.poll();
			char[] k=t.toCharArray();
			for(int i=0;i<k.length;i++)
			{
				char ori=k[i];
				for(int j=0;j<26;j++)
				{
					k[i]=(char) ('a'+j);
					String temp=new String(k);
					if(set.contains(temp)&&!used.containsKey(temp)) 
					{
						if(temp.equals(endWord))
							return level+1;
						q.offer(temp);
						used.put(temp, true);
						nextnum++;//记录下一层的单词个数
					}
			
				}
				k[i]=ori;
			}
			if(curnum==0)//每次取一个词出来，当cur为0的时候，说明当前层遍历完了，到了下一层，level++
			{
				level++;
				curnum=nextnum;
				nextnum=0;
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args)
	{
		String beginWord="hit",endWord="cog";
		List<String> wordList=new ArrayList<>();
		//"hot","dot","dog","lot","log","cog"
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		//wordList.add("cog");
		Problem125 p=new Problem125();
		System.out.println(p.ladderLength(beginWord, endWord, wordList));
		
		
	}
	
}
