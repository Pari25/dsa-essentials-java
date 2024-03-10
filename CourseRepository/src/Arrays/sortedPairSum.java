package Arrays;

public class sortedPairSum {

    private static void printClosestSumPair(int[] arr, int n) {

        int resi = 0, resj = 0, minDiff = Integer.MAX_VALUE;
        for(int i = 0, j = arr.length - 1; i < j; ) {
            int sum = arr[i] + arr[j];
            int diff = Math.abs(sum - n);
            if(minDiff > diff) {
                resi = i;
                resj = j;
                minDiff = diff;
            }

            if(sum <= n) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(arr[resi] + "," + arr[resj]);
    }

    public static void main(String[] args) {

        int[] arr = {10, 22, 28, 29, 30, 40};
        int sum = 54;
        printClosestSumPair(arr, sum);
    }

}
