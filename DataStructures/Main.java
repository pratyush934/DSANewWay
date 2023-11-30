import java.io.*;
import java.util.*;

public class Main {
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
    }

    static class FastOutput {
        BufferedWriter bw;

        public FastOutput() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        void print(String str) {
            try {
                bw.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String str) {
            try {
                bw.write(str);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void flush() {
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void println(int i) {
            try {
                bw.write(i);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Solution() {

        FastScanner in = new FastScanner();
        FastOutput out = new FastOutput();

        // Your code here
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            out.println(a + b);
            out.println(a - b);
            out.println(a * b);

        }

        out.flush();
    }

    public static void main(String[] args) {
        Solution();
    }
}
