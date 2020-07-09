package Fibonacci;
import java.util.*;

public class Main {
	
	public static int fibo(int n) {
		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = 1;

		for(int i = 2; i < n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];

		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(fibo(5));
	}
}