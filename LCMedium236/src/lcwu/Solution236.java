package lcwu;

public class Solution236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right != null)
			return root;
		TreeNode child = left != null ? left : right;
		if(child  != null){
			if(child == p && root == q || child == q && root == p)
				return root;
			return child;
		}
		return root == p || root == q ? root : null;
	}
}
