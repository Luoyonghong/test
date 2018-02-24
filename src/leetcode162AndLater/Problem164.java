package leetcode162AndLater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem164
{
	public int maximumGap(int[] nums)
	{
		int num[]=nums;
		if (num == null || num.length < 2)
	        return 0;
	    // get the max and min value of the array
	    int min = num[0];
	    int max = num[0];
	    for (int i:num) {
	        min = Math.min(min, i);
	        max = Math.max(max, i);
	    }
	    // the minimum possibale gap, ceiling of the integer division
	    int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
	    int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
	    int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
	    Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
	    Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
	    // put numbers into buckets
	    for (int i:num) {
	        if (i == min || i == max)
	            continue;
	        int idx = (i - min) / gap; // index of the right position in the buckets
	        bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
	        bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
	    }
	    // scan the buckets for the max gap
	    int maxGap = Integer.MIN_VALUE;
	    int previous = min;
	    for (int i = 0; i < num.length - 1; i++) {
	        if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
	            // empty bucket
	            continue;
	        // min value minus the previous value is the current gap
	        maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
	        // update previous bucket value
	        previous = bucketsMAX[i];
	    }
	    maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
	    return maxGap;
		
	}
	public static void main(String[] args)
	{
		Problem164 p=new Problem164();
		int nums[]={3,6,9,1};
		System.out.println(p.maximumGap(nums));
	}
}
