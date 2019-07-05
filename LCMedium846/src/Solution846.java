import java.util.Arrays;
import java.util.*;

public class Solution846 {
	public boolean isNStraightHand(int[] hand, int W) {
		if(hand.length%W!=0)return false;

		TreeMap<Integer, Integer> count = new TreeMap();
		for (int card: hand) {
			if (!count.containsKey(card))
				count.put(card, 1);
			else
				count.replace(card, count.get(card) + 1);
		}
		while(count.size()>0){

			int first = count.firstKey();
			for (int i = first; i <first+W ; i++) {
				if (!count.containsKey(i)) return false;

				int a = count.get(i);
				if(a==1)count.remove(i);
				else count.replace(i,a-1);
			}
		}


		return true;
	}
}
