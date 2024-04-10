import java.util.Arrays;

public class SlidingWindow {

    public static int maximumPoints(int arr[], int k) {
        /*
         * arr = [6, 2, 3, 4, 2, 1, 7, 1]
         * k = 4
         */

        int lSum = 0, maxSum = 0, rSum = 0;

        for (int i = 0; i < k; i++) {
            lSum += arr[i];
        }
        maxSum = lSum;

        int rightIndex = arr.length - 1;

        for (int i = k - 1; i >= 0; i--) {
            lSum -= arr[i];
            rSum += arr[rightIndex];
            rightIndex--;

            maxSum = Math.max(maxSum, (lSum + rSum));
        }

        return maxSum;
    }

    public static int subString(String str) {
        int hash[] = new int[256];
        Arrays.fill(hash, -1);

        int n = str.length();

        int r = 0, l = 0;
        int max = 0;
        while (r < n) {

            if (hash[str.charAt(r) - '0'] != -1) {
                if (hash[str.charAt(r) - '0'] >= l) {
                    l = hash[str.charAt(r) - '0'] + 1;
                }
            }

            int len = r - l + 1;
            max = Math.max(max, len);
            hash[str.charAt(r) - '0'] = r++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(subString("cadbzabcd"));
    }
}