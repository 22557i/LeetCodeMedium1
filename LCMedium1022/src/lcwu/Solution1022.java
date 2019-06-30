package lcwu;

import java.util.*;
public class Solution1022 {
	public int sumRootToLeaf(TreeNode root) {

		int res = 0;
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> nums = new LinkedList<>();
		nums.offer(root.val);
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode cur = queue.poll();
				int curNum = nums.poll();
				if(cur.left == null && cur.right == null){
					res += curNum;
				}
				if(cur.left != null){
					queue.offer(cur.left);
					nums.offer(curNum * 2 + cur.left.val);
				}
				if(cur.right != null){
					queue.offer(cur.right);
					nums.offer(curNum * 2 + cur.right.val);
				}
			}
		}
		return res;
	}
}
