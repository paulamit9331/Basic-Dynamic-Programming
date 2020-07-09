package MinimumSubsetSumDiff;
import java.util.*;
import java.math.*;

public class Main {

	public static int minimumSubsetSumDiff(int[] array, int n) {
		int sum = 0;
		for(int i : array)
			sum += i;

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
		int min = Integer.MAX_VALUE;
		for(int j = 0; j <= sum / 2; j++) {
			if(dp[n][j] != false)
				min = Math.min(min, sum - 2 * j);
		}

		return min;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1, 6, 11, 5};

		System.out.println(minimumSubsetSumDiff(array, array.length));
	}
}