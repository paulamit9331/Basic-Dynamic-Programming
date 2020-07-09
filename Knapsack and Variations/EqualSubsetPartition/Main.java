package EqualSubsetPartition;
import java.util.*;

public class Main {

	public static int sum(int[] array) {
		int sum = 0;
		for(int i : array)
			sum += i;

		return sum;
	}
	
	public static boolean isEqualSumPresentInPartition(int[] array, int n, int sum) {
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
		int sum = sum(array);

		if(sum % 2 != 0)
			System.out.println("NO");
		else {
			if(isEqualSumPresentInPartition(array, array.length, sum / 2))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}