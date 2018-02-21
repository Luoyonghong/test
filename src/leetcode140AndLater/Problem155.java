package leetcode140AndLater;

import java.util.Stack;

import javax.swing.text.AbstractDocument.Content;

class MinStack
{

	Stack<Integer> content = new Stack<>();
	Stack<Integer> min = new Stack<>();
	/** initialize your data structure here. */
	public MinStack()
	{
		
	}

	public void push(int x)
	{
		content.push(x);
		if(min.isEmpty()||min.peek()>=x)
			min.push(x);
	}

	public void pop()
	{
		int p=content.pop();
		if(p==min.peek())
			min.pop();
	}

	public int top()
	{
		return content.peek();
	}

	public int getMin()
	{
        if(!min.isEmpty())
		    return min.peek();
        else
            return 0;
	}
}

public class Problem155
{

}
