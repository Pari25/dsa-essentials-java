package DivideAndConquer;

import java.util.Scanner;

public class rotatedSearch {


    static int rotated_search(int[] a,int key) {
        int n = a.length;

        //Logic
        int s = 0;
        int e = n - 1;

        while(s<=e){
            int mid = (s+e)/2;

            if(a[mid]==key){
                return mid;
            }

            //2 cases
            if(a[s]<=a[mid]){
                //left
                if(key>=a[s] && key<=a[mid]){
                    e = mid - 1;
                }
			else{
                    s = mid + 1;
                }

            }
            else{
                //right

                if(key>=a[mid] && key<=a[e]){
                    s = mid + 1;
                }
			else{
                    e = mid - 1;
                }

            }

        }
        return -1;

    }

    private static int findPivot(int[] arr) {

        if(arr.length < 2) {
            return 0;
        }

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) return i + 1;
        }

        return 0;
    }

    private static int binarySearch(int[] arr, int start, int end, int key) {

        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(arr[mid] == key) {
            return mid;
        }
        if(arr[mid] < key) {
            return binarySearch(arr, mid + 1, end, key);
        }

        return binarySearch(arr, start, mid - 1, key);
    }

    private static int rotated_search_rec(int[] arr, int key) {

        int pivot = findPivot(arr);
        int index = binarySearch(arr, 0, pivot - 1, key);
        if(index == -1) {
            return binarySearch(arr, pivot, arr.length - 1, key);
        }

        return index;
    }


    private static int rotated_search_rec_opt(int[] a, int key, int start, int end) {

        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(a[mid] == key) return mid;

        //If it is in first half.
        if(a[mid] >= a[start]) {
            if(key >= a[start] && key < a[mid]) {
                return rotated_search_rec_opt(a, key, start, mid - 1);
            } else {
                return rotated_search_rec_opt(a, key, mid + 1, end);
            }
        } else {
            if(key > a[mid] && key <= a[end]) {
                return rotated_search_rec_opt(a, key, mid + 1, end);
            } else {
                return rotated_search_rec_opt(a, key, start, mid - 1);
            }
        }
    }


    public static void main(String[] args) {

        int[] a = new int[]{4,5,6,7,0,1,2,3};
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        //System.out.println( rotated_search(a,key) );
        //linear O(n)
        System.out.println(rotated_search_rec(a,key) );
        // Optimised code : modified binary search : O(log(n))
        System.out.println(rotated_search_rec_opt(a,key, 0, a.length - 1) );

    }

}
