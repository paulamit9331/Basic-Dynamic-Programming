package MinimumInsertionOrDeletionToMakeAStringToAnother;
import java.util.*;

public class Main {
	
	public static int LCS(String s1, String s2, int m, int n) {
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
		return dp[m][n];
	}

	public static void minimumOperations(String s1, String s2) {
		int lcs = LCS(s1, s2,s1.length(), s2.length());
		int deletion = s1.length() - lcs;
		int insertion = s2.length() - lcs;

		System.out.println("Insertion : " + insertion + "\n" + "Deletion : " + deletion);
	}

	public static void main(String[] args) {
		String s1 = "heap";
		String s2 = "pea";

		minimumOperations(s1, s2);
	}
}