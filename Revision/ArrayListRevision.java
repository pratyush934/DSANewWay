import java.util.ArrayList;
import java.util.Collections;

public class ArrayListRevision {

    public static void introductionToArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(2, 20);
        System.out.println(list);
        list.remove(list.get(1));
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
            list2.add(i * 4);
            list3.add(i * 7);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        for(int i=0; i<mainList.size(); i++) {
            ArrayList<Integer> cuArrayList = mainList.get(i);
            System.out.println(cuArrayList);
        }
        System.out.println();
    }

    public static int storeWater(ArrayList<Integer> list) {
        int maxWater = 0;
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                int height = Math.min(list.get(i), list.get(j)) ;
                int width = j - i;
                int storeWater = height * width;
                maxWater = Math.max(maxWater, storeWater);
            }
        }
        return maxWater;
    }

    public static int storeWater1(ArrayList<Integer> list) {
        int maxWater = 0;
        int lp = 0;
        int rp = list.size()-1;
        while(lp != rp) {
            int height = Math.min(list.get(lp), list.get(rp));
            int width = rp - lp;
            int currWater = height*width;
            maxWater = Math.max(maxWater, currWater);

            if(list.get(lp) < list.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        /* Only for sorted array */
        Collections.sort(list);
        int lp = 0, rp = list.size()-1;
        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            } else if(list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSumPivoted(ArrayList<Integer> list, int target) {
        int bp = -1;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }
        int lp = bp+1;
        int rp = bp;
        int n = list.size();
        while(lp != rp) {
            if(list.get(lp)+list.get(rp) == target) {
                return true;
            } else if(list.get(lp)+list.get(rp) < target) {
                lp = (lp+1) % n;
            } else {
                rp = (rp+n-1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
                
    }
}