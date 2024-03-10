package Bitmasking;

public class findUniqueNumber {

    private static int findUniqueNumber(int[] arr) {

        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
           result = result ^ arr[i];
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 7, 6, 5, 8};
        System.out.println(findUniqueNumber(arr));
    }
}
