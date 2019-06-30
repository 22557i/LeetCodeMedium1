package lcwu;
import java.util.*;
public class Solution230 {
	public int kthSmallest(TreeNode root, int k) {
		if(root==null)return 0;
		ArrayList<Integer> res = PrintFromTopToBottom(root);
		Collections.sort(res);
		return res.get(k-1);

	}
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> lists=new ArrayList<Integer>();
		if(root==null)
			return lists;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode tree=queue.poll();
			if(tree.left!=null)
				queue.offer(tree.left);
			if(tree.right!=null)
				queue.offer(tree.right);
			lists.add(tree.val);
		}
		return lists;
	}
}
