
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reducer
{

	// 输入文件A：key,property1,0
	// 输入文件B：key,0,property2
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		List<String> property1=new ArrayList<>();
		List<String> property2=new ArrayList<>();
		String lastkey="";
		while(sc.hasNext())
		{
			String line=sc.nextLine();
			String words[]=line.split("\t");
			if(words.length==3)
			{
				String key=words[0];
				if(!key.equals(lastkey))
				{
					if(!words[1].equals("0"))
						property1.add(words[1]);
					if(!words[2].equals("1"))
						property2.add(words[2]);
				}//此次的key与上一次相同，则将数据放入到list
				else
				{
					if(!key.equals(""))//必须判断是否为初始化的“”
					{
						for(int i=0;i<property1.size();i++)
						{
							for(int j=0;j<property2.size();j++)
							{
								System.out.println(String.format("%s\t%s\t%s", lastkey,property1.get(i),property2.get(j))); 
							}
						}
					}
					//更新lastkey,清空list,放入当前value
					lastkey=key;
					property1.clear();
					property1.clear(); 
					if(!words[1].equals("0"))
						property1.add(words[1]);
					if(!words[2].equals("1"))
						property2.add(words[2]);
				}
			}
		}
		if(!lastkey.equals(""))//输出最后的value
		{
			for(int i=0;i<property1.size();i++)
			{
				for(int j=0;j<property2.size();j++)
				{
					System.out.println(String.format("%s\t%s\t%s", lastkey,property1.get(i),property2.get(j))); 
				}
			}
		}
		sc.close();
	}
}
