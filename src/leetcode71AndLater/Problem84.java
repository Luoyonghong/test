package leetcode71AndLater;

import java.util.Stack;

public class Problem84
{

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
							System.out.println("new max: "+max); 
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
		for (Integer integer : s)
		{
			System.out.println(integer); 
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
				System.out.println("new max: "+max); 
			}
			d=f;
			s.pop();
			if(s.size()>0)
				f=s.lastElement();
			else
				f=-1;
		}
		System.out.println("min: "+min); 
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
		int heights[]=
		//	{4,1,0,3,2,5};
			{1};
		System.out.println(p.largestRectangleArea(heights));
	}
}
