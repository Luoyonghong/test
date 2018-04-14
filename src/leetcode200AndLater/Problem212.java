package leetcode200AndLater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem212
{
	/*
	 * Given words = ["oath","pea","eat","rain"] and board =
		[
		  ['o','a','a','n'],
		  ['e','t','a','e'],
		  ['i','h','k','r'],
		  ['i','f','l','v']
		]
		Return ["eat","oath"].
	 * 
	 * 
	 */
	HashMap<String, Integer> map=new HashMap<String, Integer>();
	List<String> result=new ArrayList<String>();
	boolean[] isok;
	boolean[][] used;
	public List<String> findWords(char[][] board, String[] words)
	{
		if(board==null||board.length==0)
			return new ArrayList<String>();
		HashSet<String> set=new HashSet<String>();
		for (String string : words)
		{
			set.add(string);
		}
		words=new String[set.size()];
		List<String> l=new ArrayList<String>(set);
		l.toArray(words );
		isok=new boolean[words.length];
		for (int k=0;k<words.length;k++)
		{
			String s=words[k];
			map.put(s, k);
			char d=s.charAt(0);
			for(int i=0;i<board.length;i++)
				for(int j=0;j<board[0].length;j++)
				{
					if(!isok[k]&&board[i][j]==d)
					{
						used=new boolean[board.length][board[0].length];
						StringBuilder b=new StringBuilder();
						help(board, i, j, s, b);
					}
				}
		}
		
		for(int i=0;i<isok.length;i++)
		{
			if(isok[i])
				result.add(words[i]);
		}
		return result;
	}
	
	public boolean help(char[][] board, int i, int j, String s, StringBuilder b)
	{
		if(i<board.length&&i>=0&&j<board[0].length&&j>=0&&!used[i][j])
		{
			b.append(board[i][j]);
			used[i][j]=true;
			if(b.toString().equals(s))
			{
				isok[map.get(s)]=true;
				return true;
			}
			boolean t= help(board, i+1, j, s, b)||help(board, i, j+1, s, b)||help(board, i-1, j, s, b)||help(board, i, j-1, s, b);
			used[i][j]=false;
			b.deleteCharAt(b.length()-1);
			return t;
		}
		else
			return false;
	}
	public static void main(String[] args)
	{
		Problem212 p=new Problem212();
		char[][] board={
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String words[]={"oath","pea","eat","rain"};
		List<String> r=p.findWords(board, words);
		for (String string : r)
		{
			System.out.println(string); 
		}
	}
}
