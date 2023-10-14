package lessons.lesson_002;

public class Find {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(find(array, 5));
        System.out.println(binarySearch(array, 16, 0, array.length - 1));
    }

    // поиск перебором (сортировка необязательна)
    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // бинарный поиск (массив должен быть отсортирован)
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midPoint;
        if(max < min) {
            return -1;
        }
        else {
            midPoint = ((max - min) / 2) + min;
        }

        if (array[midPoint] < value) {
            return binarySearch(array, value, midPoint + 1, max);
        }
        else {
            if (array[midPoint] > value) {
                return binarySearch(array, value, min, midPoint - 1);
            }
            else {
                return midPoint;
            }
        }
    }
}
