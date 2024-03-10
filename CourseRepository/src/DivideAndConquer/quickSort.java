package DivideAndConquer;

public class quickSort {

//    static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    static int partition(int[] a,int s,int e){
//
//        int pivot = a[e];
//        int i = s - 1;
//
//        for(int j=s;j<e;j++){
//            if(a[j] < pivot){
//                i++;
//                swap(a, a[i],a[j]);
//            }
//        }
//
//        swap(a, a[i+1],a[e]);
//        return i + 1;
//
//    }

//    static void quicksort(int[] a, int s,int e){
//        //Base Case
//        if(s>=e){
//            return;
//        }
//        //Rec Case
//        int p = partition(a,s,e);
//        quicksort(a,s,p-1);
//        quicksort(a,p+1,e);
//    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int findPivot(int[] arr, int start, int end) {

        int pivot = arr[end];
        //i points to end of the window having elements less than the pivot.arr[i] is inclusive in the first window.
        // j points to the next element to be processed. Elements b/w (i + 1) and (j - 1) are greater than the pivot.
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(arr[j] < pivot) {
                swap(arr, i + 1, j);
                i++;
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    static void quicksort(int[] arr, int start, int end) {

        if(start >= end) return;

        int pivot = findPivot(arr, start, end);
        quicksort(arr, start, pivot - 1);
        quicksort(arr, pivot + 1, end);
    }


    public static void main(String[] args) {

        int[]  arr = new int[]{10,5,2,0,7,6,4};
        int n = arr.length;

        quicksort(arr,0,n-1);

        for(int x :arr){
            System.out.print(x + " ");
        }

    }


}
