package lessons.lesson_001;

// Найти все простые числа до заданного числа

import java.util.ArrayList;
import java.util.List;

public class Example002 {
    public static void main(String[] args) {
        List<Integer> availableDivider = findSimpleNumbers(100);
        for (Integer integer : availableDivider) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findSimpleNumbers (int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }
}
