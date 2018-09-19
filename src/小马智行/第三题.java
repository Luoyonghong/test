package 小马智行;

import java.util.Random;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class 第三题
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		for(int i=0;i<n;i++)
		{
			//l0, v0, l1, v1, x0, y0, r, x1, y1。
			float l0=sc.nextFloat();
			float v0=sc.nextFloat();
			float l1=sc.nextFloat();
			float v1=sc.nextFloat();
			float x0=sc.nextFloat();
			float y0=sc.nextFloat();
			float r=sc.nextFloat();
			float x1=sc.nextFloat();
			float y1=sc.nextFloat();
			//if(x0>x1)
			//	System.out.println("No"); 
			 if (x1<x0-r)
			{
				float t=y0+r;
				double xxx=Math.PI*r+x0-r-x1;
				xxx/=v0;
				double xxx2 = Math.PI*r+x0-r-x1+l0;
				xxx2/=v0;
				
				if(y1+l1-v1*xxx>=t && y1-v1*xxx2<=t)
					System.out.println("Yes"); 
				else
					System.out.println("No"); 
			}
			 else
			 {
				 System.out.println("Yes"); 
			 }
//			Random random=new Random(System.currentTimeMillis());
//			if(random.nextBoolean())
//				System.out.println("Yes");
//			else
//				System.out.println("No"); 
			//System.out.println("Yes"); 
				
		}

	}
}
