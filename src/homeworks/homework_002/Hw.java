package homeworks.homework_002;

public class Hw {
    public static void main(String[] args) {

        // Реализовать алгоритм пирамидальной сортировки (сортировка кучей)

        int[] array = new int[]{2, 5, 6, 3, 8, 4, 5, 1, 6, 9, 2, 7, 0, 2, 5, 6, 9, 7};
        int n = array.length;

        System.out.println("Исходный массив:");
        printArray(array);

        HeapSort ob = new HeapSort();
        ob.sort(array);

        System.out.println("Cортированный массив:");
        printArray(array);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static class HeapSort {
        public static void sort(int[] array) {
            // Построение кучи (перегруппируем массив)
            for (int i = ((array.length / 2) - 1); i >= 0; i--) {
                heapify(array, array.length, i);
            }
            // один за другим извлекаем элементы из кучи
            for (int i = array.length - 1; i >= 0; i--) {
                // перемещаем текущий корень в конец
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                heapify(array, i, 0); // вызываем процедуру heapify на уменьшенной куче
            }
        }

        private static void heapify(int[] array, int heapSize, int rootIndex) {
            int largest = rootIndex; // инициализация наибольшего элемента как корня
            int leftChild = 2 * rootIndex + 1; // левый
            int rigthChild = 2 * rootIndex + 2; // правый

            // если левый дочерний элемент больше корня
            if (leftChild < heapSize && array[leftChild] > array[largest]) {
                largest = leftChild;
            }

            // если правый элемент больше чем самый большой элемент на данный момент
            if (rigthChild < heapSize && array[rigthChild] > array[largest]) {
                largest = rigthChild;
            }

            // если самый большой элемент не корень
            if (largest != rootIndex) {
                int temp = array[rootIndex];
                array[rootIndex] = array[largest];
                array[largest] = temp;
                heapify(array, heapSize, largest); // рекурсивно преобразуем в двоичную кучу затронутое поддерево
            }

        }
    }

}
