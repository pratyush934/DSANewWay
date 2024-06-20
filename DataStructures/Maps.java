import java.util.*;

public class Maps {

    public static void introducingMaps() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 123);
        hm.put("Nepal", 1234);
        hm.put("Bhutan", 12);

        System.out.println(hm);
        System.out.println(hm.get("Nepal"));
        System.out.println(hm.containsKey("Bhutan"));
        System.out.println(hm.remove("China"));
        System.out.println(hm);
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());

        System.out.println(hm.keySet());
        System.out.println(hm.values());

        Set<String> keys = hm.keySet();
        System.out.println(keys);
    }

    public static void introducingMapsIteration() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 123);
        hm.put("Nepal", 1234);
        hm.put("Bhutan", 12);

        Set<String> keys = hm.keySet();

        for (String k : keys) {
            System.out.println("Keys are " + k + " and values are " + hm.get(k));
        }
    }

    public static void introducingLinkedHashMap() {
        /*
         * keys are insertion ordered
         * Array ke bhiter DoublyLinkedList
         */
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 123);
        lhm.put("China", 1234);
        lhm.put("Us", 12);

        System.out.println(lhm);
    }

    public static void introducingTreeMap() {
        /*
         * keys are sorted
         * put, get, remove are O(logn)
         * Red Black Tree for basic Implmentation
         */
    }

    public static void majorityElements() {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            // map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        }

        Set<Integer> kSet = map.keySet();
        for (Integer key : kSet /*map.keySet()*/) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    public static void isAnagram(String str1, String str2) {
        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();

        if(arr1.length != arr2.length) {
            System.out.println("Fool");;
        } else {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            // str1 = arr1.toString();
            // str2 = arr2.toString();
            if(Arrays.equals(arr1, arr2)) {
                System.out.println("Bravo");
            }
        }
        
    }

    
    public static boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<t.length(); i++) {
            if(map.get(t.charAt(i)) != null) {
                if(map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i))-1);
                }
            } else {
                return false;
            }
        }
        return (map.isEmpty());
    }
    public static void main(String[] args) { 
        System.out.println(isAnagram1("earth", "heart"));
        
       
    }
}
