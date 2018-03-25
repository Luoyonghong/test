package 头条;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 问题2
{
	int max_value=10000;
	int min_value=10000;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
				
		System.out.println(findMax(n)); 
				        
				
	}
	public static int  findMax(int a)
	{
		   
		    if(a==1)
		        return 0;
		    List<Integer> arr=findbase(a);
		    if(arr.size()==0)
		        return a-1;
		    
		    List<Integer> new_arr=new ArrayList<>();
		    int min=Integer.MAX_VALUE;
		    for( int i : arr)
		    {
			    int t=findMax(i)+a/i-1;
			    if(t<min)
				    min=t;
		    }
		    return min;
		
	}
	
	public  static List<Integer>  findbase(int a)
	{
		    List<Integer> arr=new ArrayList<>();
		    for(int i=2;i<a;i++)
		    {
			    if(a%i==0)
				    arr.add(i);
		    }
		    return arr;
	}
}
