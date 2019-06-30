package lcwu;

import  java.util.*;
public class Solution46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> p = new ArrayList<>();
		generatePermutation(nums, 0, p, res);
		return res;
	}

	public void generatePermutation(int[] nums, int index, List<Integer> p, List<List<Integer>> res){
		if(index == nums.length){
			res.add(new ArrayList<>(p));
			return;
		}

		for(int i = 0; i<nums.length; i++){
			if(!p.contains(nums[i])){
				p.add(nums[i]);
				generatePermutation(nums, index+1, p, res);
				p.remove(p.size()-1);
			}
		}

	}



	public static void main(String[] args) {
		Solution46 pm = new Solution46();
		int[] nums = {1, 2, 3};
		System.out.println(pm.permute(nums));
	}


}
//}public List<List<Integer>> permute(int[] nums) {
//	return helper(nums, new LinkedHashSet<Integer>(nums.length), new ArrayList<List<Integer>>());
//}
//
//	private List<List<Integer>> helper(int[] nums, LinkedHashSet<Integer> lhs, List<List<Integer>> result) {
//		if(lhs.size() == nums.length){
//			result.add(new ArrayList<Integer>(lhs));
//		} else {
//			for(int n : nums){
//				if(!lhs.contains(n)){
//					lhs.add(n);
//					helper(nums, lhs, result);
//					lhs.remove(n);
//				}
//			}
//		}
//		return result;
//	}