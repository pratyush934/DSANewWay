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
        return N & N - 1;
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

    public static void main(String[] args) {
        System.out.println(isPowerOf2(66));
    }
}
