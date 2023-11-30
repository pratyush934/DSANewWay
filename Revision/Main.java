import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void Solution() {

        FastScanner scanner = new FastScanner();

        // Your code goes here
        int t = scanner.nextInt();
        while (t-- > 0) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            scanner.print((int)(a + b));
            scanner.print((int)(b - a));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Solution();
    }

    // FastScanner class for fast input reading
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void print(String s) {
            System.out.print(s);
        }

        void println(String s) {
            System.out.println(s);
        }

        void print(int num) {
            System.out.print(num);
        }

        void println(int num) {
            System.out.println(num);
        }

        void print(long num) {
            System.out.print(num);
        }

        void println(long num) {
            System.out.println(num);
        }

        void print(double num) {
            System.out.print(num);
        }

        void println(double num) {
            System.out.println(num);
        }

        // Add more print methods for other data types as needed

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
