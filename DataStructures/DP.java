import java.util.Arrays;
import java.util.HashSet;

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
        //learning dp is necessary

        // for (int i = 0; i < n + 1; i++) {
        //     for (int j = 0; j < L + 1; j++) { // Also a method for doing the same;
        //         if (i == 0 || j == 0) {
        //             dp[i][j] = 0;
        //         }
        //     }
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
            return lcs(str1, str2, n - 1, m - 1) + 1;
        }

        else {
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);

            return (int) Math.max(ans1, ans2);
        }
    }

    public static int lcsMemoization(String str1, String str2, int n, int m) {
        // n = str1.lenght(), m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        if (n == 0 || m == 0) {
            return 0;
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcsMemoization(str1, str2, n - 1, m - 1) + 1;
        }

        else {
            int ans1 = lcsMemoization(str1, str2, n - 1, m);
            int ans2 = lcsMemoization(str1, str2, n, m - 1);

            return dp[n][m] = (int) Math.max(ans1, ans2);
        }

    }

    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Because we are counting same character in longest subsequence
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = (int) Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int ans = 0;

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static int longestIncreasingSubsequence(int arr1[]) { // LIS wala sawaal
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[arr1.length];

        for (Integer eleInteger : set) {
            int i = 0;
            arr2[i] = eleInteger;
            i++;
        }

        Arrays.sort(arr2);

        return lscNew(arr1, arr2);
    }

    private static int lscNew(int[] arr1, int[] arr2) { // helper function for longestIncreasing subsequence
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // str1 ko convert karna hai str2 me

        int dp[][] = new int[n + 1][m + 1];

        // intializing
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same character
                    dp[i][j] = dp[i - 1][j - 1];

                } else { // differenct character
                    /*
                     * int add = dp[i][j-1] + 1;
                     * int del = dp[i-1][j-1] + 1;
                     * int replace = dp[i-1][j] + 1;
                     */
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[n][m];
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        // intialize
        dp[0][0] = true;

        // patern = " "
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // s = " "
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // bottom up code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // case1 --> ith char == jth char YAA jth char of p is ?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // case2 --> jth char of p is *
                else if (p.charAt(j - 1) == '*') {
                    // ignore kiya || include kiya
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];

    }

    public static int catlanRecursion(int n) {
        if (n == 0 || n == 1)
            return 1;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += catlanRecursion(i) * catlanRecursion(n - i - 1);
        }

        return ans;
    }

    public static int catlanMemoization(int n, int dp[]) {
        Arrays.fill(dp, -1);

        if (n == 0 || n == 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int ans = 0;

        for (int i = 0; i < n; i++)
            ans += catlanMemoization(i, dp) * catlanMemoization(n - i - 1, dp);

        return dp[n] = ans;

    }

    public static int catlanTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) { // Ci
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // Ci = Cj + Cj-i-1;
            }
        }

        return dp[n];
    }

    public static int countBST(int n, int dp[]) {
        Arrays.fill(dp, -1);

        if (n == 0 || n == 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += countBST(i, dp) + countBST(n - i - 1, dp);
        }

        return dp[n] = ans;
    }

    public static int countBSTTabulation(int n) {
        // count BST follows catlan patterns
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // total number += leftNodes arrangement + RightNodes arrangement;
                /*
                 * int left = dp[j];
                 * int right = dp[i-j-1];
                 * dp[i] = left + right;
                 */
                dp[i] += dp[j] + dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static int mountainRanges(int n, int dp[]) {
        Arrays.fill(dp, -1);

        if (n == 0 || n == 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += mountainRanges(i, dp) * mountainRanges(n - i - 1, dp);
        }

        return dp[n] = ans;

    }

    public static int mountainRangesTab(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                /*
                 * int leftMountains = dp[j];
                 * int rightMountains = dp[i-j-1];
                 * total mountains = leftMountains + rightMountains
                 */
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static int mcm(int arr[], int i, int j) {
        if (i == j)
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j - 1; k++) {
            int cost1 = mcm(arr, i, k); // Ai...Ak ==> arr[i-1] * arr[k]
            int cost2 = mcm(arr, k + 1, j); // Ai+1...Aj ==> arr[k] * arr[j]

            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans;
    }

    public static int mcmMemoization(int arr[], int i, int j, int dp[][])/* arr.length -> n */ {

        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemoization(arr, i, k, dp);
            int cost2 = mcmMemoization(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

    public static int mamTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (i == j)
                    dp[i][j] = 0;
        }

        // bottom-up
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k - 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        // print(dp);
        return dp[1][n - 1];
    }

    public static void question5() {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int s = 0; s < n; s++) {
            Arrays.fill(dp[s], -1);
        }
    }

    public static int minimumJumps(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(nums, -1);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }

            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

    }
}
