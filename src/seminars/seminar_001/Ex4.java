package seminars.seminar_001;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("fb(10) = " + fb(10));
    }

    /**
     * @apiNote Фибоначи через рекурсию (экспоненциальная сложность)
     */
    public static int fb(int num) {
        if (num <= 2) {
            return 1;
        } else {
            return fb(num - 1) + fb(num - 2);
        }
    }
}
