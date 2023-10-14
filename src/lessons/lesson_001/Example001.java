package lessons.lesson_001;

// Определение допустимых делителей для числа

import java.util.ArrayList;
import java.util.List;

public class Example001 {

    public static void main(String[] args) {
        List<Integer> availableDivider = findAvailableDivider(20);
        for (Integer integer : availableDivider) {
            System.out.println(integer);
        }
    }
    public static List<Integer> findAvailableDivider (int number) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            counter++;
            if (number % i == 0) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }
}
