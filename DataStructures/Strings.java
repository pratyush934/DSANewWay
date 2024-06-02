
public class Strings {

    public static boolean palindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean palindrome1(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static double shortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'N')
                y++;
            else if (ch == 'S')
                y--;
            else if (ch == 'W')
                x--;
            else
                x++;
        }
        double shortestPath = Math.sqrt((int) x * x + (int) y * y);
        return shortestPath;
    }

    public static void compare() {
        String fruits[] = { "apple", "mango", "banana" };exi
        String largest = fruits[0];
        for (int i = 0; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }

    public static String upperCaseString(String str) {
        StringBuffer sb = new StringBuffer();
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length(); i++) {
            Integer count = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabc"));
    }
}
