package sorting;

import utils.Utils;

public class Insertion {
    public static void main(String[] args) {
        int [] arr = {8000,64,1,9,52,7,3,89,16,20,21,100,5000,71,90,76,13};

        long beginTime = System.currentTimeMillis();

        for (int step=0;step<arr.length;step++){
            Utils.printArray(arr);

            int index = getMinIndex(arr,step);
            int tmp = arr[step];
            arr[step] = arr[index];
            arr[index] = tmp;
        }

        System.out.println(System.currentTimeMillis() - beginTime);
    }

    public static int getMinIndex(int[] arr, int startIndex){
        int minIndex = startIndex;
        int minValue = arr[startIndex];
        for(int i=startIndex+1;i<arr.length;i++){
            if (arr[i]<minValue){
                minValue = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
