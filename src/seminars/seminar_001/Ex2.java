package seminars.seminar_001;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex2 {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        int latNumber = 12;
        List<Integer> simpleNumbers = findSimpleNumbers(latNumber, counter);
        for (int e : simpleNumbers) {
            System.out.printf("%d\t", e);
        }
        System.out.println();
        System.out.printf("Простые числа на отрезке от 1 до %d; Кол-во итераций: %d\n",
                latNumber, counter.get());
    }

    /**
     * @apiNote [2] Написать алгоритм поиска простых чисел (делятся только на себя и на 1 без остатка)
     * * в диапазоне от 1 до N.
     * <p>
     * 1 2 3 4 5 6 7 8
     * <p>
     * (квадратичная сложность)
     */
    public static List<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= lastNumber; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter.getAndIncrement();
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                numbers.add(i);
            }
        }
        return numbers;
    }
}
