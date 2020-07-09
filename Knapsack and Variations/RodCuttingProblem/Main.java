package RodCuttingProblem;
import java.util.*;
import java.math.*;

public class Main {
	
	public static int maxProfit(int len[], int[] price, int n, int totalLen) {
		int[][] dp = new int[n + 1][totalLen + 1];
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < totalLen + 1; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				
				else if(len[i - 1] <= j)
					dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][totalLen];
	}

	public static void main(String[] args) {
		int[] len = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		int[] price = new int[] {1, 5, 8, 9, 10, 17, 19, 20};
		int totalLen = 8;

		System.out.println(maxProfit(len, price, len.length, totalLen));
	}
}