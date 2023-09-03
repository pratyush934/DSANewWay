import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class MapsRevision {

    public static void introducingMaps() {
        /*
         * RANDOM ORDER ME PRINT HOGA
         */
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 145);
        hm.put("China", 145);
        hm.put("USA", 32);
        hm.put("Nepal", 5);
        hm.put("Israel", 1);

        System.out.println(hm);
        // System.out.println(hm.containsKey("USSR"));
        // hm.remove("USA");
        // hm.putIfAbsent("USA", 123);
        // System.out.println(hm.size());
        // hm.putIfAbsent("USSR", 20);
        // System.out.println(hm);

        // System.out.println(hm.keySet());
        // System.out.println(hm.values());
        // System.out.println(hm.size());
        // System.out.println(hm.isEmpty());
    }

    public static void introducingLinkedHashMap() {
        /*
         * JIS ORDER ME DAALOGE US ORDER ME HI PRINT HOGA
         * IMPLEMNTATION ME ARRAY KE BHITER DOUBLE LINKEDLIST (HAHAHAH...)
         */
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 145);
        lhm.put("China", 145);
        lhm.put("USA", 32);
        lhm.put("Nepal", 5);
        lhm.put("Israel", 1);

        System.out.println(lhm);
    }

    public static void introducingTreeMap() {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 145);
        tm.put("China", 145);
        tm.put("USA", 32);
        tm.put("Nepal", 5);
        tm.put("Israel", 1);

        System.out.println(tm);
    }

    public static void iterationHahsMap() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 145);
        hm.put("China", 145);
        hm.put("USA", 32);
        hm.put("Nepal", 5);
        hm.put("Israel", 1);

        Set<String> hs = hm.keySet();
        for (String string : hs) {
            System.out.println("Keys are : " + string + " and their respective values are " + hm.get(string));
        }

    }

    public static void majorityElements() {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Integer keyInteger : map.keySet()) {
            if (map.get(keyInteger) > arr.length / 3) {
                System.out.println(keyInteger + " and " + map.get(keyInteger));
            }

        }
    }

    public static boolean isAnagram(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str2.charAt(i), 0)+1);
        }

        for(int i=0; i<str2.length(); i++) {
            if(map.get(str2.charAt(i)) != null) {
                if(map.get(str2.charAt(i)) == 1) {
                    map.remove(str2.charAt(i));
                } else {
                    map.put(str2.charAt(i), map.get(str2.charAt(i))-1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {

    }
}
