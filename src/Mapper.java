import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;


public class Mapper
{

	//输入文件A：key,property1
	//输入文件B：key,property2
	public static void main(String[] args) 
	{
		BufferedReader fa=null,fb=null;
		try
		{
			fa=new BufferedReader(new FileReader(new File("a")));
			fb=new BufferedReader(new FileReader(new File("b")));
			String line=null;
			while((line=fa.readLine())!=null)
			{
				String words[]=line.split("\t");
				System.out.println(String.format("%s\t%s\t0", words[0],words[1])); 
			}
			while((line=fb.readLine())!=null)
			{
				String words[]=line.split("\t");
				System.out.println(String.format("%s\t0\t%s", words[0],words[1])); 
			}
		} catch (IOException e)
		{
			// TODO: handle exception
			e.printStackTrace(); 
			
		}
		try
		{
			fa.close();
			fb.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
