package leetcode;

public class Problem5 {

	public static String longestPalindrome(String s) {
		char[] res=new char[2*s.length()+3];
		res[0]='$';
		for(int i=0;i<s.length();i++)
		{
			res[2*i+1]='#';
			res[2*i+2]=s.charAt(i);
		}
		res[s.length()*2 + 1]='#';
		res[s.length()*2 + 2]=')';
		//System.out.println(res.length()); 
		int p[]=new int[res.length];
		/*
		 * T[i]为res[i]
		 * P[ i ]为新字符串T的T[ i ]处的回文半径，表示以字符T[i]为中心的最长回文字串的最端右字符到T[i]的长度，
		 * 如以T[ i ]为中心的最长回文子串的为T[ l, r ]，那么P[ i ]=r-i+1。
		 * 这样最后遍历数组P[ ]，取其中最大值即可。若P[ i ]=1表示该回文串就是T[ i  ]本身
		 * 
		 * 数组P有一性质，P[ i ]-1就是该回文子串在原字符串S中的长度 ，那就是P[i]-1就是该回文子串在原字符串S中的长度，
		 * 至于证明，首先在转换得到的字符串T中，所有的回文字串的长度都为奇数，
		 * 那么对于以T[i]为中心的最长回文字串，其长度就为2*P[i]-1,经过观察可知，
		 * T中所有的回文子串，其中分隔符的数量一定比其他字符的数量多1，也就是有P[i]个分隔符，
		 * 剩下P[i]-1个字符来自原字符串，所以该回文串在原字符串中的长度就为P[i]-1。
		 */
		int mi=0,right=0;//mi为最大回文串对应的中心点，right为该回文串能达到的最右端的值
		int maxLen=0,maxPoint=0;//maxLen为最大回文串的长度，maxPoint为记录中心点
		for(int i=1;i<res.length-1;i++)//注意i=1,且小于length-1 ,0和结尾会数组越界
		{
			if(right>i)
			{
				if(p[2*mi-i]<right-i)
					p[i]=p[2*mi-i];
				else
				{
					p[i]=right-i;
					while(res[i+p[i]]==res[i-p[i]])
						p[i]++;
				}
				//p[i]=Math.min(right-i, p[2*mi-i]);//如果P[j] <R-i  返回p[j],即最小值；如果p[j]>r-i,则返回最小的r-i,然后再一一匹配
			}
			else
			{
				p[i]=1;
				try{
				while(res[i+p[i]]==res[i-p[i]])
					p[i]++;
				}
				catch(Exception e)
				{
					System.out.println(i); 
					e.printStackTrace();  
				}
			}
			if(right<i+p[i])
			{
				right=i+p[i];
				mi=i;
			}
			if(maxLen<p[i])
			{
				maxLen=p[i];
				maxPoint=i;
			}
		}
		maxPoint--;//因为最开始加了一个字符，所以减一
		//maxLen-1才是长度
		//System.out.println(maxLen);
		//System.out.println(maxPoint); 
		
		return s.substring(maxPoint/2-(maxLen-1)/2,maxPoint/2-(maxLen-1)/2+(maxLen-1));
	}
	public static void main(String[] args) {
		System.out.println(longestPalindrome("caba")); 
	}
}
