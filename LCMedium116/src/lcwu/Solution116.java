package lcwu;
import  java.util.*;
public class Solution116 {
	public Node connect(Node root) {
		if(root == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		Node next = null;
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				size--;
				Node cur = queue.poll();
				cur.next = next;
				next = cur;
				if(cur.right != null)
					queue.add(cur.right);
				if(cur.left != null)
					queue.add(cur.left);
			}
			next = null;
		}
		return root;
	}
}
