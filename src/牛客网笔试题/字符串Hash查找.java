package 牛客网笔试题;

public class 字符串Hash查找
{
	//s1中查找 s2
	public static int find(String s1,String s2)
	{
		int base=1;
		int n1=s1.length(),n2=s2.length();
		long hash=0l;
		for(int i=n2-1;i>=0;i--)
		{
			hash+=base*(s2.charAt(i)-'a');
			base*=13;
		}
		long temphash=0l;
		base=1;
		for(int i=n2-1;i>=0;i--)
		{
			temphash+=base*(s1.charAt(i)-'a');
			base*=13;
		}
		if(hash==temphash)
			return 0;
		
		System.out.println("temphash: "+temphash+" hash: "+hash); 
		for(int i=1;i<n1-n2;i++)
		{
			System.out.println("temphash: "+temphash+" hash: "+hash); 
			temphash=temphash*13+(int)(s1.charAt(i+n2-1)-'a')-(s1.charAt(i-1)-'a')*base;
			
			if(temphash==hash&&s1.substring(i, i+n2).compareTo(s2)==0) 
				return i;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		System.out.println(find("bacbababadababacambabacaddababacasdsd","ababaca")); 
	}
}
