package leetcode33AndLarger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 章节
{
	public static void main(String[] args)
	{
		try
		{
			String a[]={"","一","二","三","四","五","六","七","八","九"};
			FileWriter f=new FileWriter("xiugaihou.txt",false);
			BufferedReader b=new BufferedReader(new FileReader(new File("C:/迅雷下载/城管无敌 (2).txt")));
			String s="";
			while((s=b.readLine())!=null)
			{
				for(int i=0;i<10;i++)
					for(int j=0;j<10;j++)
					{
					
						String t="";
						if(i==0)
							t=a[j]+"、";
						else
						{
							t=a[i]+"十"+a[j]+"、";
						}
						String tt=t.substring(0, t.length()-1)+"章"+"、";
						s.replace(t, tt); 
					}
				f.write(s+"\r\n"); 
				f.flush();
			} 
			
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
