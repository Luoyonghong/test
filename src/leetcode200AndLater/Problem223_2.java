package leetcode200AndLater;

public class Problem223_2
{
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,int H)
	{
		int sum = (C - A) * (D - B) + (H - F) * (G - E);
        if (E >= C || F >= D || B >= H || A >= G) return sum;
        return sum - ((Math.min(G, C) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F)));
	}

}
