package leetcode;


/*
int longestValidParentheses(string s) {  
    stack<int> paranStack;  
       int maxLength=0;  
       int lastValidIndx=0;  
       for (int indx=0; indx<s.length(); indx++) {  
           if (s[indx]=='(') //遇到左括号，直接存入。  
               paranStack.push(indx);  
           else { //遇到右括号，分情况讨论  
               if (paranStack.empty()) //如果此时栈里左括号已经被消耗完了，没有额外的左括号用来配对当前的右括号了，那么当前的右括号就被单出来了，表明当前子串可以结束了，此时的右括号也成为了下一个group的分界点，此时右括号下标为index，所以下一个group的起始点为index+1,相当于skip掉当前的右括号。  
                   lastValidIndx=indx+1;  
               else { //如果此时栈不空，可能有两种情况，1）栈正好剩下1个左括号和当前右括号配对 2)栈剩下不止1个左括号，  
                   paranStack.pop();  
                   if (paranStack.empty())  //栈pop()之前正好剩下1个左括号，pop()之后，栈空了，此时group长度为indx-lastValidIndx  
                       maxLength=max(maxLength, indx-lastValidIndx+1);  
                   else  //栈有pop()之前剩下不止1个左括号，此时额外多出的左括号使得新的group形成。如()(()())中index=4时，stack中有2个左括号  
                       maxLength=max(maxLength, indx-paranStack.top());  
               }  
           }  
       }  
       return maxLength;  
   }  

*/

/*
 * dp[i]表示以当前位置为终点的最长长度，则只能在）处更新，
如果s[i-1-dp[i-1]]=='('，则说明当前位置可以和i-1-dp[i-1]位置匹配，dp[i]=dp[i-1]+2;
然后还要加上匹配位置之前的最长长度dp[i]+=dp[i-dp[i]];
class Solution {  
public:  
    int longestValidParentheses(string s)   
    {  
        int result=0;  
        s=')'+s;  
        vector<int> dp(s.length(),0);  
        for(int i=1;i<s.length();i++)  
        {  
            if(s[i]==')')  
            {  
                if(s[i-1-dp[i-1]]=='(') dp[i]=dp[i-1]+2;  
                dp[i]+=dp[i-dp[i]];  
            }  
            result=max(result,dp[i]);  
        }  
        return result;  
    }  
};  
 * 
 */




public class Problem32
{
	 int result=0;
	 int [][] r;
	public  int longestValidParentheses(String s)
	{
		r=new int[s.length()][s.length()];
		
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i)=='('&&s.charAt(i+1)==')')
			{
				//result=2;
				fun(s,i,i+1);
				
			}
		}
		return result;
	}
	
	public  void fun(String s, int left, int right)
	{
		//int r1=0,r2=0,r3=0;
		//System.out.println(s.substring(0,left)+"/"+s.substring(left,right+1)+"/"+s.substring(right+1,s.length()));   
		if(right-left+1>result)
			result=right-left+1;
		//int tempmax=0;
		for(int i=0;i<left-1;i++)
		{
			if(r[i][left-1]>0)
			{
				r[i][right]=right-left+1+r[i][left-1];
				fun(s,i,right);
			}
		}
		
		
		if(left-2>=0)
		{
			if(r[left-2][right]>0)
			{
				if(right-left+3>result)
					result=right-left+3;
				fun(s,left-2,right);
			}
			else
			{
				if(s.charAt(left-2)=='('&&s.charAt(left-1)==')')
				{
					r[left-2][right]=right-left+3;
					if(right-left+3>result)
						result=right-left+3;
					fun(s,left-2,right);
				}
			}
		}
		if(left-1>=0&&right+1<=s.length()-1)
		{
			if(r[left-1][right+1]>0)
			{
				if(right-left+3>result)
					result=right-left+3;
				fun(s,left-1,right+1);
			}
			else
			{
				if(s.charAt(left-1)=='('&&s.charAt(right+1)==')')
				{
					r[left-1][right+1]=right-left+3;
					if(right-left+3>result)
						result=right-left+3;
					fun(s,left-1,right+1);
				}
			}
		}
		if(right+2<=s.length()-1)
		{
			if(r[left][right+2]>0)
			{
				if(right-left+3>result)
					result=right-left+3;
				fun(s,left,right+2);
			}
			else
			{
				if(s.charAt(right+1)=='('&&s.charAt(right+2)==')')
				{
					r[left][right+2]=right-left+3;
					if(right-left+3>result)
						result=right-left+3;
					fun(s,left,right+2);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		Problem32 p=new Problem32();
		System.out.println(p.longestValidParentheses(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
	}
}
