package seminars.seminar_001;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex1 {
    public static void main(String[] args) {
        int latNumber = 12;
        AtomicInteger counter = new AtomicInteger();
        System.out.printf("Сумма всех чисел от 1 до %d равна %d; Кол-во итераций: %d\n",
                latNumber, sum1(latNumber, counter), counter.get());

        System.out.printf("Сумма всех чисел от 1 до %d равна %d; Кол-во итераций: 1\n",
                latNumber, sum2(latNumber));
    }

    /**
     * @apiNote [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.(линейная сложность)
     */
    public static int sum1(int lastNumber, AtomicInteger counter) {
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++) {
            sum += i;
            counter.getAndIncrement();
        }
        return sum;
    }

    /**
     * @apiNote уходим от линейной сложности с помощью формулы к константной (константная сложность)
     */
    public static int sum2(int lastNumber) {
        return ((1 + lastNumber) * lastNumber) / 2;
    }
}
