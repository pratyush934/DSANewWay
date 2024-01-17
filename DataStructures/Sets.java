/*
 * Collection of unique element
 * HahsSet HahsMap se implement hota hai.
 * unordered.
 * NULL is allowed.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Sets {

    public static void introducingHashSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);

        System.out.println(set);

        set.remove(2);

        System.out.println(set);

        System.out.println(set.size());

        set.clear();

        System.out.println(set);
        System.out.println(set.isEmpty());
    }

    public static void itreatorHashSet() {
        /*
         * Using Iterator
         * Unsing Enhanced for loop
         */

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        for (Integer integer : set) {
            System.out.println(integer);
        }

    }

    public static void introducingLinkedHashSet() {

        /*
         * As it is print ho jayega
         * Less performable as compare to Hashmap
         */
        LinkedHashSet<String> ll = new LinkedHashSet<>();
        ll.add("Great");
        ll.add("Not So Great");
        ll.add("Huhu");
        ll.add("Accha");
        ll.add("Humko Sikha rhia hai");
        ll.add("Kuku");

        for (String string : ll) {
            System.out.println(string);
        }
    }

    public static void introducingTreeSet() {
        /*
         * always in sorted order
         * time complexity O(logN)
         */
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Noida");
        ts.add("Banglore");
        ts.add("Null");

        System.out.println(ts);
    }

    public static void countDistinct() {
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            hs.add(num[i]);
        }
        System.out.println(hs.size());
    }

    public static void union() {
        /*
         * Union ->
         * Intersection ->
         */
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };

        // union
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println(set.size());
        System.out.println(set);

        set.clear();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
                System.out.println(arr2[i]);
            }
        }
        System.out.println(count);
    }

    public static String getStart(HashMap<String, String> tickets) {

        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void mainQ1() {
        
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print("-->"+tickets.get(start));
            start = tickets.get(start);
        }
    }

    public static void largestSubarraywith0() {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, len = 0;
        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum)) {
                len = Math.max(len, j-map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        System.out.println(len);
    }

    public static void largestSubarraywithK() {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;

        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k); 
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);
        // Leetcode 2 sum problem is great
    }
    public static void main(String[] args) {
        largestSubarraywithK();
    }
}
