package 商汤;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class 房间
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int to[]=new int[n+1];
		int score[]=new int[n+1];
		int max=Integer.MIN_VALUE;
		//System.out.println(n); 
		for(int i=1;i<=n;i++)
		{
			score[i]=sc.nextInt();
			to[i]=sc.nextInt();
		}
		
		int count=0;
		Random random=new Random();
		while(count<10000)
		{
			count++;
			int i=random.nextInt(n);
			if(i>n)
				break;
			boolean used[]=new boolean[n+1];
			List<Integer> path=new ArrayList<>();
			int j=i;
			while(!used[j])
			{
				path.add(score[j]);
				used[j]=true;
				j=to[j];
			}
			int maxsum=path.get(0);
			int nowsum=path.get(0);
			for( j=1;j<path.size();j++)
			{
				if(nowsum+path.get(j)>path.get(j))
					nowsum+=path.get(j);
				if(nowsum>maxsum)
					maxsum=nowsum;
			}
			if(maxsum>max)
				max=maxsum;
		}
		for(int i=n;i>n-10000;i--)
		{
			if(i<1)
				break;
			boolean used[]=new boolean[n+1];
			List<Integer> path=new ArrayList<>();
			int j=i;
			while(!used[j])
			{
				path.add(score[j]);
				used[j]=true;
				j=to[j];
			}
			int maxsum=path.get(0);
			int nowsum=path.get(0);
			for( j=1;j<path.size();j++)
			{
				if(nowsum+path.get(j)>path.get(j))
					nowsum+=path.get(j);
				if(nowsum>maxsum)
					maxsum=nowsum;
			}
			if(maxsum>max)
				max=maxsum;
		}
		System.out.println(max); 
	}
}
