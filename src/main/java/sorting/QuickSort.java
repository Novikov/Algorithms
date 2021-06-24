package sorting;

import java.util.Arrays;

public class QuickSort {

    /**
     * Данная сортировка в тысячи раз быстрее сортировки пузырьком, если массив не отсортирован.
     * Происходит выбор опорного элемента.
     * В левую часть перебрасывается всё что меньше его, а в правую всё что больше.
     * Функция вызывается рекурсивно до тех пор, пока подмассив не будет состоять из одного элемента.
     * */

    public static void main(String[] args) {
        int[] array = {8000, 64, 1, 9, 52, 99, 8, 89, 16, 20, 21, 100, 5000, 71, 90, 76, 13};

        System.out.println(arrayToString(array));

        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] arr, int from, int to) {

        if (from < to) {

            int divideIndex = partition(arr, from, to);

            printSortStep(arr,from,to,divideIndex);

            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);
        }
    }

    //Фукция разделения массмива на подмассивы
    private static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        //Выбор опорного элемента. Не уверен, что здесь он верен.
        //Было сказано, что опорный жлемент выбирается посердине, но в выводе видно что не ровно по середине
        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
