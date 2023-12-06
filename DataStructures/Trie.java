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

        return curr.eow = true;
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

    public static void main(String[] args) {
        wordBreakProblem();
    }
}
