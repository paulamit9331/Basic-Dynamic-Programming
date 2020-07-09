package UnboundedKnapsack;
import java.util.*;
import java.math.*;

public class Main2 {
	
	public static int knapsack(int[] wt, int[] val, int w, int n) {
		int[][] dp = new int[n + 1][w + 1];
		for(int i = 0; i < n + 1; i++) {			// base condition and initialization of 1st row & column
			for(int j = 0; j < w + 1; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				
				else if(wt[i - 1] <= j)		// if we choose, we may choose again so element count won't decrease
					dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
				else    					// if we don't choose we won't choose again
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][w];
	}

	public static void main(String[] args) {
		int[] wt = new int[] {1, 3, 4, 5};
		int[] val = new int[] {1, 4, 5, 7};
		int w = 10;

		System.out.println(knapsack(wt, val, w, wt.length));
	}
}