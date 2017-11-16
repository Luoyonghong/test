package leetcode;

public class Problem14
{
	public static String longestCommonPrefix(String[] strs)
	{
		int k=0;
		if(strs.length==0||strs[0].length()==0)
			return "";
		boolean isok=true;
		while(k<strs[0].length()&&isok)
		{
			//System.out.println(k); 
			char t=strs[0].charAt(k);
			
			for(int i=0;i<strs.length;i++)
			{
				if(k>=strs[i].length()||strs[i].charAt(k)!=t)
				{
					isok=false;
					break;
				}
			}
			k++;
		}
		//System.out.println(k); 
		return isok?strs[0].substring(0,k):strs[0].substring(0,k-1);
		
	}
	public static void main(String[] args)
	{
		System.out.println(longestCommonPrefix(new String[]{"a","aa","b"}));
	}
}
