package lessons.lesson_002;

public class QuickSort {
    public static void main(String[] args) {

        int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5, 0, 2, 9, 8, 6, 4, 5, 3, 7};
        sort(array, 0, array.length - 1);
        System.out.println("быстрая сортировка:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rigthPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rigthPosition] > pivot) {
                rigthPosition--;
            }
            if (leftPosition <= rigthPosition) {
                if (leftPosition < rigthPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rigthPosition];
                    array[rigthPosition] = temp;
                }
                leftPosition++;
                rigthPosition--;
            }
        }
        while (leftPosition <= rigthPosition);
        if (leftPosition < endPosition) {
            sort(array, leftPosition, endPosition);
        }
        if (startPosition < rigthPosition) {
            sort(array, startPosition, rigthPosition);
        }
    }
}
