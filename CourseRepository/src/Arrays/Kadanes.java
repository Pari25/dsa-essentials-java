package Arrays;

public class Kadanes {

    //It works if array has atleast 1 positive integer
    static int maximum_subarray_sum(int arr[],int n){

        int cs = 0;
        int largest = 0;

        for(int i=0;i<n;i++){
            cs = cs + arr[i];
            if(cs < 0){
                cs = 0;
            }
            largest = Math.max(largest, cs);
        }

        return largest;
    }


    //print max subarray
    static int print_max_subarray(int arr[],int n){
        int max = Integer.MIN_VALUE, cur = 0, st = 0, end = 0;

        for(int i = 0; i < arr.length; i++) {
            if(cur < 0) {
                st = i;
                end = i;
            }
            cur = arr[i] + ((cur < 0) ? 0 : cur);
            if(max < cur) {
                max = cur;
                end = i;
            }

        }

        while(st <= end) {
            System.out.print(arr[st] + " ");
            st++;
        }

        System.out.println();
        return max;
    }


    public static void main(String[] args){
        //Array Containing
        //int arr[] = {-2,3,4,-1,5,-12,6,1,3};
        int arr[] = {-1, 2, 4, 1, -2, 3, -1, -5};
        int n = arr.length;

        System.out.println(maximum_subarray_sum(arr, n));
    }

}
