import java.util.*;

public class Solution658 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<Integer>();
		for(int a:arr){
			res.add(a);
		}
		Collections.sort(res,((o1, o2) -> o1-o2==0?0:Math.abs(o1-x)-Math.abs(o2-x)));
		res = res.subList(0,k);
		Collections.sort(res);
		return res;

	}
}
