package lcwu;

import java.util.*;
class Solution18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length<4) return res;
		Arrays.sort(nums);
		Nsum(nums,0,4,target,res,new ArrayList<Integer>());
		return res;
	}

	private void Nsum(int[] nums,int start,int N,int target,List<List<Integer>> res, List<Integer> cur){
		if(nums[start]*N>target || nums[nums.length-1]*N<target){//to speed up
			return;
		}

		if(N==2){//two sum
			int low = start;
			int high = nums.length-1;
			while(low<high){
				if(nums[low]+nums[high]==target){
					cur.add(nums[low]);
					cur.add(nums[high]);
					res.add(new ArrayList<Integer>(cur));
					cur.remove(cur.size()-1);
					cur.remove(cur.size()-1);
					low++;
					high--;
					while(low<nums.length-1 && nums[low]==nums[low-1]) low++;
					while(high>0 && nums[high]==nums[high+1]) high--;
				}
				else if(nums[low]+nums[high]<target){
					low++;
				}
				else{
					high--;
				}
			}
			return;
		}

		for(int i = start;i<=nums.length-N;i++){
			if(i==start || nums[i]!=nums[i-1]){
				cur.add(nums[i]);
				Nsum(nums,i+1,N-1,target-nums[i],res,cur);
				cur.remove(cur.size()-1);
			}
		}



	}
}