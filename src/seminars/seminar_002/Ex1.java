package seminars.seminar_002;

import java.util.Arrays;
import java.util.Random;

public class Ex1 {
    public static void main(String[] args) throws Exception {
        int size = 100;
        int min = 0;
        int max = 100;
        int[] array = getRandomArray(size, max, min);
        System.out.println("Исходный массив:");
        printArray(array);

        bubbleSort(array);
        System.out.println("Сортированный массив:");
        printArray(array);
    }

    /**
     * @apiNote Сортировка массива пузырьком
     * @param array - принимаемый массив
     */
    public static void bubbleSort(int[] array) {
        boolean fin;
        do {
            fin = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    array[i] += array[i + 1];
                    array[i + 1] = array[i] - array[i + 1];
                    array[i] -= array[i + 1];
                    fin = false;
                }
            }
        } while (!fin);
    }

    /**
     * @apiNote Вывод массива в консоль
     * @param array - массив для вывода
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * @apiNote Создание массива случайных целочисленных элементов
     * @param size - размер массива
     * @param max - максимальное число элемента
     * @param min - минимальное число элемента
     * @return - созданный массив
     */
    public static int[] getRandomArray(int size, int max, int min) {
        Random rand = new Random();
        int [] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
        return array;
    }
}
