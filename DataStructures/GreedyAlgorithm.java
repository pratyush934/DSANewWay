import java.util.Arrays;

public class GreedyAlgorithm {

    public static int assignCookie(int greedy[], int size[]) {
        int n = greedy.length;
        int m = size.length;

        Arrays.sort(greedy);
        Arrays.sort(size);

        int left = 0, right = 0;

        while (left < m && right < n) {
            if (greedy[right] <= size[left]) {
                right++;
            }
            left++;
        }
        return right;
    }

    public static boolean lemonade(int arr[]) {
        int five = 0, ten = 0;
        // int twenty = 0; not necessary

        for (int i : arr) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                ten++;
                if (five > 1)
                    five--;
                else
                    return false;
            } else if (i == 20) {
                if (ten > 1 && five > 1) {
                    five--;
                    ten--;
                } else if (five > 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static int shortesJobFirst(int arr[]) {
        Arrays.sort(arr);
        int prefix[] = new int[arr.length];
        prefix[0] = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int average = 0;
        for (int i : prefix) {
            // System.out.println(i);
            average += i;
        }
        // System.out.println(average);
        return average / arr.length;
    }

    public static int shortesJobFirstPartII(int arr[]) {

        Arrays.sort(arr);
        int wt = 0;
        int t = 0;

        for (int i = 0; i < arr.length; i++) {
            wt += t;
            t += arr[i];
        }
        System.out.println(wt);
        System.out.println(t);

        return wt / arr.length;
    }

    public static boolean jumpGame(int arr[]) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i > max) {
                return false;
            }

            max = Math.max(max, i + arr[i]);
        }

        return true;
    }

    public static int jumpGamePartII(int arr[]) {
        
        int right = 0, left = 0, jumps = 0;

        int n = arr.length;

        while (right < n) {

            int far = 0;

            for (int i = left; i <= right; i++) {
                far = Math.max(far, arr[i] + right);
            }

            left = right + 1;
            right = far;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jumpGamePartII(new int[] { 2, 3, 1, 4, 1, 1, 1, 2 }));
    }
}
