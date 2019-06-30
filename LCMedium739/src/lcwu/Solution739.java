package lcwu;
import java.util.*;
public class Solution739 {
	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		Stack<Integer> numsstack = new Stack();
		for(int i=0; i<T.length; i++){
			while(!numsstack.isEmpty() && T[i]>T[numsstack.peek()]){
				int index = numsstack.pop();
				res[index] = i-index;
			}
			numsstack.push(i);
		}
		return res;
	}
}
