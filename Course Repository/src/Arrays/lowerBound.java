package Arrays;

public class lowerBound {


    private static int getLowerBound(int[] arr, int val) {
        int start = 0, end = arr.length - 1, ans = -1;

        return binarySearchHelper(start, end, val, arr, ans);
    }

    private static int binarySearchHelper(int start, int end, int val, int[] arr, int ans) {

        if(start > end) return ans;
        int mid = (start + end) / 2;
        if(arr[mid] <= val) {
            //keep track of potential ans. Update it when we get new lower bound.
            ans = arr[mid];
            return binarySearchHelper(mid + 1, end, val, arr, ans);
        }

        return binarySearchHelper(start, mid - 1, val, arr, ans);
    }

    public static void main(String[] args) {

        int[] arr = {-2, -2, 2, 3, 5};
        System.out.println("Lower bound is : " + getLowerBound(arr, 4));
    }
}
