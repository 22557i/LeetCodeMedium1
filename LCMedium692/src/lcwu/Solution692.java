package lcwu;

import java.util.*;
public class Solution692 {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String,Integer>restoremap = new HashMap<>();
		for (int i = 0; i <words.length ; i++) {
			restoremap.put(words[i], restoremap.getOrDefault(words[i], 0) + 1);
		}
		Map<String ,Integer>resmap1 = sortMapByValue(restoremap);

		List<String> list1 = new ArrayList<>(resmap1.keySet());

		return list1.subList(0, k);
	}
	public Map<String,Integer> sortMapByValue(Map<String,Integer> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<String,Integer> sortedMap = new LinkedHashMap<String,Integer>();
		List<Map.Entry<String,Integer>> entryList = new ArrayList<Map.Entry<String,Integer>>(
				oriMap.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<String,Integer>>(){

			@Override
			public int compare(Map.Entry<String,Integer> me1, Map.Entry<String,Integer> me2) {
				return me2.getValue().compareTo(me1.getValue());
			}
		});

		Iterator<Map.Entry<String,Integer>> iter = entryList.iterator();
		Map.Entry<String,Integer> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}
}
