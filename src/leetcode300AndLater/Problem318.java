package leetcode300AndLater;

public class Problem318
{
	public int maxProduct(String[] words)
	{
		int w[]=new int[words.length];
		for(int i=0;i<words.length;i++)
		{
			String result=process(words[i]);
			//System.out.println(result); 
			w[i]=Integer.valueOf(result, 2);
		}
		int max=0;
		for(int i=0;i<w.length;i++)
		{
			for(int j=i+1;j<w.length;j++)
			{
				if((w[i]&w[j])==0)
				{
					int temp=words[i].length()*words[j].length();
					if(temp>max)
						max=temp;
				}
			}
		}
		return max;	

	}
	
	public String process(String s)
	{
		char out[]=new char[26];
		for(int i=0;i<26;i++)
			out[i]='0';
		for(int i =0;i<s.length();i++)
		{
			out[s.charAt(i)-'a']='1';
		}
		
		return new String(out);
	}
	public static void main(String[] args)
	{
		Problem318 p=new Problem318();
		String sss[]={"abcw","baz","foo","bar","xtfn","abcdef"};
		System.out.println(p.maxProduct(sss)); 
		//System.out.println(Integer.valueOf(p.process("baz"),2)); 
		
		//System.out.println(Integer.parseInt("1111",2));  
	}
}
