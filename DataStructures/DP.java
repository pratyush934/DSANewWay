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

    public static void question2() {
        System.out.println(countWays(5));

        int n = 5;
        int dp[] = new int[n];
        System.out.println(countWaysMemoization(n, dp));
        
    }

    public static void main(String[] args) {

    }
}
