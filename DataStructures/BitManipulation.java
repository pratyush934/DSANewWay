import java.util.ArrayList;
import java.util.List;

public class BitManipulation {
    public static String convert2Binary(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 1) {

            if (n % 2 == 1)
                sb.append(1);
            else
                sb.append(0);

            n /= 2;
        }
        sb.append(1);

        return sb.reverse().toString();
    }

    public static int conver2Numeric(String string) {
        int ans = 0;
        int n = string.length();
        for (int i = n - 1; i >= 0; i--) {
            ans += (string.charAt(i) - '0') * Math.pow(2, n - i - 1);
        }
        return ans;
    }

    public static void swap2Numbers(int a, int b) {
        a = a ^ b;
        b = a ^ b; // (a ^ b) ^ b = a
        a = a ^ b; // (a ^ b) ^ b = b

        System.out.println(a + "  " + b);
    }

    public static boolean isSetOrNot(int N, int index) {
        return (N & (1 << index)) != 0;
    }

    public static int setTheIth(int N, int index) {
        return (N | (1 << index));
    }

    public static int clearTheIth(int N, int index) {
        return (N & (~(1 << index)));
        // return (N ^ (1 << index));
    }

    public static int toggleTheIth(int N, int index) {
        return (N ^ (1 << index));
    }

    public static int lastSetBit(int N) {
        return (N & N - 1) & N;
    }

    public static boolean isPowerOf2(int N) {
        return ((N & (N - 1)) == 0);
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 1) {
            count += n & 1; // 1 or 0
            n >>= 1;
        }
        return count;
    }

    public static int countSetBits2(int n) {
        int count = 0;
        while (n > 1) {
            n = n & (n - 1);
            count++;
            n >>= 1;
        }
        return count;
    }

    public static int stepsToFlip(int start, int goal) {
        int endGame = start ^ goal;
        return countSetBits(endGame);
    }

    public List<List<Integer>> powerSet(List<Integer> arr) {
        int size = arr.size();
        int numberOfSubsets = (1 << size);
        List<List<Integer>> ans = new ArrayList<>();

        for (int num = 0; num < numberOfSubsets; num++) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if ((num & (1 << i)) == 1) {
                    list.add(arr.get(i));
                }
            }

            ans.add(list);
        }

        return ans;
    }

    public static int singleNumber(ArrayList<Integer> list) {

        int ans = 0;
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int count = 0;
            for (int i = 0; i < bitIndex; i++) {
                if ((list.get(i) & (i << bitIndex)) == 1) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                ans = ans | (1 << bitIndex);
            }
        }

        return ans;
    }

    public static int singleNumberII(int arr[]) {
        /*
         * O(NlogN) + O(n/3)
         */
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                return arr[i - 1];
            }
        }
        return arr[arr.length - 1];
    }

    public static int singleNumberIII(int arr[]) {
        /*
         * Bucket solution
         * O(n)
         */

        int ones = 0, twos = 0;
        for (int i : arr) {
            ones = (ones ^ i) & ~twos;
            twos = (twos ^ i) & ~ones;
        }

        return ones;

    }

    public static int[] singleNumberIV(int arr[]) {
        long xorr = 0;
        for (int i : arr) {
            xorr ^= i;
        }

        int rightMost = (int) ((xorr & xorr - 1) & xorr);
        int b1 = 0, b2 = 0;

        for (int i : arr) {
            if ((i & rightMost) != 0)
                b1 ^= i;
            else
                b2 ^= i;
        }
        /*
         * O(n+n)
         * O(1)
         */
        return new int[] { b1, b2 };
    }

    public static int XorInRange(int n) {
        if (n % 4 == 1)
            return 1;
        else if (n % 4 == 2)
            return 3;
        else if (n % 4 == 3)
            return 0;
        else
            return 4;
    }


    public static void main(String[] args) {
        System.out.println(lastSetBit(6));
    }

}
