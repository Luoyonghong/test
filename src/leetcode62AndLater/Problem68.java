package leetcode62AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem68
{

	public List<String> fullJustify2(String[] words, int maxWidth)
	{
		List<String> result = new ArrayList<>();  
        int pos = 0;  
        int len = 0;  
        int w = 0;  
        for(int i=0; i<words.length; i++) {  
            len += words[i].length();  
            w ++;  
            if (len + (w-1) > maxWidth) {  
                StringBuilder sb = new StringBuilder();  
                int remainSpaces = maxWidth - (len - words[i].length());  
                int remainWords = w - 2;  
                int space = remainWords>0?(int)Math.ceil((double)remainSpaces/remainWords): remainSpaces;  
                for(int j=0; j<w-1; j++) {  
                    sb.append(words[i+1-w+j]);  
                      
                    for(int k=0; k<space; k++) sb.append(" ");  
                    remainSpaces -= space;  
                    remainWords --;  
                    space = remainWords>0?(int)Math.ceil((double)remainSpaces/remainWords): remainSpaces;  
                }  
                result.add(sb.toString());  
                len = words[i].length();  
                w = 1;  
            }  
            if (i==words.length-1) {  
                StringBuilder sb = new StringBuilder();  
                int remainSpaces = maxWidth - len;  
                int space = 1;  
                for(int j=0; j<w; j++) {  
                    sb.append(words[i+1-w+j]);  
                    if (j<w-1) space = 1; else space = remainSpaces;  
                    for(int k=0; k<space; k++) sb.append(" ");  
                    remainSpaces -= space;  
                }  
                result.add(sb.toString());  
            }  
        }  
        return result; 
	}

	public List<String> fullJustify(String[] words, int maxWidth)
	{
		List<String> r=new ArrayList<String>();
		List<String> temp=new ArrayList<String>();
		int wordCount=0,length=0;
		for(int i=0;i<words.length;i++)
		{
			wordCount++;
			length+=words[i].length();
			temp.add(words[i]);
			if(length+wordCount-1>maxWidth)
			{
				if(temp.size()==1)
				{
					StringBuffer b=new StringBuffer();
					b.append(temp.get(0));
					for(int j=0;j<maxWidth-temp.get(0).length();j++)
					{
						b.append(' ');
					}
					r.add(b.toString());
					temp.clear();
					wordCount=0; 
					length=0;
				}
				else
				{
					int baseSpace=0;
					baseSpace=(maxWidth-length-wordCount+1)/(wordCount-1);
					int remainder=maxWidth-length-wordCount+1-baseSpace*(wordCount-1);
					StringBuffer b=new StringBuffer();
					for(int j=0;j<temp.size()-1;j++)
					{
						b.append(temp.get(j));
						b.append(' ');
						for(int k=0;k<baseSpace;k++)
						{
							b.append(' ');
						}
						if(remainder>0)
						{
							b.append(' ');
							remainder--;
						}
					}
					b.append(temp.get(temp.size()-1));
					r.add(b.toString());
					temp.clear();
					wordCount=0; 
					length=0;
				}
			}
			
			if(i==words.length-1)
			{
				StringBuffer b=new StringBuffer();
				for(int k=0;k<temp.size();k++)
				{
					b.append(temp.get(k));
					b.append(' ');
				}
				for(int k=0;k<maxWidth-length-wordCount+1;k++)
					b.append(' ');
				r.add(b.toString());
			}
		}
		return r;
		
	}
	
	
	public static void main(String[] args)
	{
		Problem68 p=new Problem68();
		String[] words={"This", "is", "an", "example", "of", "text", "justification."};
		List<String> l=p.fullJustify(words, 16);
		for (String string : l)
		{
			System.out.println(string.length()+":"+string+"}"); 
		}
	}
}
