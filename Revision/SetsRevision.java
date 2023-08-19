import java.util.HashMap;
import java.util.HashSet;

import javax.print.DocFlavor.CHAR_ARRAY;

public class SetsRevision {
    public static void unionandIntersection() {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        System.out.println(hs.size());
        System.out.println(hs);

        hs.clear();

        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                count++;
                System.out.print(arr2[i] + " ");
                hs.remove(arr2[i]);
            }
        }
        System.out.println("Intersection " + count);
    }

    public static String getStartingCity(HashMap<String, String> tickets) {
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

    public static void ticketsQuestion() {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String startCity = getStartingCity(tickets);
        System.out.print(startCity);
        for (String key : tickets.keySet()) {
            System.out.print("-->" + tickets.get(startCity));
            startCity = tickets.get(startCity);
        }
    }

    public static void largestSubarraywith0() {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(len);
    }

    public static void largestSubarraywithK() {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            } else {
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }
        }
        System.out.println(ans);
    }

    
    public static void main(String[] args) {
        ticketsQuestion();
    }
}