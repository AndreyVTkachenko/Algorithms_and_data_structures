package seminars.seminar_001;

public class Recursion {
    public static void main(String[] args) {
        f(4);
    }

    /**
     * n = 4
     * @param n
     */
    static void f(int n) {
        System.out.println(n);
        if (n >= 3) {
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }

    }
}
