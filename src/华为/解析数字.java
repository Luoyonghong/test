package 华为;

import java.util.Scanner;

public class 解析数字
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int nBinary=sc.nextInt();
		String [] binarys=new String[nBinary];
		for(int i=0;i<nBinary;i++)
			binarys[i]=sc.next();
		int totalNum=sc.nextInt();
		int[] numSizes=new int[totalNum];
		for(int i=0;i<totalNum;i++)
			numSizes[i]=sc.nextInt();
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<binarys.length;i++)
		{
			String t=Integer.toBinaryString(Integer.parseInt(binarys[i].substring(2), 16));
			while(t.length()<8)
				t="0"+t;
			sb.append(t);
		}
		//System.out.println(sb.toString());  
		int sum=0;
		for(int i=0;i<totalNum;i++)
		{
			sum+=numSizes[i];
			//System.out.println(sum); 
			String t=sb.substring(sum-numSizes[i],sum);
			System.out.println(Integer.valueOf(t, 2));  
			//nowindex+=numSizes[i]+1;
		}
		
		//System.out.println(Integer.valueOf("00101", 2));  
	}
}
