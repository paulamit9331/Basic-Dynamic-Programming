package LongestCommonSubstring;
import java.util.*;

public class Main {
	
	public static int LCSLength(String s1, String s2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		int max = -1;

		for(int i = 0; i < m + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(i == 0 || j == 0)		// base case
					dp[i][j] = 0;
				else if(s1.charAt(i - 1) == s2.charAt(j - 1)) { // if character matches we take max length
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);		// same works as line 22 to 28
				}
				else
					dp[i][j] = 0;	// if don't match we set length to 0
			}
		} /*
		int max = -1;
		for(int i = 0; i < m + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(dp[i][j] > max)
					max = dp[i][j];
			}
		}
		*/
		return max;
	}

	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "abedefkw";

		System.out.println(LCSLength(s1, s2, s1.length(), s2.length()));
	}
}