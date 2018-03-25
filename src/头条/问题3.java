package 头条;

import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class 问题3{
	public static void main(String []args) throws ScriptException{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] str = new String[n];
		for(int i=0; i<n; i++){
			str[i] = input.next();
			int result = (int) new ScriptEngineManager().getEngineByName("js").eval(str[i]);
			str[i] = String.valueOf(result);
		}
		for( int k=0; k<n; k++){
			int len = str[k].length();
			for( int i=0; i<5; i++){
				for( int j=0; j<len; j++){
					char tmp = str[k].charAt(j);
					switch (tmp){
						case '0':
							if( i==0 || i==4){
								System.out.print("66666");
							}
							else{
								System.out.print("6...6");
							}
							break;
						case '1':
							System.out.print("....6");
							break;
						case '2':
							if( i==1 ){
								System.out.print("....6");
							}
							else if( i==3 ){
								System.out.print("6....");
							}
							else{
								System.out.print("66666");
							}
							break;
						case '3':
							if( i==1 || i==3 ){
								System.out.print("....6");
							}
							else{
								System.out.print("66666");
							}
							break;
						case '4':
							if( i==2 ){
								System.out.print("66666");
							}
							else if( i==0 || i==1 ){
								System.out.print("6...6");
							}
							else{
								System.out.print("....6");
							}
							break;
						case '5':
							if( i==1 ){
								System.out.print("6....");
							}
							else if( i==3 ){
								System.out.print("....6");
							}
							else{
								System.out.print("66666");
							}
							break;
						case '6':
							if( i==1 ){
								System.out.print("6....");
							}
							else if( i==3 ){
								System.out.print("6...6");
							}
							else{
								System.out.print("66666");
							}
							break;
						case '7':
							if( i==0 ){
								System.out.print("66666");
							}
							else{
								System.out.print("....6");
							}
							break;
						case '8':
							if( i==1 || i==3 ){
								System.out.print("6...6");
							}
							else{
								System.out.print("66666");
							}
							break;
						case '9':
							if( i==1 ){
								System.out.print("6...6");
							}
							else if( i==3 ){
								System.out.print("....6");
							}
							else{
								System.out.print("66666");
							}
							break;
						
					}
					if( j!=len-1)
						System.out.print("..");
				}
				System.out.println("");
			}
		}
		
	}

}
