import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgo {

    public static void question1() {
        /*
         * Activity Selection Problem
         */

        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        /* sorting porcess in the case if end time is not sorted */
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function --> shortform
        // Yaha pe hum compiler ko bata rahe hai ki sorting kon se basis par karni hai.
        // Yaha pr sorting matrix ke column 2 ke basis pr hoti hai
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basisi sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                // activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max Activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void question2() {
        /*
         * Fractional knapsack
         * 
         */

        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;

        double ratio[][] = new double[val.length][2];
        /* index --> ratio */
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }
        // sorting in ascending order , but we need it in descending therefore reverse
        // loop
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalValue = 0;

        for (int i = val.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[i]) { // Including full item
                finalValue += val[idx];
                capacity -= weight[idx];
            } else {
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Final value is : " + finalValue);
    }

    public static void question3() {
        /* minmimum absolute difference */
        int A[] = { 1, 2, 3 };
        int B[] = { 2, 1, 3 };

        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minAbsDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("Minimum absoulute diff " + minAbsDiff);
    }

    public static void main(String[] args) {

    }
}
