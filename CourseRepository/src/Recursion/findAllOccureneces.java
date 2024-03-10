package Recursion;

import java.util.ArrayList;
import java.util.List;

//Solve it using recursion
public class findAllOccureneces {

    private static List<Integer> findAllOccurences(int k, int[] arr, int i) {
        List<Integer> result = new ArrayList<>();

        if(i == arr.length) return result;

        if(k == arr[i]) {
            result.add(i);
        }

        result.addAll(findAllOccurences(k, arr, i + 1));

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 3, 1, 2, 3, 8, 6, 3, 6, 7, 9};
        int k = 3;
        List<Integer> result = findAllOccurences(k, arr, 0);

        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
