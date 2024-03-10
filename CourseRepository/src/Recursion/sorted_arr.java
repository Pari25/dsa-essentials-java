package Recursion;



public class sorted_arr {

    static boolean isSortedArray(int[] arr, int i) {

        if(i == 0) return true;
        return (arr[i] >= arr[i - 1]) && isSortedArray(arr, i - 1);
    }



    static boolean isSortedTwo(int arr[],int i,int n){
        if(i==n-1){
            return true;
        }
        if(arr[i]<arr[i+1] && isSortedTwo(arr,i+1,n)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {



        int arr[] = {1,2,3,5,7, 16};
        int n = arr.length;

        System.out.println(isSortedTwo(arr,0,n));
        System.out.println(isSortedArray(arr,n - 1));


    }
}
