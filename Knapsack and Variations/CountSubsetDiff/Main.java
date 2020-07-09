package CountSubsetDiff;
import java.util.*;
import java.math.*;

public class Main {

	public static int isEqual(int a, int b) {
		if(a == b)
			return 1;
		else
			return 0;
	}

	public static int countSubsetSumDiff(int[] array, int n, int diff) {
		int sum = 0;
		for(int i : array)
			sum += i;

		sum = (sum + diff) / 2;

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
		int[] array = new int[] {1, 1, 2, 3};
		int diff = 1;

		System.out.println(countSubsetSumDiff(array, array.length, diff));
	}
}