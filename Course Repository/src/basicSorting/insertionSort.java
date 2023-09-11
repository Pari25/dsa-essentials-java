package basicSorting;

import java.util.Arrays;

public class insertionSort {

//    static void insertion_sort(int a[],int n){
//
//        for(int i=1; i<=n-1; i++){
//
//            int current = a[i];
//
//            int prev = i - 1;
//            //loop to find the right index where the element current should be inserted
//            while(prev>=0 && a[prev] > current){
//                a[prev + 1] = a[prev];
//                prev = prev - 1;
//            }
//
//            a[prev+1] = current;
//        }
//
//
//    }

    private static void insertion_sort(int[] arr, int n) {
        for(int i = 1; i < n - 1; i++) {
            int cur = arr[i];
            int prev = i - 1;
            while(prev >= 0 && arr[prev] > cur) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            arr[prev + 1] = cur;
        }
    }


    public static void main(String[] args){

        int arr[] = {10,9,8,6,5,4,3,2,11,16,8};
        int n = arr.length;

        insertion_sort(arr, n);


        for(int k: arr){
            System.out.println(k);
        }

    }

}
