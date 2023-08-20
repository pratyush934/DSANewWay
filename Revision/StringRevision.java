public class StringRevision {

    public static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome1(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'N')
                y++;
            else if (ch == 'S')
                y--;
            else if (ch == 'E')
                x++;
            else
                x--;
        }
        return (float) (Math.sqrt(x * x + y * y));
    }

    public static String upperCaseString(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compressString(String str) {
        StringBuffer sb = new StringBuffer();
        Integer count = 1;
        for(int i=0; i<str.length(); i++) {
            count = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1) ) {
                i++;
                count++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaannccc"));
    }
}