package leetcode43AndLater;

public class Problem60
{
	public String getPermutation(int n, int k)
	{
		if(n==1)
			return "1";
//		if(k==1)
//		{
//			StringBuffer t=new StringBuffer();
//			for(int i=0;i<n;i++)
//				t.append(String.valueOf(i+1));
//			return t.toString();
//		}
		StringBuffer b=new StringBuffer();
		int nProduct=1;
		for(int i=1;i<n;i++)
			nProduct*=i;
		int index=n-1;
		k--;
		boolean [] userd=new boolean[n];
		do
		{
			int t=k/nProduct;
			int count=0,i=0;
			if(count==t)
			{
				while(userd[i])
					i++;
				//i--;
			}
			while(count<t)
			{
				if(!userd[i])
					count++;
				i++;
				if(count==t)
				{
					while(userd[i])
						i++;
					//i--;
				}
			}
			userd[i]=true;
			b.append(String.valueOf(i+1)); 
			System.out.println("k is : " +k+"; i is : "+i+"; index is :"+index+";"+" nProduct is : "+nProduct+";"); 
			
			k%=nProduct;
			
			nProduct/=index;
			index--;
			if(index==0)
				break;
		}
		while(index>0);
		
		
		
		for(int i=0;i<n;i++)
			if(!userd[i])
				b.append(String.valueOf(i+1));
		return b.toString();
		
	}

	public static void main(String[] args)
	{
		Problem60 p=new Problem60(); 
		System.out.println(p.getPermutation(4, 1)); 
	}
}
