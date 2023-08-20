import java.util.ArrayList;
import java.util.Collections;

public class ArrayListRevision {
    public static void introductionArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.remove(1);
        list.add(1, 10);
        System.out.println(list);
    }

    public static void multiDimensionalList() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list1.add(i * 4);
            list2.add(i * 5);
            list3.add(i * 7);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> curr = mainList.get(i);
            System.out.println(curr);
        }
    }

    public static void storeWater(ArrayList<Integer> list) {
        int storeWater = 0;
        int maxWater = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int ht = Math.min(list.get(i), list.get(j));
                int width = j - i;
                storeWater = ht * width;
                maxWater = Math.max(maxWater, storeWater);
            }
        }
        System.out.print(maxWater + " ");
    }

    public static void storeWater1(ArrayList<Integer> list) {
        int storeWater = 0, maxWater = Integer.MIN_VALUE;
        int lp = 0, rp = list.size() - 1;
        while (lp != rp) {
            int height = Math.min(list.get(lp), list.get(rp));
            int width = rp - lp;
            storeWater = height * width;
            maxWater = Math.max(maxWater, storeWater);

            if (list.get(lp) < list.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        System.out.println(maxWater);
    }

    public static boolean pairSum(ArrayList<Integer> list, int target) {
        Collections.sort(list);
        int lp = 0, rp = list.size() - 1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        int bp = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp;
        int rp = bp + 1;
        int n = list.size();
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (rp + n - 1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        multiDimensionalList();
    }
}