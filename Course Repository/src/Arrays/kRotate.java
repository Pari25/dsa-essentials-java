package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kRotate {

    //with new array
    private static void kRotate(List<Integer> arrList, int k) {

        List<Integer> newList = new ArrayList<>();
        int n = arrList.size();
        k = k % n;
        for(int i = n - k; i < n; i++) {
            newList.add(arrList.get(i));
        }

        for(int i = 0; i < n - k; i++) {
            newList.add(arrList.get(i));
        }

        System.out.println("Unoptimised answer: ");
        for(int i = 0; i < n; i++) {
            System.out.print(newList.get(i) + " ");
        }

        System.out.println("");
    }

    //In place rotate --Optimised no extra space
    private static void kRotateOptimised(List<Integer> arrList, int k) {

        int n = arrList.size();
        reverseArray(arrList, 0, n - k - 1);
        reverseArray(arrList, n - k, n - 1);
        reverseArray(arrList, 0, n - 1);

        System.out.println("Optimised answer: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arrList.get(i) + " ");
        }

        System.out.println("");
    }

    private static void reverseArray(List<Integer> arrList, int start, int end) {

        while(start < end) {
            int temp = arrList.get(start);
            arrList.set(start, arrList.get(end));
            arrList.set(end, temp);
            start++;
            end--;
        }
    }

    private static void swap(List<Integer> arrList, int i, int j) {

        int temp = arrList.get(i);
        arrList.set(i, arrList.get(j));
        arrList.set(j, temp);
    }

    public static void main(String[] args) {

        List<Integer> arrList = Arrays.asList(1, 3, 5, 7, 9);
        int k = 3;
        kRotate(arrList, k);
        kRotateOptimised(arrList, k);
    }
}
