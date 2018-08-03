package leetcode200AndLater;

public class Problem275
{
	public int hIndex(int[] citations)
	{
		int begin = 0, end =citations.length-1,length=citations.length ,middle = 0;
	        if(length==0)
	            return 0;
			while(begin <=end)
			{
				
				middle =(begin+end)/2;
				//System.out.println("begin: "+begin+" end: "+end+" middne: "+middle); 
				if(citations[middle]>=length-middle)
					end=middle-1;
				else
					begin=middle+1;
			}
			System.out.println("begin: "+begin+" end: "+end+" middne: "+middle); 
			middle =(begin+end)/2;
			return length-begin;
	}
	public int erfenchazhao(int nums[],int k)
	{
		int begin =0;
		int end = nums.length-1;
		while(begin<=end)
		{
			int mid=(begin+end)/2;
			if(nums[mid]>k)
				end = mid-1;
			if(nums[mid]<k)
				begin = mid+1;
			if(nums[mid]==k)
				return mid;
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		Problem275 p =new Problem275();
		int c[] = {1};
		System.out.println(p.hIndex(c)); 
		
		int nums[]={1,3,5,6,7};
		System.out.println(p.erfenchazhao(nums, 3));  
	}
}
