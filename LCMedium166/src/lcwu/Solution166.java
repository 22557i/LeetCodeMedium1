package lcwu;

import java.util.*;
public class Solution166 {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder builder = new StringBuilder();
		if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
			builder.append('-');
		}
		int num = Math.abs((int) numerator);
		System.out.println("num = "+num);
		int den = Math.abs((int) denominator);
		System.out.println("den = "+ den);
		builder.append(num / den);
		num %= den;
		if (num == 0)
			return builder.toString();
		builder.append('.');
		Map<Integer, Integer> map = new HashMap<>();
		while (num != 0 && !map.containsKey(num)) {
			map.put(num, builder.length());
			num *= 10;
			builder.append(num / den);
			num %= den;
		}
		if (map.containsKey(num)) {
			int tmp = map.get(num);
			builder.insert(tmp, '(');
			builder.append(')');
		}
		return builder.toString();
	}
}
