package 华为;

import java.util.Scanner;

public class 第二题
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		char[] s=sc.nextLine().toCharArray();
		for(int i=0;i<s.length;i++)
		{
			switch (s[i])
			{
			case 'A':
				s[i]='Q';
				break;
			case 'B':
				s[i]='W';
				break;
			case 'C':
				s[i]='E';
				break;
			case 'D':
				s[i]='R';
				break;
			case 'E':
				s[i]='T';
				break;
			case 'F':
				s[i]='Y';
				break;
			case 'G':
				s[i]='U';
				break;
			case 'H':
				s[i]='I';
				break;
			case 'I':
				s[i]='O';
				break;
			case 'J':
				s[i]='P';
				break;
			case 'K':
				s[i]='A';
				break;
			case 'L':
				s[i]='S';
				break;
			case 'M':
				s[i]='D';
				break;
			case 'N':
				s[i]='F';
				break;
			case 'O':
				s[i]='G';
				break;
			case 'P':
				s[i]='H';
				break;
			case 'Q':
				s[i]='J';
				break;
			case 'R':
				s[i]='K';
				break;
			case 'S':
				s[i]='L';
				break;
			case 'T':
				s[i]='Z';
				break;
			case 'U':
				s[i]='X';
				break;
			case 'V':
				s[i]='C';
				break;
			case 'W':
				s[i]='V';
				break;
			case 'X':
				s[i]='B';
				break;
			case 'Y':
				s[i]='N';
				break;
			case 'Z':
				s[i]='M';
				break;
			case 'a':
				s[i]='q';
				break;
			case 'b':
				s[i]='w';
				break;
			case 'c':
				s[i]='e';
				break;
			case 'd':
				s[i]='r';
				break;
			case 'e':
				s[i]='t';
				break;
			case 'f':
				s[i]='y';
				break;
			case 'g':
				s[i]='u';
				break;
			case 'h':
				s[i]='i';
				break;
			case 'i':
				s[i]='o';
				break;
			case 'j':
				s[i]='p';
				break;
			case 'k':
				s[i]='a';
				break;
			case 'l':
				s[i]='s';
				break;
			case 'm':
				s[i]='d';
				break;
			case 'n':
				s[i]='f';
				break;
			case 'o':
				s[i]='g';
				break;
			case 'p':
				s[i]='h';
				break;
			case 'q':
				s[i]='j';
				break;
			case 'r':
				s[i]='k';
				break;
			case 's':
				s[i]='l';
				break;
			case 't':
				s[i]='z';
				break;
			case 'u':
				s[i]='x';
				break;
			case 'v':
				s[i]='c';
				break;
			case 'w':
				s[i]='v';
				break;
			case 'x':
				s[i]='b';
				break;
			case 'y':
				s[i]='n';
				break;
			case 'z':
				s[i]='m';
				break;
			default:
				break;
			}
		}
		System.out.println(new String(s)); 
	}
}
