import java.util.ArrayList;
import java.util.Collections;

public class ArrayListRevision {
    public static void introduction() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        list.remove(3);
        list.add(2, 5);

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }

    public static void multiDimensionalList() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list1.add(i * 3);
            list2.add(i * 5);
            list3.add(i * 7);
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        for (int i = 0; i < mainList.size(); i++) {
            System.out.println(mainList.get(i));
        }
    }

    public static void maxWater(ArrayList<Integer> height) {
        int currWater = 0, maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wt = j - i;
                currWater = ht * wt;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        System.out.println(maxWater);
    }

    public static void maxWater1(ArrayList<Integer> height) {
        int currWater = 0, maxWater = 0;
        int lp = 0, rp = height.size() - 1;
        while (lp <= rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int wt = rp - lp;
            currWater = ht * wt;
            maxWater = Math.max(currWater, maxWater);
            if (height.get(lp) < height.get(rp))
                lp++;
            else
                rp--;
        }
        System.out.println("MaxWater is : " + maxWater);
    }

    public static boolean pairSum1(ArrayList<Integer> list, int key) {
        int lp = 0, rp = list.size() - 1;
        while (lp <= rp) {
            if (list.get(lp) + list.get(rp) == key)
                return true;
            else if (list.get(lp) + list.get(rp) > key)
                lp++;
            else
                rp--;
        }
        return false;
    }

    public static boolean pairSumPivoted(ArrayList<Integer> list, int key) {
        int bp = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp;
        int rp = bp + 1;
        int size = list.size() - 1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == key)
                return true;
            else if (list.get(lp) + list.get(rp) > key)
                lp = (lp + 1) % size;
            else
                rp = (rp + size - 1) % size;
        }
        return false;
    }

    public static void main(String[] args) {
        multiDimensionalList();
    }
}