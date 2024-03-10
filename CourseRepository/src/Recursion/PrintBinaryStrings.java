package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all binary strings of size N in sorted order. Skip the string which have conseutive 1s. (n <= 12)
 * e.g for N = 3 ->      000, 001, 010, 100, 101
 */
public class PrintBinaryStrings {

    private static List<String> printBinaryStrings(int n) {
        char[] arr = new char[n];
        List<String> result = new ArrayList<>();
        return stringGenerator(arr, n, 0, result);
    }

    private static List<String> stringGenerator(char[] arr, int n, int i, List<String> result) {

        if(i >= n) {
            result.add(new String(arr));
            return result;
        }

        arr[i] = '0';
        stringGenerator(arr, n, i + 1, result);
        arr[i] = '1';
        if(i + 1 < n) {
            arr[i + 1] = '0';
        }
        stringGenerator(arr, n, i + 2, result);

        return result;
    }

    public static void main(String[] args) {

        int n = 3;
        List<String> result = printBinaryStrings(n);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }


}
