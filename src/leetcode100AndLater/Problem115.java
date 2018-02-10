package leetcode100AndLater;

public class Problem115 {
//s rabbbit
//t rabbit
	public int numDistinct(String s, String t) {
		if(t.length()>s.length())
			return 0;
		if(s.length()==0&&t.length()==0)
			return 1;
		if(s.length()==0||t.length()==0)
			return 0;
		 int r[][]=new int[s.length()+1][t.length()+1];
		//以s[i-1]结尾的子串,与t[j-1]结尾的字符串（0~j）能一致的个数
		 for(int i=0;i<=s.length();i++)
		 {
					r[i][0]=1;
		 }
		 
		 
		 
		 for(int i=1;i<=s.length();i++)
			 for(int j=1;j<=t.length();j++)
			 {
				 if(s.charAt(i-1)==t.charAt(j-1))//当前s[i-1]!=t[j-1] r[i][j]=删除s[i]的结果加上不删除s[i]的结果
				 {
					
						 r[i][j]=r[i-1][j-1]+r[i-1][j];
						 if(i==j&&r[i][j]>0)
							 r[i][j]=1;
					
				 }
				 if(s.charAt(i-1)!=t.charAt(j-1))
				 {
					
						 r[i][j]=r[i-1][j];
				 }
			 }
//		 for(int i=0;i<t.length();i++)
//			 System.out.print(t.charAt(i)+" ");
//		 System.out.println();
//		 for(int i=0;i<=s.length();i++)
//		 {
//			 for(int j=0;j<=t.length();j++)
//				 System.out.print(r[i][j]+" ");
//			 System.out.println(s.charAt(i)); 
//		 }
		 return r[s.length()][t.length()];
	}
	
	public static void main(String[] args) {
		Problem115 p=new Problem115();
//		String s="rabbbit";
//		String t="rabbit";
//		String s="eee";
//		String t="ee";
		String s="aabb";
		String t="ab";
		System.out.println(p.numDistinct(s, t));
	}
	
}
