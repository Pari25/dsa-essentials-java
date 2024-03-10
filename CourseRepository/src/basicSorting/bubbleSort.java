package basicSorting;

public class bubbleSort {

//    static boolean compare(int a,int b){
//        return a > b;
//    }
//    static void bubble_sort(int a[],int n){
//
//        for(int times=1;times<=n-1;times++){
//            //repeated swapping
//            for(int j=0; j <= n - times - 1; j++ ){
//                if(compare(a[j],a[j+1])){
//                    int temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] =temp;
//                }
//            }
//
//        }
//    }

    //My version --optimised for worst case. If array is already sorted, it will take O(n) time, else O(n^2)
    private static void bubble_sort(int[] arr, int n) {

        boolean isSwap = false;
        for(int itr = 0; itr < n - 1; itr++) {
            for(int i = 0; i < n - 1 - itr; i++) {
                if(arr[i] > arr[i + 1]) {
                    isSwap = true;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if(!isSwap) {
                return;
            }
        }
    }




    public static void main(String[] args){
        int arr[] = {-2,3,4,-1,5,-12,6,1,3};
        int n = arr.length;


        bubble_sort(arr,n);
        for(int k: arr){
            System.out.println(k);
        }

    }

}
