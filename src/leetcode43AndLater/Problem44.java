package leetcode43AndLater;

public class Problem44
{
	/*   abefcdgiescdfimde,ab*cd?i*de
	 * a记录s当前遍历位置，b记录p的
	 * p遇到了*则往后看，找到第一个不是*和？的字母，更新b，用starNextChar记录此时的b
	 * a往后遍历，找到第一个和p[b]相同的字母，前提是a往后遍历的字母数量要大于刚刚*后面的？数量（一般为0）,更新a，startNextCharOfS记录此时的a
	 * 此时s[startNextCharOfS]=p[starNextChar]
	 * 继续遍历p,s 如果出现了a,b均不是特殊字母，但匹配不上的情况，或者b到了末尾的情况，说明这次匹配失败了
	 * 那么将b重新设置成starNextChar，即退回到*后第一个非特殊字母上
	 * 且将startNextCharOfS++，并a=startNextCharOfS,即 a跳过之前遇到的s[startNextCharOfS]，
	 * 然后寻找下一个和p[starNextChar]匹配的字母，并更新startNextCharOfS
	 * 
	 * 例子：
	 * i后面的*之后第一个非特殊字母是d, p:de
	 * s在i之后第一次遇到d:dfimde
	 * 匹配到f与e的时候失败
	 * p重置为d,s重置为f(恰好跳过第一个d),然后往后遍历，寻找第二个d，s跳过了fim，变成了de(第二个d)
	 * 匹配成功
	 * 
	 * 算法可能会遍历重复次数的p，p即便到了尽头也有可能跳回去
	 * 但s尽管也会跳回，但s到了尽头则说明完全匹配失败，不会跳回了
	 */
	public boolean isMatch2(String s, String p)
	{
		System.out.println("start! "+s+" \t"+p); 
		int a=0,b=0;
		int starNextChar=0;//p在*后的第一个字母
		int startNextCharOfS=0;//s在*后的第一个字母
		if(p.length()==0&&s.length()==0)
			return true;
		if(p.length()==0)
			return false;
		if(s.length()==0&&!allStar(p, 0))
			return false;
		boolean isAllStar=true;
		for(int i=0;i<p.length();i++)
		{
			if(p.charAt(i)!='*')
			{
				isAllStar=false;
				break;
			}
		}
		if(isAllStar)
			return true;
		
		boolean beforeIsStar=false;
		while(a<s.length()&&b<=p.length())
		{
			if(beforeIsStar&&b==p.length())
			{
				System.out.println("p到了末尾，回退"); 
				b=starNextChar;
				startNextCharOfS++;
				a=startNextCharOfS;
				while(s.charAt(a)!=p.charAt(b))
				{
					a++;
					if(a==s.length())
						break;
				}
				continue;
			}
			if(!beforeIsStar&&b==p.length())
				return false;
			char t2=p.charAt(b);
			char t1=s.charAt(a);
			System.out.println("left s is : "+s.substring(a)+"\tleft p is : "+p.substring(b));  
			if(t2!='?'&&t2!='*')
			{
				if(t2!=t1)
				{
					if(!beforeIsStar)
						return false;
					else
					{
						System.out.println("出现不匹配现象，回退"); 
						//b-1 变成*后的第一个字母
						b=starNextChar;
						t2=p.charAt(b);
						startNextCharOfS++;
						a=startNextCharOfS;
						t1=s.charAt(a);
						while(t1!=t2)
						{
							a++;
							if(a==s.length())
								break;
							t1=s.charAt(a);
						}
						continue;
					}
				}
				else
				{
					a++;
					b++;
					continue;
				}
			}
			else if (t2=='?')
			{
				a++;
				b++;
			}
			else if (t2=='*')
			{
				beforeIsStar=true;
				int countWenhao=0;
				b++;
				while(b<p.length()&&(p.charAt(b)=='?'||p.charAt(b)=='*'))
				{
					if(b==p.length())
						break;
					if(p.charAt(b)=='?')
						countWenhao++;
					b++;
				}
				if(b==p.length())//说明p到结束的地方了，而它之前的符号是？与*
				{
					if(s.length()-a>=countWenhao)
						return true;
					else
						return false;
				}
				char t3=p.charAt(b);//找到*之后第一个非特殊字符
				starNextChar=b;
				int countT1=0;
				//while(t1!=t3)
				a=a+countWenhao;
				if(a==s.length())
					return false;
				t1=s.charAt(a);//找到*后面第一个字母的时候，s需要加上中间的？个数再说
				while(t1!=t3)
				{
					countT1++;
					a++;
					if(a==s.length())//说明s遍历到结束的地方，也没有找到t3
						break;
					t1=s.charAt(a);
				}
				startNextCharOfS=a;
			}
		}
		if(a==s.length()&&b==p.length())
			return true;
		else if (a==s.length()&&b<p.length()&&allStar(p,b))//最后匹配完成后p有可能剩余* ，如a与a*
			return true;
		else
			return false;
	}
	public boolean allStar(String p, int b)
	{
		for(int i=b;i<p.length();i++)
			if(p.charAt(i)!='*')
				return false;
		return true;
	}
	
	public boolean isMatch(String str, String pattern)
	{
		int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
        	System.out.println("left s is : "+str.substring(s)+"\tleft p is : "+pattern.substring(p));  
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
            	System.out.println("回退"); 
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
	}
	
	public static void main(String[] args)
	{
		Problem44 p=new Problem44();
		//System.out.println(p.isMatch2("abefcdgiescdfimde","ab*cd?i*de")); //true
		System.out.println(p.isMatch2("zacabz","*a?b*")); //false
		//System.out.println(p.isMatch2("leetcode","*e*t?d*")); //false
		//System.out.println(p.isMatch2("aabb","*aa*")); //false
		//System.out.println(p.isMatch2("ba","b*?a?")); //false
		//System.out.println(p.isMatch2("aab","c*a*b")); //false
		//System.out.println(p.isMatch2("aaaa","**a")); //true
		//System.out.println(p.isMatch2("abaab","*?a?")); //true
		 
	}
}
