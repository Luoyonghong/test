package 牛客网笔试题;

public class KMP算法
{
	//在s1中查找s2
	public static int compare(String s1,String s2)
	{
		int n1=s1.length();
		int n2=s2.length();
		int index=-1;
		int next[]=getNext(s2);
		for(int i=0;i<s1.length();i++)
		{
			while(index>-1&&s2.charAt(index+1)!=s1.charAt(i))
				index=next[index];
			if(s1.charAt(i)==s2.charAt(index+1))
				index++;
			if(index+1==n2)
				return i-n2+1;
		}
		
		return -1;
	}
	public static int[] getNext(String s2)
	{
		int n2=s2.length();
		int next[]=new int[n2];
		for(int i=0;i<n2;i++)
			next[i]=-1;
		int index=-1;

		for(int i=1;i<n2;i++)
		{
			while(index>-1&&s2.charAt(index+1)!=s2.charAt(i))
				index=next[index];
			if(s2.charAt(index+1)==s2.charAt(i))
				index++;
			next[i]=index;
		}
		
		
		return next;
	}
	public static void main(String[] args)
	{
		System.out.println(compare("bacbababadababacambabacaddababacasdsd","ababaca"));
	}
}
