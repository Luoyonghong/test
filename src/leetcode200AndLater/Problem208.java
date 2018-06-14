package leetcode200AndLater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode
{
	boolean isWord;
	HashMap<Character, TrieNode> nexts;
    public TrieNode() {
    	nexts=new HashMap<Character, TrieNode>();
    }
}

class Trie {
    /** Initialize your data structure here. */
	TrieNode root;
    public Trie() {
    	root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode temp=root;
        for(int i=0;i<word.length();i++)
        {
        	char t=word.charAt(i);
        	if(temp.nexts.containsKey(t))
        		temp=temp.nexts.get(t);
        	else
        	{
        		temp.nexts.put(t, new TrieNode());
        		temp=temp.nexts.get(t);
        	}
        	if(i==word.length()-1)
        		temp.isWord=true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode temp=root;
        for(int i=0;i<word.length();i++)
        {
        	char t=word.charAt(i);
        	if(temp.nexts.containsKey(t))
        		temp=temp.nexts.get(t);
        	else
        	{
        		return false;
        	}
        	if(i==word.length()-1&&!temp.isWord)
        		return false;
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode temp=root;
        for(int i=0;i<prefix.length();i++)
        {
        	char t=prefix.charAt(i);
        	if(temp.nexts.containsKey(t))
        		temp=temp.nexts.get(t);
        	else
        	{
        		return false;
        	}
        	if(i==prefix.length()-1)
        	{
        		if(temp.isWord||temp.nexts.size()>0)
        			return true;
        		else
        			return false;
        	}	
        }
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
