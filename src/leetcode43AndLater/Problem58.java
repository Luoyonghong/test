package leetcode43AndLater;

public class Problem58
{
	 public int lengthOfLastWord(String s) {
	        s=s.trim();
	        if(s.length()==0)
				return 0;
			for(int i=s.length()-1;i>=0;i--)
			{
				char c=s.charAt(i);
				if(c==' ')
					return s.length()-i-1;
			}
			return s.length();
	    }
}
