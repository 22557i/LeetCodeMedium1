import java.util.*;

public class Solution299 {
	public String getHint(String secret, String guess) {
		int A=0;
		int B=0;
		int n = secret.length();
		Set<Integer> bull = new HashSet<>();

		int g[]=new int[10];
		for (int i = 0; i < n; i++) {
			if(secret.charAt(i)==guess.charAt(i))A++;
			else {
				g[secret.charAt(i)-'0']++;
				g[guess.charAt(i)-'0']--;
				B++;
			}
		}
		for (int i = 0; i <10 ; i++) {
			if(g[i]<0)B+=g[i];
		}

		return A+"A"+B+"B";
	}

}
