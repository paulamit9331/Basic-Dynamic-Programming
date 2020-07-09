package CountSubsetSum;
import java.util.*;

public class Main {
	
	public static int countSubsetSum(int[] array, int n, int sum) {
		int[][] dp = new int[n + 1][sum + 1];
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < sum + 1; j++) {
				if(j == 0)
					dp[i][j] = 1;
				else if(j != 0 && i == 0)
					dp[i][j] = 0;
				else
					if(array[i - 1] <= j)
						dp[i][j] = dp[i - 1][j - array[i - 1]] + dp[i - 1][j];
					else
						dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][sum];
	}

	public static void main(String[] args) {
		int[] array = new int[] {2, 3, 5, 6, 8, 10};
		int sum = 10;

		System.out.println(countSubsetSum(array, array.length, sum));
	}
}