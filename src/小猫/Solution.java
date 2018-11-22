package 小猫;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
	static List<String> l =new ArrayList<>();
	static int len = 6;
	public static boolean help(int[][] num, int beginx, int beginy, int endx, int endy)
	{
		if(beginx<0||beginx>=len||beginy<0||beginy>=len||num[beginx][beginy]==1)
		{
			
			return false;
		}
		else
		{
			//System.out.println("x: "+beginx+" y: "+beginy); 
			num[beginx][beginy] = 1;
			if(beginx==endx&&beginy==endy&&islegal(num))
			{
				//System.out.println("x: "+beginx+" y: "+beginy); 
				for(int i =0;i<l.size();i++)
				{
					if(i%6==0)
						System.out.println();
					System.out.print(l.get(i)+" ");
				}
				System.out.println();
				return true;
			}
			
			l.add("↓");
			if(help(num, beginx+1, beginy, endx, endy))
				return true;
			l.remove(l.size()-1);
			l.add("↑");
			if( help(num, beginx-1, beginy, endx, endy))
				return true;
			l.remove(l.size()-1);
			l.add("→");
			if(help(num, beginx, beginy+1, endx, endy))
				return true;
			l.remove(l.size()-1);
			l.add("←");
			if( help(num, beginx, beginy-1, endx, endy))
				return true;
			l.remove(l.size()-1);
			num[beginx][beginy] = 0;
			return false;
		}
	}
	public static boolean islegal(int [][] nums)
	{
		for(int i=0;i<len;i++)
			for(int j=0;j<len;j++)
			{
				if(nums[i][j]==0)
					return false;
			}
		return true;
	}
	public static void main(String[] args)
	{
		int nums[][] = 
			{
					{0,0,0,0,0,0},
					{1,0,0,0,0,1},
					{0,0,0,1,0,0},
					{0,1,0,0,0,0},
					{0,0,0,0,0,0},
					{1,1,1,1,1,1}
					//{0,0,0,0,0,1}
			};
		help(nums,0,0,0,5);
	}

}
