package lcwu;
import java.util.*;
public class Solution355 {
	class Twitter {

		Map<Integer, Set<Integer>> followMap;
		Map<Integer, List<int[]>> postMap;
		int time;
		/** Initialize your data structure here. */
		public Twitter() {
			followMap = new HashMap<Integer, Set<Integer>>();
			postMap = new HashMap<Integer, List<int[]>>();
			time = 0;
		}
		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			time++;
			if(!followMap.containsKey(userId)){
				followMap.put(userId, new HashSet<Integer>());
				followMap.get(userId).add(userId);
			}
			if(!postMap.containsKey(userId)){
				postMap.put(userId, new ArrayList<int[]>());
			}
			postMap.get(userId).add(new int[]{tweetId, time});
		}

		/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> res = new ArrayList<Integer>();
			int count = 0;
			time++;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
				public int compare(int[] p1, int[] p2){
					return p2[3]-p1[3];
				}
			});
			if(!followMap.containsKey(userId)){return res;}
			Set<Integer> followSet = followMap.get(userId);
			for(int followId : followSet){
				if(postMap.containsKey(followId)){
					List<int[]> postList = postMap.get(followId);
					int[] post = postList.get(postList.size()-1);
					q.offer(new int[]{followId, postList.size()-1, post[0],post[1]});
				}
			}
			while(count<10 && !q.isEmpty()){
				int[] postInfo = q.poll();
				int followId = postInfo[0];
				int index = postInfo[1];
				res.add(postInfo[2]);
				count++;
				index--;
				if(index>=0){
					int[] nextTweet = postMap.get(followId).get(index);
					q.offer(new int[]{followId, index, nextTweet[0], nextTweet[1]});
				}
			}
			return res;
		}
		/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
		public void follow(int followerId, int followeeId) {
			time++;
			if(!followMap.containsKey(followerId)){
				followMap.put(followerId, new HashSet<Integer>());
				followMap.get(followerId).add(followerId);
			}
			if(followerId!=followeeId){
				followMap.get(followerId).add(followeeId);
			}
		}

		/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
		public void unfollow(int followerId, int followeeId) {
			time++;
			if(followMap.containsKey(followerId) && followerId!=followeeId){
				followMap.get(followerId).remove((Integer) followeeId);
			}
		}
	}
}
