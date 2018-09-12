package 头条;

import java.util.Scanner;


public class 组织优化
{
	 public static void DFS(int M, int i, int j, boolean [][]visited, int [][]matrix)
	{
		 if(i<0||j<0||i>=M||j>=M)
			 return;
		if(visited[i][j] )
			return;
		if(matrix[i][j]==0)
			return;
		visited[i][j] = true;
		
		DFS(M, i+1, j, visited, matrix);
		DFS(M, i-1, j, visited, matrix);
		DFS(M, i, j+1, visited, matrix);
		DFS(M, i, j-1, visited, matrix);

	}
	 
	public static int countSum(int M, int[][] matrix) {
		boolean[][] visited = new boolean[M][M];
		for(int i=0;i<M;i++)
			for(int j=0;j<M;j++)
				visited[i][j]=false;
		int count = 0;
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < M; j++)
			{
				if (!visited[i][j] && matrix[i][j] > 0)
				{
					DFS(M, i, j, visited, matrix);
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		int M = 0;
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		int[][] matrix = new int[M][M];
		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++)
				matrix[i][j] = sc.nextInt();
			
		System.out.println(countSum(M, matrix));
	}
}

/*
 * 
 * #include <iostream>
using namespace std;
void DFS(int M, int i, int j, int **visited, int **matrix)
{
    if(i<0||j<0||i>=M||j>=M)
			 return;
	if(visited[i][j] )
			return;
	if(matrix[i][j]==0)
			return;
	visited[i][j] = 1;
		
	DFS(M, i+1, j, visited, matrix);
	DFS(M, i-1, j, visited, matrix);
	DFS(M, i, j+1, visited, matrix);
	DFS(M, i, j-1, visited, matrix);
}
int func(int M, int **matrix) {
 int **visited = new int*[M];
 for (int i = 0; i < M; i++)
  visited[i] = new int[M];
 for (int i = 0; i < M; i++)
  for (int j = 0; j < M; j++)
   visited[i][j] = 0;
 int count = 0;
 for (int i = 0; i < M; i++){
  for (int j = 0; j < M; j++){
   if (!visited[i][j] && matrix[i][j]){
    DFS(M, i, j, visited, matrix);
    count++;
   }
  }
 }
 cout << count << endl;
 return 0;
}
int main() {
 int M;
 cin >> M;
 int **matrix = new int*[M];
 for (int i = 0; i < M; i++)
  matrix[i] = new int[M];
 for (int i = 0; i < M; i++)
  for (int j = 0; j < M; j++)
   cin >> matrix[i][j];
 func(M, matrix);
 return 0;
}
 */
