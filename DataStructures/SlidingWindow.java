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

    public static int maxContinous1(int arr[], int k) {
        /*
         * 
         * Brute force approach
         */
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int zeroes = 0;
            innerLoop: for (int j = i; j < arr.length; j++) {

                if (arr[j] == 0) {
                    zeroes++;
                }

                if (zeroes <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break innerLoop;
                }
            }
        }
        return maxLength;
    }

    public static int maxContinous1Part2(int arr[], int k) {
        int lp = 0, rp = 0, maxLength = 0, zeroes = 0;

        while (rp < arr.length) {

            if (arr[rp] == 0)
                zeroes++;

            while (zeroes > k) {
                if (arr[lp] == 0)
                    zeroes--;
                lp++;
            }
            if (zeroes <= k)
                maxLength = Math.max(maxLength, rp - lp + 1);
            rp++;
        }
        return maxLength;
    }

    public static int maxContinous1Part3(int arr[], int k) {

        int rp = 0, lp = 0, maxLength = Integer.MIN_VALUE, zeroes = 0;

        while (rp < arr.length) {

            if (arr[rp] == 0) {
                zeroes++;
            }

            if (zeroes >= k) {

                if (arr[lp] == 0) {
                    zeroes--;
                }

                lp++;
            }

            rp++;

            maxLength = Math.max(maxLength, rp - lp + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        System.out.println(maxContinous1Part3(arr, 2));

    }
}