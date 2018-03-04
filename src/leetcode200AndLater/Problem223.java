package leetcode200AndLater;

public class Problem223
{
	public int countDigitOne(int n)
	{
		//512
		if(n<1)
			return 0;
//		int count = 0;
//	    int base = 1;
//	    int round = n;
//	    while(round>0){
//	        int weight = round%10;
//	        round/=10;
//	        count += round*base;
//	        if(weight==1)
//	            count+=(n%base)+1;
//	        else if(weight>1)
//	            count+=base;
//	        base*=10;
//	    }
//	    return count;
		
		
		int count=0;
		int weight=0;
		int former=0;
		int base=1;
		int backn=n;
		while(n>0)
		{
			weight=n%10;//weight 当前处理的位的值
			n=n/10;
			count+=n*base;
			if(weight>1)
				count+=base;
			if(weight==1)
			{
				former=backn%base;
				count+=former+1;
			}
			base*=10;
			
		}
		return count;
	}
	public static void main(String[] args)
	{
		Problem223 p=new Problem223();
		System.out.println(p.countDigitOne(13));  
	}
	
	
}
