package lessons.lesson_001;

// Найти значение элемента рядя Фибоначчи по номеру позиции.
// Посчитать количество операций.

import java.util.concurrent.atomic.AtomicInteger;

public class Example004 {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(11, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(12, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(13, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(14, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(15, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());
    }

    public static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }
}
