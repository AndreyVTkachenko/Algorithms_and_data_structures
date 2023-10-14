package seminars.seminar_002;

import java.util.Arrays;

public class Ex4 {
    public static void main(String[] args) {
        int size = 100;
        int min = 1;
        int max = 100;
        int value = 10;
        int[] array = Ex1.getRandomArray(size, max, min);
        Arrays.sort(array);
        Ex1.printArray(array);
        System.out.println("Элемент " + value);
        System.out.print("Находится на позиции: ");
        System.out.println(search(array, value, 0, array.length - 1));
    }

    public static int search(int[] array, int value, int min, int max) {
        int middle;
        if (max < min) {
            return -1;
        }
        else {
            middle = (max - min) / 2 + min;
        }
        if (array[middle] < value) {
            return search(array, value, middle + 1, max);
        }
        else {
            if (array[middle] > value) {
                return search(array, value, min, middle - 1);
            }
            else {
                return middle;
            }
        }
    }
}
