package lcwu;

import java.util.Arrays;

public class Solution654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length == 0)return null;
		if(nums.length == 1) return new TreeNode(nums[0]);
		int max = nums[0];
		int index = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] >= max) {
				max = nums[i];
				index = i;
			}
		}
		TreeNode t = new TreeNode(max);
		t.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
		t.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
		return t;
	}
}
