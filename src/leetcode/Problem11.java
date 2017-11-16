package leetcode;

public class Problem11
{
	public static int maxArea(int[] height)
	{
		int i, j, lh, rh, area, tmp, len = height.length;  
		  
        lh = height[0];  
        rh = height[len - 1];  
        area = 0;  
        i = 0;  
        j = len - 1;  
          
        while (i < j) {  
            tmp = Math.min(lh, rh) * (j - i);  
              
            if (tmp > area) {  
                area = tmp;  
            }  
              
            if (lh < rh) {  
                while (i < j && height[i] <= lh) {  
                    i ++;  
                }  
                if (i < j) {  
                    lh = height[i];  
                }  
            } else {  
                while (i < j && height[j] <= rh) {  
                    j --;  
                }  
                if (i < j) {  
                    rh = height[j];  
                }  
            }  
        }  
  
        return area;  
    
	}
	public static void main(String[] args)
	{
		int a[]={1,2,1};
		System.out.println(maxArea(a) ); 
	}
}
