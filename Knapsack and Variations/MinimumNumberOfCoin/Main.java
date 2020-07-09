package MinimumNumberOfCoin;
import java.util.*;

public class Main {
	
	public static int minimumNumberOfCoin(int[] coin, int n, int sum) {
		int[] dp = new int[sum + 1];
		table[0] = 0;

		for(int i = 1; i < sum + 1; i++)
			dp[i] = Integer.MAX_VALUE;

		for(int i = 1; i < sum + 1; i++) {
			for(int j = 0; j < n; j++) {
				if(coin[j] <= i) {
					int subResult = dp[i - coin[j]];
					if(subResult != Integer.MAX_VALUE && subResult + 1 < dp[i])
						dp[i] = subResult + 1;
				}
			}
		}
		return dp[sum];
	}

	public static void main(String[] args) {
		int[] coin = new int[] {1, 2, 3};
		int sum = 5;

		System.out.println(minimumNumberOfCoin(coin, coin.length, sum));
	}
}