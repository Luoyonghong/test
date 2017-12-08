package leetcode;

public class Problem29 {

	public static int divide(int dividend,int divisor){  
        int tag =1;//整数  
        long a = dividend;  
        long b = divisor;  
        if(divisor == 1) return dividend;  
           if(divisor == -1) {  
               if(dividend==Integer.MIN_VALUE){  
                   return Integer.MAX_VALUE;  
               }  
             return -dividend;  
               }  
        if(dividend>=0&&divisor>=0||dividend<=0&&divisor<=0){  
            tag=1;  
        }else{  
            tag=-1;  
        }  
         a = Math.abs((long)a);  
         b = Math.abs((long)b);  
       if(a<b){  
           return 0;  
       }  
       int re=0;  
       while(a>=b){  
            int temp =1;  
            long bt= b;  
            while(a>=bt<<1){  
                bt=bt<<1;  
                temp = temp<<1;  
            }  
           re+=temp;  
           a-=bt;  
       }  
         
        return re*tag;  
    }  
	public static void main(String[] args) {
		System.out.println(divide(5,2)); 
	}
}
