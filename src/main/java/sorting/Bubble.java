package sorting;


import utils.Utils;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {8000, 64, 1, 9, 52, 7, 3, 89, 16, 20, 21, 100, 5000, 71, 90, 76, 13};

        long beginTime = System.currentTimeMillis();

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;

            Utils.printArray(arr);

            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    isSorted = false;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - beginTime);
    }
}
