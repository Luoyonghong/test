
public class 排列组合
{

	int c[][] =new int[105][105];
	int mod=1000007;
	/*
	 * i 是下面的 c_i ^j
	 */
	public void init()   //计算组合数
	{
		c[0][0] = 1;
		for(int i = 1;i <= 100;i++)
		{
			c[i][0] = 1;
			for(int j = 1;j <= 100;j++)
			c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
		}
	}
	
}
