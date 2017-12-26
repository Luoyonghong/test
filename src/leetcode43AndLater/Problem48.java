package leetcode43AndLater;

public class Problem48
{
	int length;
	int [] t;
	public void rotate(int[][] matrix)
	{
		 if(matrix == null || matrix.length==0 || matrix[0].length==0)
		        return;
		    int layerNum = matrix.length/2;
		    for(int layer=0;layer<layerNum;layer++)
		    {
		        for(int i=layer;i<matrix.length-layer-1;i++)
		        {
		            int temp = matrix[layer][i];
		            matrix[layer][i] = matrix[matrix.length-1-i][layer];
		            matrix[matrix.length-1-i][layer] = matrix[matrix.length-1-layer][matrix.length-1-i];
		            matrix[matrix.length-1-layer][matrix.length-1-i] = matrix[i][matrix.length-1-layer];
		            matrix[i][matrix.length-1-layer] = temp;
		        }
		    }
	}
	public void func(int [][] matrix, int n)
	{
		if(n<2)
			return;
		int begini=(length-n)/2;
		int endi=length-(length-n)/2-1;//  >=begin   <=end
		int beginj=(length-n)/2;
		
		for(int i=endi;i>=begini;i--)
		{
			t[i]=matrix[i][endi];
			matrix[i][endi]=matrix[begini][i];
		}
	
		print(matrix);
		
		for(int i=begini;i<=endi;i++)
		{
			matrix[begini][endi-i]=matrix[i][begini];
		}
		
		print(matrix);
		
		for(int i=begini;i<=endi;i++)
		{
			matrix[i][begini]=matrix[endi][i];
		}
		
		print(matrix);
		
		for(int i=endi;i>=begini;i--)
		{
			matrix[endi][i]=t[endi-i];
		}
		
		print(matrix);
		
		func(matrix,n-2);
		
		print(matrix);
	}
	
	public void print(int [][] matrix)
	{
		for (int[] is : matrix)
		{
			for (int i : is)
			{
				System.out.print(i+" ");
			}
			System.out.println(); 
		}
		System.out.println(); 
	}
	
	public static void main(String[] args)
	{
		int[][] matrix={{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
		for (int[] is : matrix)
		{
			for (int i : is)
			{
				System.out.print(i+" ");
			}
			System.out.println(); 
		}
		System.out.println(); 
		Problem48 p=new Problem48();
		p.rotate(matrix);
		for (int[] is : matrix)
		{
			for (int i : is)
			{
				System.out.print(i+" ");
			}
			System.out.println(); 
		}
		
	}
}
