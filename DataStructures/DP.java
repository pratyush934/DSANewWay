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

    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
            ;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1]; // ith item value;
                int w = wt[i - 1];

                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }

            }
        }
        // try to print the dp array
        return dp[n][W];
    }

    public static void question3() {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsack(val, wt, W, val.length));

        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackMemoization(val, wt, W, val.length, dp));

        System.out.println(knapsackTabulation(val, wt, W));
    }

    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; i++) {
                int v = arr[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }

    public static void question4() {
        int arr[] = { 4, 2, 7, 1, 3 };
        int sum = 10;
        System.out.println(targetSumSubset(arr, sum));
    }

    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0; // Intialization
        }

        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < W + 1; j++) {
                if (wt[i - 1] <= j) { // valid
                                      // include //exclude
                    dp[i][j] = Math.max((val[i - 1] + dp[i][j - wt[i - 1]]), dp[i - 1][j]);
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static int coinChange(int coins[], int sum) {
        int dp[][] = new int[coins.length + 1][sum + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < coins.length + 1; i++) { // O(coins.length * sum)
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) { // valid
                    // include and exclude
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else { // invalid
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][sum];
    }

    public static int rodCutting(int length[], int price[], int L) {
        int n = price.length;
        int dp[][] = new int[n + 1][L + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }

        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < L + 1; j++) { // Also a method for doing the same;
        // if (i == 0 || j == 0) {
        // dp[i][j] = 0;
        // }
        // }
        // }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < L + 1; j++) {
                if (length[i - 1] <= j) { // valid
                    // included and //excluded
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else { // invalid
                    // excluded
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][L];
    }

    public static int lcs(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs(str1, str2, n - 1, m - 1);
        }

        else {
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);

            return (int) Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {

    }
}
