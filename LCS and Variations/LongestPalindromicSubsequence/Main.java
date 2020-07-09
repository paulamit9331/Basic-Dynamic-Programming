package LongestPalindromicSubsequence;
import java.util.*;

public class Main {
	
	public static String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	public static int LCS(String s1, String s2, int n) {
		int[][] dp = new int[n + 1][n + 1];
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		return dp[n][n];
	}

	public static int LPS(String s) {
		return LCS(s, reverse(s), s.length());
	}

	public static void main(String[] args) {
		String s = "agbcbfa";

		System.out.println(LPS(s));
	}
}