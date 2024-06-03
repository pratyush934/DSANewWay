import java.util.*;

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

    static class Jobs {
        int id;
        int profit;
        int deadLine;

        public Jobs(int id, int profit, int deadLine) {
            this.id = id;
            this.profit = profit;
            this.deadLine = deadLine;
        }
    }

    public static void jobSequencing() {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Jobs> list = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            list.add(new Jobs(i, jobsInfo[i][1], jobsInfo[i][0]));
        }

        /*
         * sorting things in descending order
         */
        Collections.sort(list, (o1, o2) -> o2.profit - o1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < list.size(); i++) {
            Jobs curr = list.get(i);
            if (curr.deadLine > time) {
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println(seq.size());
        System.out.println(seq);
    }

    public static int nMeetingInOneRow() {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        int matrix[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            matrix[i][0] = i;
            matrix[i][1] = start[i];
            matrix[i][2] = end[i];
        }

        Arrays.sort(matrix, Comparator.comparingDouble(o -> o[2]));
        ArrayList<Integer> list = new ArrayList<>();
        int maxAct = 1;
        list.add(matrix[0][0]);
        int lastEnd = matrix[0][2];
        for (int i = 0; i < start.length; i++) {
            if (lastEnd <= matrix[i][1]) {
                maxAct++;
                list.add(matrix[i][0]);
                lastEnd = matrix[i][2];
            }
        }
        System.out.println(list);
        return maxAct;
    }

    public static int nonOverlappingIntervals() {

        int start[] = { 0, 3, 1, 5, 5, 7 };
        int end[] = { 5, 4, 2, 9, 7, 9 };

        int matrix[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            matrix[i][0] = i;
            matrix[i][1] = start[i];
            matrix[i][2] = end[i];
        }

        Arrays.sort(matrix, Comparator.comparingDouble(o -> o[2]));

        int maxCount = 1;
        int endPoint = matrix[0][2];
        for (int i = 0; i < start.length; i++) {
            if (matrix[i][1] >= endPoint) {
                maxCount++;
                endPoint = matrix[i][2];
            }
        }
        return start.length - maxCount;
    }

    public static void main(String[] args) {
        /* System.out.println(jumpGamePartII(new int[] { 2, 3, 1, 4, 1, 1, 1, 2 })); */
        // jobSequencing();
        System.out.println(nonOverlappingIntervals());
    }
}
