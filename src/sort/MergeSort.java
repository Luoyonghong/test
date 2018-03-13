package sort;

public class MergeSort
{
	public static void merge(int [] a, int start, int end )
	{
		if(start<end)
		{
			int mid=(start+end)/2;
			merge(a,start,mid);
			merge(a, mid+1, end); 
			sort(a, start, end);
		}
	}
	public static void sort(int[] a,int start, int end)
	{
		int i=start,mid=(start+end)/2,j=mid+1,k=0;
		int t[]=new int[end-start+1];
		while(i<=mid&&j<=end)
		{
			if(a[i]<a[j])
			{
				t[k]=a[i];
				k++;
				i++;
			}
			else
			{
				t[k]=a[j];
				k++;
				j++;
			}
		}
		while(i<=mid)
		{
			t[k]=a[i];
			k++;
			i++;
		}
		while(j<=end)
		{
			t[k]=a[j];
			k++;
			j++;
		}
		for(int m=0;m<k;m++)
		{
			a[start+m]=t[m];
		}
		
	}
	public static void main(String[] args)
	{
		int[] a={1,2,5,3,4,2,1};
		int t[]=new int[a.length];
		merge(a,0,a.length-1); 
		for (int i : a)
		{
			System.out.print(i+" "); 
		}
		float f=3.4F;
	}
}
