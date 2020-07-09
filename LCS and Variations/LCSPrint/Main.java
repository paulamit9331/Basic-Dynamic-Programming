package LCSPrint;
import java.util.*;

public class Main {
	
	public static String LCSLength(String s1, String s2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0; i < m + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(i == 0 || j == 0)		// base case
					dp[i][j] = 0;
				else if(s1.charAt(i - 1) == s2.charAt(j - 1))	// if character matches
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);	// if don't match we need the longest
			}
		}
		int i = m;
		int j = n;
		String result = "";
		while(i != 0 && j != 0) {
			if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
				result += s1.charAt(i - 1);
				i--;
				j--;
			} else {
				if(dp[i][j - 1] > dp[i - 1][j])
					j--;
				else
					i--;
			}
		}
		return new StringBuffer(result).reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "abedjrgw";

		System.out.println(LCSLength(s1, s2, s1.length(), s2.length()));
	}
}