package Arrays;

import java.util.Scanner;

public class binarySearch {

    //loop
    static int binary_search(int arr[],int n,int key){
        //Implement binary search
        int s = 0;
        int e = n - 1;

        while(s<=e){
            int mid = (s+e)/2;

            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] > key){
                e = mid - 1;
            }
            else{

                s = mid + 1;
            }
        }

        return -1;
    }


//    recursion
//    private static int binary_search(int[] arr, int n, int key) {
//
//        return binary_helper(arr, 0, n - 1, key);
//    }
//    private static int binary_helper(int[] arr, int start, int end, int key) {
//        int mid = (end + start) / 2;
//        if(mid < start || mid > end) return -1;
//        if(arr[mid] == key) {
//            return mid;
//        }
//        if(key < arr[mid]) {
//            return binary_helper(arr, start, mid - 1, key);
//        }
//
//        return binary_helper(arr, mid + 1, end, key);
//    }


    public static void main(String[] args){

        int arr[] = {10,20,30,40,45,60,70,89};
        int n = arr.length;
        Scanner scn = new Scanner(System.in);
        int key = scn.nextInt();

        int index = binary_search(arr,n,key);
        if(index!=-1){
            System.out.println(key  + " is present at index " +  index);
        }
        else{
            System.out.println(key  + " is NOT Found!");
        }


    }


}
