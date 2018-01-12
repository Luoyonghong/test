package leetcode71AndLater;

import java.util.Stack;

public class Problem84
{

	public int largestRectangleArea(int[] heights)
	{
		
		Stack<Integer> s=new Stack<Integer>();
		int max=0;
		for(int i=0;i<heights.length;i++)
		{
			if(i==0)//当前堆栈为空，前面没有比i小的柱子了
				s.push(i);
			else
			{
				int t=s.pop();
				if(heights[t]<=heights[i])//当前柱子比前一个还高，直接放入堆栈
				{
					s.push(t);
					s.push(i);
				}
				else//当前柱子比前一个要小,堆栈应该弹出所有比当前柱子还大的部分
				{
					int f=t;
					int firstIndex=f;//比当前柱子大的第一个柱子的编号
					while(heights[f]>heights[i])
					{
						//System.out.println(f);
						if((firstIndex-s.get(s.size()-2)+1)*heights[f]>max) 
							max=(firstIndex-s.get(s.size()-2)+1)*heights[f];
//						if((i-f+1)*heights[i]>max)
//							max=(i-f+1)*heights[i];//也要计算一下i到f之间的面积
						if(s.size()==0)//堆栈为空了都还没找到比当前柱子更小的值
							break;
						f=s.pop();
					}
					//当前所有编号小于f的柱子都比当前柱子小，且是f到i之间的最小的柱子，也就是说，面积等于heights[f]*(i-f+1),但此时不用算，最后才算
					//目前把f弹出来了，但其实不应该弹出来
					if(heights[f]<heights[i])//堆栈为空了都还没找到比当前柱子更小的值，判断一下当前f的柱子高度，大于i则不放回去
						s.push(f);
					s.push(i);
				}
			}
		}
		
		int min=0,d=0;
		while(s.size()>0)
		{
			d=s.pop();
			//System.out.println(d); 
			min=heights[d];//因为堆栈是从小到大的，所以遍历完毕后，min是最小的（最后一个值）
			if((heights.length-s.get(s.size()-2)+1)*heights[d]>max)
				max=(heights.length-s.get(s.size()-2)+1)*heights[d];
		}
		if(min*heights.length>max)
			max=min*heights.length;
		return max;
	}
	
	int largestRectangleArea2(int height[]) 
    {
        int res=0;
        Stack<Integer> stk=new Stack<Integer>(); 
        int heights[] =new int[height.length+1];
        for (int i=0;i<height.length;i++)
		{
			heights[i]=height[i];
		}
        heights[height.length]=0;
        for(int i=0;i<heights.length;++i)
        {
        	System.out.print("now stack :");
        	for (int j : stk)
			{
				System.out.print(j+" ");
			}
        	System.out.println(); 
            if(stk.empty()||heights[stk.lastElement()]<=heights[i])
            {
                stk.push(i);
                System.out.println("push i"); 
            }
            else
            {
                int temp=stk.lastElement();
                stk.pop();
                res=Math.max(res,heights[temp]*(stk.empty()?i:(i-stk.lastElement()-1)));//为什么不用i-temp.index?
                System.out.println("pop "+temp+", new res: "+res);                      //因为堆栈中两个元素不一定挨着，只能用更前面的一个+1  
                --i;
            }
        }
        return res;    
    }
	
	
	public static void main(String[] args)
	{
		Problem84 p=new Problem84();
		int heights[]={4,1,0,3,2,5};
		System.out.println(p.largestRectangleArea2(heights));
	}
}
