package lcwu;

import java.util.*;
class Solution380 {


	private int[] A;
	private int size;
	private int capacity;
	private Map<Integer, Integer> map; // val - index

	/** Initialize your data structure here. */
	public Solution380() {
		capacity = 10;
		A = new int[capacity];
		size = 0;
		map = new HashMap<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (size >= capacity) {
			resize();
		}
		// do not insert if already present
		if (map.containsKey(val)) {
			return false;
		}
		// insert into next index = size;
		map.put(val, size);
		A[size++] = val;
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		// remove the element at index , by replacing it with the last element, and decrese the size
		A[index] = A[size - 1];
		// update the tail element index to index
		map.put(A[size - 1], index);
		// remove the element from val-index map
		map.remove(val);
		size--;
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (size == 0) {
			return -1;
		}
		Random r = new Random();
		int max = size - 1;
		int min = 0;
		int index = r.nextInt((max - min) + 1) + min;
		return A[index];
	}

	private void resize() {
		// TODO - resize to double the capacity
		int newCapacity = 2 * capacity;
		int[] T = new int[newCapacity];
		for (int i = 0; i < capacity; i++) {
			T[i] = A[i];
		}
		A = T;
		capacity = newCapacity;
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */