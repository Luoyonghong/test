package leetcode200AndLater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode
{
	boolean isWord;
	TrieNode[] nexts;
    public TrieNode() {
    	nexts=new TrieNode[26];
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
        	int num=t-'a';
        	if(temp.nexts[num]!=null)
        		temp=temp.nexts[num];
        	else
        	{
        		temp.nexts[num]=new TrieNode();
        		temp=temp.nexts[num];
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
        	int num=t-'a';
        	if(temp.nexts[num]!=null)
        		temp=temp.nexts[num];
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
        	int num=t-'a';
        	if(temp.nexts[num]!=null)
        		temp=temp.nexts[num];
        	else
        	{
        		return false;
        	}
        	if(i==prefix.length()-1)
        	{
        		if(temp.isWord||getNum(temp.nexts)>0)
        			return true;
        		else
        			return false;
        	}	
        }
        return true;
    }
    private int getNum(TrieNode nodes[])
    {
    	int count=0;
    	for(int i=0;i<nodes.length;i++)
    		if(nodes[i]!=null)
    			count++;
    	return count;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
