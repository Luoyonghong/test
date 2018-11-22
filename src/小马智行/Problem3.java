package 小马智行;

public class Problem3
{

	/*
	 * guess(int m)
	 * -1 小于
	 * 0 等于
	 * 1 大于
	 * 
	 */
	
	public int f()
	{
		int t = 1; 
		while(guess(t)==-1)
		{
			t=t*2;
		}
		int begin = 0 ;
		int end = t;
		while(begin<=end)
		{
			int middle = (begin+end)/2;
			int guess_result = guess(middle);
			if(guess_result==1)
				begin = middle+1;
			else if(guess_result == -1)
				end = middle - 1;
			else
				return middle;
		}
		return begin;
	}
}
