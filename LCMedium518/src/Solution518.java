public class Solution518 {
	public int change(int amount, int[] coins) {
		int[] temp = new int[amount+1];
		temp[0] = 1;
		for(int j=0; j<coins.length; j++) {
			for(int i=coins[j]; i<=amount; i++) {
				temp[i] += temp[i-coins[j]];
			}
		}
		return temp[amount];
	}
}
