package Arrays;

public class printAllPair {

    //Print array pairs
    private static void printArrayPairs(int[] arr, int n) {

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")" + " ");
            }

            System.out.println();
        }
    }

    static void printSubarrays(int arr[],int n){

        for(int i=0;i<n;i++){
            for(int j=i; j<n;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k] + ",");
                }
                System.out.println();
            }

        }

    }


// Print the sum of each subarray & find out the largest sum

    private static int findLargestSumOfSubarray(int[] arr, int n) {

        if(n == 0) return 0;

        int max = arr[0], prev = arr[0];

        for(int i = 1; i < n; i++) {
            if(prev <= 0) {
                prev = arr[i];
            } else {
                prev = prev + arr[i];
            }
            max = Math.max(max, prev);
        }

        return max;
    }

    public static void main(String[] args){
        //Array Containing

        int arr[] = {-2,3,4,5,-12,6,2,3};
        int n = arr.length;

        //printSubarrays(arr,n);
        System.out.println(findLargestSumOfSubarray(arr, n));

    }

}
