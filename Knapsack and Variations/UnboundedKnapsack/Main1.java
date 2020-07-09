package UnboundedKnapsack;
import java.util.*;
import java.math.*;

public class Main1 {		// Memoization approach
	
	public static int knapsack(int[] wt, int[] val, int w, int n, int[][] dp) {
		if(n == 0 || w == 0)
			return 0;
		if(dp[n][w] != -1)
			return dp[n][w];

		if(wt[n - 1] <= w)		// if we choose	we may choose again												// if we don't choose
			return dp[n][w] = Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n, dp), knapsack(wt, val, w, n - 1, dp));
		else
			return dp[n][w] = knapsack(wt, val, w, n - 1, dp);		// wt[n - 1] > w    so we can't choose
	}

	public static void main(String[] args) {
		int[] wt = new int[] {1, 3, 4, 5};
		int[] val = new int[] {1, 4, 5, 7};
		int w = 10;

		int[][] dp = new int[wt.length + 1][w + 1];

		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++)
				dp[i][j] = -1;
		}

		System.out.println(knapsack(wt, val, w, wt.length, dp));
	}
}