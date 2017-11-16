package leetcode;

public class Problem6 {
	
	public static String convert(String s, int numRows) {
		if(s.length()<2||numRows==1||s.length()<numRows)
			return s;
		int length=s.length();
		int firstLineLength=0;
		while(2*firstLineLength*(numRows-1)<length)
		{
			firstLineLength++;
		}
		//firstLineLength--;
		char[] res=new char[length];
		int[] rowLength=new int[numRows];
		rowLength[0]=firstLineLength;
		System.out.println(firstLineLength); 
		res[0]=s.charAt(0);
		for(int j=1;j<firstLineLength;j++)
			res[j]=s.charAt(2*j*(numRows-1));
		System.out.println(String.valueOf(res));
		for(int i=1;i<numRows-1;i++)//从第二行开始 到倒数第二行
		{
			int base=0;
			for(int m=0;m<i;m++)
			{
				base+=rowLength[m];
			}
			System.out.println(base); 
			int j=0;//第i行的第j个
			res[base+j]=s.charAt(i);
			j=1;
			
			while(true)
			{
				if(((j+1)/2)*2*(numRows-1)-i>=length||((j)/2)*2*(numRows-1)+i>=length)
					break;
				System.out.println(j); 
				if((j+1)%2==0)
					res[j+base]=s.charAt(((j+1)/2)*2*(numRows-1)-i);
				else
					res[j+base]=s.charAt(((j)/2)*2*(numRows-1)+i);
				j++;
			}
			j--;
			System.out.println();
			System.out.println(j); 
			rowLength[i]=j+1;
			System.out.println("dierghang  "+String.valueOf(res)); 
		}
		
		
		int base=0;
		for(int m=0;m<numRows;m++)
		{
			base+=rowLength[m];
		}
		res[base]=s.charAt(numRows-1);
		int j=1;
		System.out.println(String.valueOf(res)); 
		System.out.println(base); 
		while(j+base<length)
		{
			//System.out.println(j); 
			res[j+base]=s.charAt(2*j*(numRows-1)+numRows-1);
			
			j++;
		}
		
		
		return String.valueOf(res); 
	}
	public static void main(String[] args) {
		
		System.out.println(convert("ABCD",3)); 
	}
}
