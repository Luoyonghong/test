package 头条;

import java.util.Scanner;

public class utf8校验
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i]=sc.nextInt();
		}
		if(n==1)
		{
			if(nums[0] < 0b0111111 || nums[0] > 0b00000000)
			{
				System.out.println(1);
				return;
			}
		}
		else
		{
			for (int i = 0; i < n; i++)
			{
				if(i==0)
				{
//					int value=nums[0]&0X0FF;
//					int j=0;
//					while(j<n)
//					{
//						if(value>>(8-j-1)!=1)
//						{
//							System.out.println(0);
//							System.out.println(j); 
//							return;
//						}
//						j++;
//					}
//					if(value>>(8-2-1)!=0)
//					{
//						System.out.println(0);
//						return;
//					}
					if(n==2)
					{
						if(nums[0] > 0b11011111 || nums[0] < 0b11000000)
						{
							System.out.println(0);
							return;
						}
					}
					else if(n==3)
					{
						if(nums[0] > 0b11101111 || nums[0] < 0b11100000)
						{
							System.out.println(0);
							return;
						}
					}
					else if(n==4)
					{
						if(nums[0] > 0b11110111 || nums[0] < 0b11110000)
						{
							System.out.println(0);
							return;
						}
					}
					
				}
				else
				{
					if(nums[i] > 0b10111111 || nums[i] < 0b10000000)
					{
						System.out.println(0);
						return;
					}
					
				}
			}
		}
		System.out.println(1);
	}
}


/*
 * 
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i]=sc.nextInt();
		}
		for (int i = 0; i < n; i++)
		{
			if (nums[i] < 0b10000000)
			{
				continue;
			} 
			else
			{
				int cnt = 0, val = nums[i];
				for (int j = 7; j >= 1; j--)
				{
					if (val >= Math.pow(2, j))
						cnt++;
					else
						break;
					val -= Math.pow(2, j);
				}
				if (cnt == 1)
                {
					System.out.println(0);
                    return;
                }
				for (int j = i + 1; j < i + cnt; ++j)
				{
					if (nums[j] > 0b10111111 || nums[j] < 0b10000000)
                    {
						System.out.println(0);
                        return;
                    }
				}
				i += cnt - 1;
			}
		}
		System.out.println(1);
	}
}
 * 
 * 
 */
