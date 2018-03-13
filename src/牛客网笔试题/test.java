package 牛客网笔试题;

public class test
{
	public static void main(String[] args)
	{
		int a=0,b=0,c=0,d=0,e=0;
		//a鸭 b鹅 c马 d牛 e羊
		for(;a<500;a++)
			for(;b<500;b++)
				for(;c<500;c++)
					for(;d<500;d++)
						for(;e<500;e++)
						{
							if(a+a+c==369&&c+d+a==594&&e+b+d==316&&a+c+a==143)
								break;
						}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
	}
}
