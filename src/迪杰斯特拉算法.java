
public class 迪杰斯特拉算法
{
	public static int N=1000;
	public static void f(int[][] graph,int s)
	{
		int n=graph.length;
		boolean find[]=new boolean[n];
		int nowMinDist[]=new int[n];
		for(int i=0;i<n;i++)
			nowMinDist[i]=graph[s][i];//首先初始化当前最小距离，是起始点到其他节点的距离
		find[s]=true;//将起始点加入“已经到达”节点集合中
		
		int preNode[]=new int[n];
		int pre=-1;
		for(int i=0;i<n-1;i++)//寻找n-1次，每次找到一个节点，需要找n-1次
		{
			int minDis=N;
			for(int j=0;j<n;j++)
			{
				if(nowMinDist[j]<minDis&&!find[j])
				{
					minDis=nowMinDist[j];//从没被找到的所有节点中，找出距离最小的那个
					pre=j;
				}
			}
			find[pre]=true;//距离最小的点加入到节点中
			for(int j=0;j<n;j++)
			{
				if(!find[j]&&graph[pre][j]+nowMinDist[pre]<nowMinDist[j])
				{
					nowMinDist[j]=graph[pre][j]+nowMinDist[pre];
					preNode[j]=pre;
				}
			}
		}
		
		for(int i=0;i<n;i++)
			System.out.println("v" + s + "...v" + preNode[i] + "->v" + i + ", s=" + nowMinDist[i]);
		
	}
	public static void dijkstra(int vs, int[][] Graph) {
        int NUM = Graph[0].length;
        // 前驱节点数组
        int[] prenode = new int[NUM];
        // 最短距离数组
        int[] mindist = new int[NUM];
        // 该节点是否已经找到最短路径
        boolean[] find = new boolean[NUM];
         
        int vnear = 0;
         
        for (int i = 0; i < mindist.length; i++) {
            prenode[i] = vs;
            mindist[i] = Graph[vs][i];
            find[i] = false;
        }
 
        find[vs] = true;
 
        for (int v = 1; v < Graph.length; v++) {
 
            // 每次循环求得距离vs最近的节点vnear和最短距离min
            int min = N;
            for (int j = 0; j < Graph.length; j++) {
                if (!find[j] && mindist[j] < min) {
                    min = mindist[j];
                    vnear = j;
                }
            }
            find[vnear] = true;
 
            // 根据vnear修正vs到其他所有节点的前驱节点及距离
            for (int k = 0; k < Graph.length; k++) {
                if (!find[k] && (min + Graph[vnear][k]) < mindist[k]) {
                    prenode[k] = vnear;
                    mindist[k] = min + Graph[vnear][k];
                }
            }
        }
         
        for (int i = 0; i < NUM; i++) {
            System.out.println("v" + vs + "...v" + prenode[i] + "->v" + i + ", s=" + mindist[i]);
        }
    }
	
	public static void main(String[] args)
	{
		int[][] graph= {
				{ 0, 1, 5, N, N, N, N, N, N },
	            { 1, 0, 3, 7, 5, N, N, N, N },
	            { 5, 3, 0, N, 1, 7, N, N, N },
	            { N, 7, N, 0, 2, N, 3, N, N },
	            { N, 5, 1, 2, 0, 3, 6, 9, N },
	            { N, N, 7, N, 3, 0, N, 5, N },
	            { N, N, N, 3, 6, N, 0, 2, 7 },
	            { N, N, N, N, 9, 5, 2, 0, 4 },
	            { N, N, N, N, N, N, 7, 4, 0 } 
	            };
	    f(graph, 0);   
	    //dijkstra(0, graph); 
	}
}
