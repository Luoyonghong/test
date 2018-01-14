package leetcode71AndLater;

import java.security.acl.LastOwnerException;
import java.util.Stack;

public class Problem85
{
	public int maximalRectangle(char[][] matrix)
	{
		int m=0,n=0;
		m=matrix.length;
		if(m>0)
			n=matrix[0].length;
		int[] heights=new int[n];
		for(int j=0;j<n;j++)
			if(matrix[0][j]=='1')
				heights[j]=1;
		int max=largestRectangleArea(heights);
		for(int i=1;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(matrix[i][j]=='1')
					heights[j]+=1;
				else
					heights[j]=0;
			}
			max=Math.max(max, largestRectangleArea(heights));
		}
		return max;
	}
	
	public int largestRectangleArea(int[] heights)
	{
		if(heights.length==0)
			return 0;
		Stack<Integer> s=new Stack<Integer>();
		int max=0;
		for(int i=0;i<heights.length;i++)
		{
			if(i==0)//当前堆栈为空，前面没有比i小的柱子了
				s.push(i);
			else
			{
				int t=-1;
				t=s.lastElement();
				if(heights[t]<=heights[i])//当前柱子比前一个还高，直接放入堆栈
				{
					s.push(i);
				}
				else//当前柱子比前一个要小,堆栈应该弹出所有比当前柱子还大的部分
				{
					s.pop();
					int f=-1;
					if(s.size()>0)
						f=s.lastElement();//当前堆栈倒数第二个位置
					while(heights[t]>heights[i])
					{
						//System.out.println(f);
						if((i-f-1)*heights[t]>max) 
						{
							max=(i-f-1)*heights[t];
							//System.out.println("new max: "+max); 
						}
						if(s.size()==0)//堆栈为空了都还没找到比当前柱子更小的值
							break;
						t=f;
						s.pop();
						if(s.size()>0)
							f=s.lastElement();
						else
							f=-1;
					}
					//当前所有编号小于f的柱子都比当前柱子小，且是f到i之间的最小的柱子，也就是说，面积等于heights[f]*(i-f+1),但此时不用算，最后才算
					//目前把f弹出来了，但其实不应该弹出来
					if(heights[t]<heights[i])//堆栈为空了都还没找到比当前柱子更小的值，判断一下当前f的柱子高度，大于i则不放回去
						s.push(t);
					s.push(i);
				}
			}
		}
		
		
		int d=s.pop();
		int min=heights[d];
		int f=-1;
		if(s.size()>0)
			f=s.lastElement();
		while(s.size()>0)
		{
			//System.out.println(f); 
			min=heights[f];//因为堆栈是从小到大的，所以遍历完毕后，min是最小的（最后一个值）
			if((heights.length-f-1)*heights[d]>max)
			{
				max=(heights.length-f-1)*heights[d];
				//System.out.println("new max: "+max); 
			}
			d=f;
			s.pop();
			if(s.size()>0)
				f=s.lastElement();
			else
				f=-1;
		}
		//System.out.println("min: "+min); 
		if(min*heights.length>max)
			max=min*heights.length;
		return max;
	}
	public static void main(String[] args)
	{
		Problem85 p=new Problem85();
		char[][] matrix={{'1', '0', '1', '0', '0'},
						{'1', '0', '1', '1', '1'},
						{'1', '1', '1', '1', '1'},
						{'1', '0', '0', '1', '0'}};
		System.out.println(p.maximalRectangle(matrix)); 
	}
}
