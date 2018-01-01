package leetcode43AndLater;

public class Problem65
{

	public boolean check(String tmp,boolean point){
        //为空的情况肯定失败
        if(tmp.length()<1)
            return false;
        char chars[]=tmp.toCharArray();
        int i=0;
        boolean num=false;
        //是否存在符号，十号的话要先跳过，且只能有一个。。如果符号过后就没有数字了，那么也是非法的
        if(chars[i]=='+' || chars[i]=='-')
            i++;
        if(i==chars.length)
            return false;
        //整数位置的数据
        while(i<chars.length && chars[i]<='9' && chars[i]>='0'){
            i++;
            num=true;
        }
        //如果不允许出现小数点，那么这个过程就必须匹配结束，不然就是失败
        if(i<chars.length && point==false)
            return false;
        //允许小数点，下一位必须为小数点
        if(i<chars.length && chars[i]=='.'){//小数点后，必须遇到e或结束
            boolean num2=false;
            i++;
            while(i<chars.length && chars[i]<='9' && chars[i]>='0'){
                i++;
                num2=true;
            }
            //小数点前要有数字，小数点后也要有数字,至少成立一个
            if(num2==false && num==false) 
                return false;
        }
        return i==chars.length;
    }
    public boolean isNumber(String s) {
        //去除空格
        while(s.startsWith(" "))
            s=s.substring(1);
        while(s.endsWith(" "))
            s=s.substring(0,s.length()-1);
        if(s.length()<1)
            return false;
        //e的后面不允许小数点，前面允许 所以如果有e就拆分运算
        if(s.indexOf('e')==-1)
            return check(s,true);
        else return check(s.substring(0,s.indexOf('e')),true) &&check(s.substring(s.indexOf('e')+1),false) ;

    }

	public static void main(String[] args) 
	{
		System.out.println(Double.parseDouble("45E3.")); 
	}
}
