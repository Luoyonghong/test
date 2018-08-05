package leetcode300AndLater;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Node
{
	Set<Node> neibor;
	int i;
	public Node(int i)
	{
		neibor=new HashSet<>();
		this.i=i;
	}
	public boolean isleaf()
	{
		if(neibor.size()==1)
			return true;
		else
			return false;
	}	
}

public class Problem310
{
	public List<Integer> findMinHeightTrees(int n, int[][] edges)
	{
		List<Node> nownodes=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			nownodes.add(new Node(i));
		}
		for(int i =0;i<edges.length;i++)
		{
			int num[]=edges[i];
			nownodes.get(num[0]).neibor.add(nownodes.get(num[1]));
			nownodes.get(num[1]).neibor.add(nownodes.get(num[0])); 
		}
        if(edges.length==0)
        {
            List<Integer> l=new ArrayList<>();
			l.add(0);
			return l;
        }
        if(n==2&&edges.length==1&&edges[0][0]==0&&edges[0][1]==1)
        {
            List<Integer> l=new ArrayList<>();
			l.add(0);
			l.add(1);
			return l;
        }
		if(n==2)
		{
			List<Integer> l=new ArrayList<>();
			l.add(1);
			l.add(2);
			return l;
		}
		if(n==1)
		{
			List<Integer> l=new ArrayList<>();
			l.add(1);
			return l;
		}
		while(true)
		{
			List<Node> removed=new ArrayList<>();
			for(int i =0;i<nownodes.size();i++)
			{
				Node node =nownodes.get(i);
				if(node.isleaf())
				{
					removed.add(node);
				}
			}
			for(int i =0;i<removed.size();i++)
			{
				Node haha=removed.get(i);
				nownodes.remove(removed.get(i));
				for(Node temp:haha.neibor)
				{
					temp.neibor.remove(haha);
				}
			}
//			for(int i=0;i<nownodes.size();i++)
//				System.out.print(nownodes.get(i).i+"  "); 
//			System.out.println();
			
			
			if(nownodes.size()==1||nownodes.size()==2)
				break;
		}
		List<Integer> re=new ArrayList<>();
		for(int i =0;i<nownodes.size();i++)
		{
			re.add(nownodes.get(i).i);
		}
		return re;
		
	}
	public static void main(String[] args)
	{
		Problem310 p =new Problem310();
		//int edges[][]={{1, 0}, {1, 2}, {1, 3}};
		//int edges[][]={{0,3},{1,3},{2,3},{4,3},{5,4}};
		int edges[][]={{0,1}};
		System.out.println(p.findMinHeightTrees(2, edges));
	}
}
