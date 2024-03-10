package BackTracking;

public class permutations {

    //i points to start of string from where we need to permutate.
    //j points to index which we need to swap with start of string.

    private static void permutations(char[] arr, int i) {

        if(i == arr.length) {
            System.out.println(new String(arr));
            return;
        }

        for(int j = i; j < arr.length; j++) {

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            permutations(arr, i + 1);

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {

        permutations("abc".toCharArray(), 0);
    }
}
