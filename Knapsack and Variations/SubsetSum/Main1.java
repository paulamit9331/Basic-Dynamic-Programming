package SubsetSum;
import java.util.*;

public class Main1 {
	
	public static boolean isSubsetPresent(int[] array, int n, int sum) {
		boolean[][] dp = new boolean[n + 1][sum + 1];
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < sum + 1; j++) {
				if(j == 0)
					dp[i][j] = true;
				else if(j != 0 && i == 0)
					dp[i][j] = false;
				else
					if(array[i - 1] <= j)
						dp[i][j] = dp[i - 1][j - array[i - 1]] || dp[i - 1][j];
					else
						dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][sum];
	}

	public static void main(String[] args) {
		int[] array = new int[] {3, 4, 8, 1};
		int sum = 11;

		if(isSubsetPresent(array, array.length, sum))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}