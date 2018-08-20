package leetcode300AndLater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Problem332
{
	private boolean find(Map<String, List<String>> graph, List<String> itinerary, int target)
	{
		if (itinerary.size() == target)
			return true;

		String t = itinerary.get(itinerary.size() - 1);
		List<String> next = graph.get(t);
		if (next == null)
			return false;
		for (int i = 0; i < next.size(); i++)
		{
			itinerary.add(next.get(i));
			next.remove(i);
			if (find(graph, itinerary, target))
				return true;
			next.add(i, itinerary.get(itinerary.size() - 1));
			itinerary.remove(itinerary.size() - 1);
		}
		return false;
	}

	public List<String> findItinerary(String[][] tickets)
	{
		Map<String, List<String>> graph = new HashMap<>();
		for (int i = 0; i < tickets.length; i++)
		{
			List<String> next = graph.get(tickets[i][0]);
			if (next == null)
			{
				next = new ArrayList<>();
				graph.put(tickets[i][0], next);
				// set.add(tickets[i][0]);
			}
			next.add(tickets[i][1]);
		}
		for (List<String> next : graph.values())
			Collections.sort(next);
		List<String> itinerary = new ArrayList<>();
		itinerary.add("JFK");
		find(graph, itinerary, tickets.length + 1);
		return itinerary;
	}

	public static void main(String[] args)
	{
		Problem332 p = new Problem332();
		// String tickets[][]={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO",
		// "SJC"}, {"LHR", "SFO"}};
		// String
		// tickets[][]={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String tickets[][] = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		System.err.println(p.findItinerary(tickets));
	}
}
