package leetcode200AndLater;

public class Problem200
{
	public int numIslands(char[][] grid)
	{
		int r[]=findOne(grid);
		int count=0;
		while(r[0]>=0&&r[1]>=0)
		{
			oneIsland(grid, r[0], r[1]);
			count++;
			r=findOne(grid);
		}
		return count;
	}
	
	public void oneIsland(char[][] map, int line, int column)
	{
		if(line<map.length&&column<map[0].length&&line>=0&&column>=0&&map[line][column]=='1')
		{
			map[line][column]='0';
			oneIsland(map, line+1, column);
			oneIsland(map, line, column+1);
			oneIsland(map, line-1, column);
			oneIsland(map, line, column-1);
		}
		return;
	}
	
	
	public int[] findOne(char[][] grid)
	{
		int r[]=new int[2];
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++)
			{
				if(grid[i][j]=='1')
				{
					r[0]=i;r[1]=j;
					return r;
				}
			}
		r[0]=-1;
		r[1]=-1;
		return r;
	}
}
