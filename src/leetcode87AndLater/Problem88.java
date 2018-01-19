package leetcode87AndLater;

public class Problem88
{
	public void merge(int[] nums1, int m, int[] nums2, int n)
	{
		if(n==0)
			return ;
		if(m==0)
		{
			for(int i=0;i<n;i++)
				nums1[i]=nums2[i];
			return ;
		}
		int[] t=new int[m];
		for(int i=0;i<m;i++)
			t[i]=nums1[i];
		int j=0;
		int index1=0,index2=0;
		boolean n1Over=false,n2Over=false;
		while(index1<m||index2<n)
		{
			
			if(n1Over)
			{
				nums1[j]=nums2[index2];
				index2++;
				j++;
				continue;
			}
			if(n2Over)
			{
				nums1[j]=t[index1];
				index1++;
				j++;
				continue;
			}
			if(t[index1]<nums2[index2])
			{
				nums1[j]=t[index1];
				j++;
				index1++;
				if(index1==m)
					n1Over=true;
				continue;
			}
			else
			{
				nums1[j]=nums2[index2];
				j++;
				index2++;
				if(index2==n)
					n2Over=true;
				continue;
			}
			
		}

	}
	public static void main(String[] args)
	{
		Problem88 p=new Problem88();
		p.merge(new int[]{0}, 0, new int[]{1}, 1); 
	}
}
