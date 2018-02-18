package LeetCode120AndLater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class UndirectedGraphNode
{
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x)
	{
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Problem133
{
	HashMap<Integer, UndirectedGraphNode> map=new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
	{
		
		return h(node);
	}
	
	public UndirectedGraphNode h(UndirectedGraphNode r)
	{
		if(r==null)
			return null;
		if(!map.containsKey(r.label))
		{
			UndirectedGraphNode t=new UndirectedGraphNode(r.label);
			map.put(r.label, t);
			List<UndirectedGraphNode> l=r.neighbors;
			List<UndirectedGraphNode> l2=new ArrayList<>();
			for(int i=0;i<l.size();i++)
			{
				UndirectedGraphNode gh=h(l.get(i));
				if(gh==null)
					gh=map.get(l.get(i).label);
				l2.add(gh);
			}
			t.neighbors=l2;
			return t;
		}
		else
			return null;
	}
}
