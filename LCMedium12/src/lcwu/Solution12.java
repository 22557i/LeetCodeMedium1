package lcwu;

public class Solution12 {
	public String intToRoman(int num) {
		String[] symbol = new String[]{"I", "V", "X", "L", "C", "D", "M"};
		StringBuilder builder = new StringBuilder();
		int i = 0; // record digit
		while(num > 0){
			int tail = num%10;
			if(tail < 4){
				for(int j = 0; j< tail; j++)
					builder.insert(0,symbol[i*2]);
			}else if(tail == 4){
				builder.insert(0,symbol[i*2] + symbol[i*2 + 1]);
			}else if(tail> 4 && tail < 9){
				for(int j = 0; j< tail - 5; j++)
					builder.insert(0,symbol[i*2]);
				builder.insert(0,symbol[i*2 + 1]);
			}else if(tail == 9){
				builder.insert(0,symbol[i*2] + symbol[i*2 + 2]);
			}
			i++;
			num /= 10;
		}
		return builder.toString();
	}
}
