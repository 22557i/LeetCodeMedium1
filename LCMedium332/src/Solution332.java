import java.util.*;

public class Solution332 {
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> ticket : tickets) {
			map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
			map.get(ticket.get(0)).add(ticket.get(1));
		}
		List<String> result = new LinkedList<>();
		dfs("JFK", map, result);
		return result;
	}

	private void dfs(String departure, Map<String, PriorityQueue<String>> map, List<String> result) {
		PriorityQueue<String> arrivals = map.get(departure);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), map, result);
		}
		result.add(0, departure);
	}
}
