package lcwu;
import java.util.*;
public class Solution430 {
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {}

		public Node(int _val,Node _prev,Node _next,Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	};

	public Node flatten(Node head) {

		if (head == null) return head;

		Stack<Node> stack = new Stack<>();
		Node node = head;
		Node dummyHead = new Node();
		Node prev = dummyHead;
		while (!stack.isEmpty() || node != null) {
			if (node == null) {
				node = stack.pop();
			}
			prev.next = node;
			if (prev != dummyHead) {
				node.prev = prev;
			}
			prev = node;
			if (node.child == null) {
				node = node.next;
			} else {
				if (node.next != null) {
					stack.push(node.next);
				}
				Node child = node.child;
				node.child = null;
				node = child;
			}
		}
		dummyHead.next.prev = null;
		return dummyHead.next;
	}
}
