package DivideAndConquer;

public class binarySearchRecursion {

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

    public static void main(String[] args) {

        int[]  arr = new int[]{1, 3, 5, 7, 9};
        int n = arr.length;
        int key = 3;

        System.out.print(binarySearch(arr, 0, n-1, key));
    }
}
