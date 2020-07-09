package PrintShortestCommonSuperSequence;
import java.util.*;

public class Main {
	
	public static String printShortestCommonSuperSequence(String s1, String s2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0; i < m + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		int i = m;
		int j = n;
		String res = "";
		while(i != 0 && j != 0) {
			if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
				res += String.valueOf(s1.charAt(i - 1));
				i--;	j--;
			} else {
				if(dp[i][j - 1] > dp[i - 1][j]) {
					res += String.valueOf(s2.charAt(j - 1));
					j--;
				} else {
					res += String.valueOf(s1.charAt(i - 1));
					i--;
				}
			}
		}
		while(i != 0) {
			res += String.valueOf(s1.charAt(i - 1));
			i--;
		}
		while(j != 0) {
			res += String.valueOf(s2.charAt(j - 1));
				j--;
		}

		return new StringBuffer(res).reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "acbcf";
		String s2 = "abcdaf";

		System.out.println(printShortestCommonSuperSequence(s1, s2, s1.length(), s2.length()));
	}
}