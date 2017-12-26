package leetcode43AndLater;

public class Problem50
{
	public double myPow(double x, int n) {
		if(n==0)
			return 1;
		else if(n>0)
		{
			double v=myPow(x, n/2);
			if(n%2==0)
				return v*v;
			else
				return v*v*x;
		}
		else
			return 1/myPow(x, -(n+1))/x;
		//return 0;
//		if (n < 0) {
//            return 1 / power(x, -n);
//        } else {
//            return power(x, n);
//        }
    }
	public double power(double x, int n) {
        if (n == 0)
            return 1;
 
        double v = power(x, n / 2);
 
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
	public static void main(String[] args)
	{
		Problem50 p=new Problem50();
		System.out.println(p.myPow(1.00000,-2147483648));
		System.out.println(-3%2); 
	}
}
