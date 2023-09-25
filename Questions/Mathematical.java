package Questions;



public class Mathematical {

    public static long summedMatrix(long n, long q) {
        if (2 * n < q)
            return 0;
        else
            return (long) (n - Math.abs((n + 1) - q));
    }

    public static int test1() {
        return 0;
    }

    public static void main(String[] args) {

    }
}