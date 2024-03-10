package Arrays;

public class SmallestMissingPositiveNumber {

    public static void main(String[] args) {

        int[] arr = {1, 6, 4, 2, 5};


        for(int i = 0; i < arr.length; i++) {

            while((arr[i] <= arr.length && arr[i] > 0) && (arr[i] != i + 1)) {
                swap(i, arr[i] - 1, arr);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != i + 1) {
                System.out.println(i + 1);
                return;

            }
        }

        System.out.println(arr.length + 1);
    }

    private static void swap(int i, int j, int[] arr) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
