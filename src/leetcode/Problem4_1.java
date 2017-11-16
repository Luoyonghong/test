package leetcode;

public class Problem4_1 {

	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 int[] a=new int[nums1.length+nums2.length];
		 int n1index=0,n2index=0;
		 for(int i=0;i<a.length;i++)
		 {
			if(n1index>=nums1.length)
			{
				a[i]=nums2[n2index];
				n2index++;
				continue;
			}
			if(n2index>=nums2.length)
			{
				a[i]=nums1[n1index];
				n1index++;
				continue;
			}
			if(nums1[n1index]<nums2[n2index])
			{
				a[i]=nums1[n1index];
				n1index++;
				continue;
			}
			else
			{
				a[i]=nums2[n2index];
				n2index++;
				continue;
			}
		 }
		 if(a.length%2==0)
			 return (a[a.length/2-1]+a[a.length/2])/2.0;
		 else
			 return a[a.length/2];
	 }
}
