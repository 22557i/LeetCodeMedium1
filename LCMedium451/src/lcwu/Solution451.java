package lcwu;
import java.util.*;
public class Solution451 {
	public String frequencySort(String s) {
		Map<Character,Integer>restoreMap = new HashMap<>();


		Map<Character,Integer> restoreMap1 = sortMapByValue(restoreMap);
		StringBuffer sb = new StringBuffer();
		for (Character key : restoreMap1.keySet()) {
			for (int i = 0; i <restoreMap1.get(key) ; i++) {
				sb.append(key);

			}
		}
		return sb.toString();
	}
	public Map<Character,Integer> sortMapByValue(Map<Character,Integer> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<Character,Integer> sortedMap = new LinkedHashMap<Character,Integer>();
		List<Map.Entry<Character,Integer>> entryList = new ArrayList<Map.Entry<Character,Integer>>(
				oriMap.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Character,Integer>>(){

			@Override
		public int compare(Map.Entry<Character,Integer> me1, Map.Entry<Character,Integer> me2) {
			return me2.getValue().compareTo(me1.getValue());
		}
		});

		Iterator<Map.Entry<Character,Integer>> iter = entryList.iterator();
		Map.Entry<Character,Integer> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}

}
//	public String frequencySort(String s) {
//		HashMap<Character, Integer> map = new HashMap();
//		for(Character c: s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
//		PriorityQueue<Character> pq = new PriorityQueue<Character>((c1, c2) -> map.get(c2) - map.get(c1));
//		for(Character c: map.keySet()) pq.offer(c);
//		StringBuilder sb = new StringBuilder();
//		while(!pq.isEmpty()){
//			char val = pq.poll();
//			int freq = map.get(val);
//			for(int i=0; i<freq; i++) sb.append(val);
//		}
//		return sb.toString();
//	}