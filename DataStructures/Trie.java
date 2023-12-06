public class Trie {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static void mainMethodForLearingTrie() {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("there"));
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            // substring(0, i) // last index is excluded in this function
            /*
             * first we will check for the substring of 0 to 1 then recursively call all
             * other
             * if any of them return false --> then fucntion will return false;
             */

            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static void wordBreakProblem() {
        String[] words = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // creating trie for string
        /*
         * 1. use a loop for trie
         * 2. insert each word in a trie
         * 3. use existing method that is already inbuilt
         */
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }

    static class NewNode {
        NewNode[] children = new NewNode[26];
        boolean eow = false;
        int freq;

        public NewNode() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static NewNode newRoot = new NewNode();

    public static void insertNew(String word) {
        NewNode curr = newRoot;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new NewNode();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(NewNode root, String ans) {

        if (root == null)
            return;

        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void prefixProblem() {
        String words[] = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < words.length; i++) {
            insertNew(words[i]);
        }

        newRoot.freq = -1;
        findPrefix(newRoot, "");
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;
        /*
         * Running a loop to scan an elment
         */
        for (int level = 0; level < prefix.length(); level++) {
            int idx = prefix.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];

        }
        return true;
    }

    public static void startWithProblem() {
        String words[] = { "apple", "app", "mango", "man", "woman" };
        String prefix1 = "app";
        String preftix2 = "moon";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(startsWith(prefix1));
        System.out.println(startsWith(preftix2));
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void countUniqueSuffix() {
        String str = "ababa";

        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        /* If in any case root is null then ye case hai jo laagu hoga */
        if (root == null)
            return;

        /* Just looking for each and every element in the array if it is not null and it  constitues a word the add it in temp string
         * and if temp.length is greater than ans.length add it in ans string
         * recursively solve for the next root
         * uske baad agar saara solve ho jaaye matlab ki agar aap last node pr pahuch gaye to backtracking karke wapas jana hoga
         * 
        */
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                // backtracking
                temp.deleteCharAt(temp.length() - 1);
            }
        }
        /* agar aapko apply chahiye apple ki jagah to bs loop ko reverse kar dijiye */
    }

    public static void longestWordwithAllPrefix() {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }

    public static void main(String[] args) {
        longestWordwithAllPrefix();
    }
}
