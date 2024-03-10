package Heap;

import java.util.Collections;

public class MaxProduct {

    private static int maxProduct(int[] arr) {
        buildHeap(arr, 0);
        int max1 = pop(arr);
        int max2 = pop(arr);

        return (max1 - 1) * (max2 - 1);
    }

    private static void heapify(int[] arr, int i, int length) {
        if(i >= length) return;

        int maxIndex = i;
        int lIndex = 2 * i + 1;
        int rIndex = 2 * i + 2;

        if(lIndex < length && arr[maxIndex] < arr[lIndex]) {
            maxIndex = lIndex;
        }
        if(rIndex < length && arr[maxIndex] < arr[rIndex]) {
            maxIndex = rIndex;
        }
        if(maxIndex != i) {
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
            heapify(arr, maxIndex, length);
        }
    }

    private static int pop(int[] arr) {
        //Empty heap
        if(arr[0] == -1) return -1;

        int res = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        heapify(arr, 0, arr.length - 1);

        return res;

    }

    private static void buildHeap(int[] arr, int i) {

        if(i >= arr.length) return;

        int maxIndex = i;
        int lIndex = 2 * i + 1;
        int rIndex = 2 * i + 2;

        if(lIndex < arr.length && arr[maxIndex] < arr[lIndex]) {
            maxIndex = lIndex;
        }
        if(rIndex < arr.length && arr[maxIndex] < arr[rIndex]) {
            maxIndex = rIndex;
        }
        if(maxIndex != i) {
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
        buildHeap(arr, lIndex);
        buildHeap(arr, rIndex);

    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,2};
        System.out.println(maxProduct(arr));
    }
}
