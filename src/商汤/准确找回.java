package 商汤;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 准确找回
{
	static class my
	{
		int lable;
		float score;
		public my(int x, float y)
		{
			lable=x;
			score=y;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		int[] lable=new int[n];
		float score[]=new float[n];
		my[] samples=new my[n];
		for(int i=0;i<n;i++)
		{
			lable[i]=sc.nextInt();
			score[i]=sc.nextFloat();
			my t=new my(lable[i],score[i]);
			samples[i]=t;
		}
		//找回30，40，90的时候的准确率
		//召回：tp/(tp+fn)
		//准确: tp/(tp+fp)
		Arrays.sort(samples,new Comparator<my>()
		{

			@Override
			public int compare(my o1, my o2)
			{
				// TODO Auto-generated method stub
				if(o1.score>o2.score)
					return 1;
				else if(o1.score<o2.score)
					return -1;
				else
					return 0;
				//return o1.score-o2.score;
			}
		});
		int result[]=new int[7];
		for(int i=1;i<n;i++)
		{
			float thres=samples[i].score;
			float tp,fp,tn,fn;
			int tpcount=0;
			int fpcount=0;
			//阈值的时候包括i
			for(int j=i;j<n;j++)
			{
				if(samples[j].lable==1)
					tpcount++;
				else
					fpcount++;
			}
			tp=(float)tpcount/(n);
			fp=(float)fpcount/(n);
			
			int tncount=0,fncount=0;
			for(int j=0;j<i;j++)
			{
				if(samples[j].lable==0)
					tncount++;
				else
					fncount++;
			}
			tn=(float)tncount/n;
			fn=(float)fncount/n;
			
			float r=tp/(tp+fn);
			float p=tp/(tp+fp);
			//System.out.println("r: "+r+" p: "+p); 
			if(Math.round(r*100)<32&&Math.round(r*100)>28)
			{
				result[0]=Math.round(p*100);
			}
			if(Math.round(r*100)<42&&Math.round(r*100)>38)
			{
				result[1]=Math.round(p*100);
			}
			if(Math.round(r*100)<52&&Math.round(r*100)>48)
			{
				result[2]=Math.round(p*100);
			}
			if(Math.round(r*100)<62&&Math.round(r*100)>58)
			{
				result[3]=Math.round(p*100);
			}
			if(Math.round(r*100)<72&&Math.round(r*100)>68)
			{
				result[4]=Math.round(p*100);
			}
			if(Math.round(r*100)<82&&Math.round(r*100)>78)
			{
				result[5]=Math.round(p*100);
			}
			if(Math.round(r*100)<92&&Math.round(r*100)>88)
			{
				result[6]=Math.round(p*100);
			}
		}
		for(int i=0;i<7;i++)
		{
			System.out.println(result[i]); 
		}
	}
}
