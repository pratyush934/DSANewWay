package DSA_BOOK.GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Notes
 * 
 */

public class GreedyAlpha {

  public static void activitySelection() {
    /**
     * Activity Selection
     * Max meetings in room
     * Disjoint set
     */

    /**
     * Aapko kaise pata chal raha hai ki greedy ka question hai.
     * ki har ek step aap ye soch rahe ho ki kaise main jaldi kaam khatam karu taaki
     * mereko naya kaam mile
     */

    /**
     * to isko end time ke hisaab se sort kar de.
     * kaise hoga chaliye dekhte hai.
     */

    /**
     * 1. end time ko base bana kar sort kare (kyuki jaldi khtm hoga to jyada kaam
     * karnege)
     * 2. end time jiska kam ho uske select kare
     * 2. non-overlapping (disjoint) -> starttime >= last chosen activity
     * 4. count++;
     */

    int start[] = { 1, 3, 0, 5, 8, 5 };
    int end[] = { 2, 4, 6, 7, 9, 9 };

    int maxAct = 0;
    ArrayList<Integer> list = new ArrayList<>();

    maxAct = 1;
    list.add(0);
    int lastEnd = end[0];
    for (int i = 1; i < end.length; i++) {
      if (start[i] >= lastEnd) {
        maxAct++;
        list.add(i);
        lastEnd = end[i];
      }
    }

    System.out.println(maxAct);

  }

  public static void activitySelection2() {

    int start[] = { 1, 3, 0, 5, 8, 5 };
    int end[] = { 2, 4, 6, 7, 9, 9 };
    /**
     * Lekin aisa jaruri nahi ki end[] hamesa sorted ho.
     * to thodi tikdambaazi karenge.
     */

    int activity[][] = new int[start.length][3];
    for (int i = 0; i < start.length; i++) {
      activity[i][0] = i;
      activity[i][1] = start[i];
      activity[i][2] = end[i];
    }
    Arrays.sort(activity, Comparator.comparingDouble(o -> o[2])); // sorting column number 2 pr hoti hai

    ArrayList<Integer> list = new ArrayList<>();
    int maxAct = 0;
    list.add(activity[0][0]);
    int lastEnd = activity[0][2];

    for (int i = 1; i < end.length; i++) {
      if (activity[i][1] >= lastEnd) {
        maxAct++;
        list.add(activity[i][0]);
        lastEnd = activity[i][2];
      }
    }
    System.out.println(maxAct);
  }

  public static void fractionalKnapsack() {
    /**
     * Look at the question
     */

    /**
     * value = [60, 100, 120]
     * weight = [10, 20, 30]
     * 
     * To isme do chizo ka dhyan rakhna hai
     * 1. Weight kam se kam ho
     * 2. value jyada se jyada ho
     * 
     * to uske liye hum ratio ko use kar rahe honge {value / weight}
     */
    int value[] = { 60, 100, 120 };
    int weight[] = { 10, 20, 30 };
    int W = 50;
    int cost = 0;
    double ratio[][] = new double[value.length][2];

    for (int i = 0; i < value.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = (double)(value[i]/weight[i]);
    }

    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
    for(int i=value.length-1; i>=0; i--) {
      int idx = (int)ratio[i][0];

      if(W >= weight[idx]) {
        /**
         * Including the proper cost
         */
        cost += value[idx];
        W -= weight[idx];
      } else {
        cost += (ratio[i][1] * W);
        W = 0;
        break;
      }
    }

    System.out.println(cost);

  }
L
  public static void main(String[] args) {

  }
}
