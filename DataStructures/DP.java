import java.util.Arrays;

public class DP {

    public static int fib(int n, int f[]) {

        // Memoization (Top Down Approach)

        if (n == 0 || n == 1)
            return n;

        if (f[n] != 0) {
            return f[n];
        }

        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];

    }

    public static int fibTabulation(int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, 0);

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void question1() {
        int n = 5;
        int f[] = new int[n];
        System.out.println(fib(n, f));
        System.out.println(fibTabulation(n));
    }

    public static int countWays(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        return countWays(n - 1) + countWays(n - 1);
    }

    public static int countWaysMemoization(int n, int dp[]) {
        Arrays.fill(dp, -1);

        if (n == 0)
            return 1;
        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = countWaysMemoization(n - 1, dp) + countWaysMemoization(n - 2, dp);

        return dp[n];
    }

    public static int countWaysTabular(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else
                dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void question2() {
        /* Counting the ways in which you can reach top using steps */
        System.out.println(countWays(5));

        int n = 5;
        int dp[] = new int[n];
        System.out.println(countWaysMemoization(n, dp));

        System.out.println(countWaysTabular(n));

    }

    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= 0) { // valid
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack(val, wt, W, n - 1);

            return Math.max(ans1, ans2);
        } else { // not-valid
            return knapsack(val, wt, W, n - 1);
        }
    }

    public static int knapsackMemoization(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapsackMemoization(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsackMemoization(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapsackMemoization(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static void question3() {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsack(val, wt, W, val.length););
        

        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackMemoization(val, wt, W, val.length, dp););
        
    }

    public static void main(String[] args) {

    }
}
