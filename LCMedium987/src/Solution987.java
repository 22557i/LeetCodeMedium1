
import java.util.*;
public class Solution987 {
		/*
		algorithm: starting from root, we have its X be 0, and Y be 0
		if we move left, X - 1 and Y - 1, right X + 1 and Y -1,
		put all result into a map of <Integer, PriorityQueue<Tuple>> map, the order of pq should be based on off
		X value, and if X is equal, it compares Y value
		we also keep track of the min and max X for post processing

		initialize: <Integer, PriorityQueue<Tuple>> map, int max, min, x, list of result
		complexity:
			using pq:
				generate map: O(n + nlogn) + postprocessing O(nlogn)
			space:
				generate pq, list, recursion call stack O(n + n + n)
		*/
		public List<List<Integer>> verticalTraversal(TreeNode root) {
			//initialize
			Map<Integer, PriorityQueue<Tuple>> map = new HashMap<>();
			List<List<Integer>> res = new ArrayList<>();
			if (root == null) { //corner case
				return res;
			}
			int[] track = new int[2]; //left int[0] = min, int[1] = max

			//dfs collect result into the map
			dfs(root, map, track, 0, 0);

			//put results in the ascending order of x into res
			for (int i = track[0]; i <= track[1]; i++) {
				List<Integer> subResult = new ArrayList<>();
				PriorityQueue<Tuple> subPQ = map.get(i);
				while (!subPQ.isEmpty()) {
					subResult.add(subPQ.poll().val);
				}
				res.add(subResult);
			}

			return res;
		}

		public void dfs(TreeNode root, Map<Integer, PriorityQueue<Tuple>> map, int[] track, int x, int y) {
			if (root == null) {
				return;
			}

			PriorityQueue<Tuple> sub = map.getOrDefault(x, new PriorityQueue<Tuple>());
			sub.offer(new Tuple(x, y, root.val));
			map.put(x, sub);
			//update min and max
			track[0] = Math.min(track[0], x);
			track[1] = Math.max(track[1], x);

			dfs(root.left, map, track, x - 1, y - 1);
			dfs(root.right, map, track, x + 1, y - 1);
		}

		class Tuple implements Comparable<Tuple> {
			int x;
			int y;
			int val;
			public Tuple(int x, int y, int val) {
				this.x = x;
				this.y = y;
				this.val = val;
			}
			//comparaTo is tricky to define since order of x and y are reversed based on the question
			@Override
			public int compareTo(Tuple other) {
				if (this.x == other.x) {
					if (this.y == other.y) {//if same x and y, compare val
						return this.val < other.val ? -1 : (this.val == other.val ? 0 : 1);
					}
					return this.y < other.y ? 1 : -1;
				}
				return this.x < other.x ? -1 : 1;
			}
		}
}

