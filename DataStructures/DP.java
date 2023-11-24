public class DP {

    public static int fib(int n, int f[]) {

        //Memoization (Top Down Approach)
        
        if (n == 0 || n == 1)
            return n;

        if (f[n] != 0) {
            return f[n];
        }

        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];

    }

    public static void question1() {
        int n = 5;
        int f[] = new int[n];
        System.out.println(fib(n, f));
    }


    public static void main(String[] args) {

    }
}
