import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution958 {
	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		int maxIndex = findMaxIndex(root, 0);
		return traverse(root, 0, maxIndex);
	}

	private int findMaxIndex(TreeNode root, int index) {
		if (root == null) {
			return index;
		}

		if (root.left != null && root.right != null) {
			return Math.max(findMaxIndex(root.left, (index*2) + 1), findMaxIndex(root.right, (index*2) + 2));
		} else if (root.left == null && root.right == null) {
			return index;
		} else if (root.left != null) {
			return findMaxIndex(root.left, (index*2) + 1);
		} else {
			return findMaxIndex(root.right, (index*2) + 2);
		}
	}

	private boolean traverse(TreeNode root, int index, int maxIndex) {
		if (root == null) {
			if (index > maxIndex) {
				return true;
			} else {
				return false;
			}
		}

		return traverse(root.left, (index*2) + 1, maxIndex) && traverse(root.right, (index*2) + 2, maxIndex);
	}
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
