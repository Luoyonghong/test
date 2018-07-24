package 百度;
import java.util.Scanner;
import java.util.Stack;
public class 最大字典子序列{

public static void  main(String[] args)
{
    //单调递减栈
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    Stack<Character> stack=new Stack<Character>();
    
    for(int i=0;i<s.length();i++)
    {
        while(!stack.isEmpty()&&s.charAt(i)>stack.peek())
        {
            stack.pop();
        }
        
        if(stack.isEmpty())
        {
            stack.push(s.charAt(i));
            continue;
        }
        if(!stack.isEmpty()&&s.charAt(i)<=stack.peek())
        {
            stack.push(s.charAt(i));
            continue;
        }
    }
    while(!stack.isEmpty())
    {
        System.out.print(stack.pop());
    }
    System.out.println();
}
}