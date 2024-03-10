package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset {

    private static void subset(String s) {
        List<String> list = subsetHelper(s, 0);
        for(String str : list) {
            System.out.println(str);
        }
    }

    private static List<String> subsetHelper(String s, int i) {
        if(i == s.length()) {
            List<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }

        List<String> subsets = subsetHelper(s, i + 1);
        List<String> result = new ArrayList<>();
        for(String subset : subsets) {
            result.add(s.charAt(i) + subset);
        }
        result.addAll(subsets);
        return result;
    }

    private static void subsetSpaceOptimised(String s) {

        char[] input = s.toCharArray();
        char[] output = new char[s.length() + 1];

        printSubsets(input, output, 0, 0);
    }


    //i points to input array
    //j points to output array
    private static void printSubsets(char[] input, char[] output, int i, int j) {

        if(i == input.length) {
            output[j] = '\0';
            System.out.println(String.valueOf(output));
            return;
        }

        output[j] = input[i];
        printSubsets(input, output, i + 1, j + 1);
        printSubsets(input, output, i + 1, j);
    }

    private static List<List<Integer>> subsetsInAscendingOrderWithoutDuplicates(List<Integer> input) {

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        subsetAscendingHelper(input, subset, result, 0);

        return result;
    }

    private static void subsetAscendingHelper(List<Integer> input, List<Integer> subset, List<List<Integer>> result, int i) {

        if(i == input.size()) {
            return;
        }


        for(int j = i; j < input.size(); j++) {
            subset.add(input.get(j));
            if(!result.contains(subset)) {
                result.add(new ArrayList<>(subset));
            }
            subsetAscendingHelper(input, subset, result, j + 1);
            subset.remove(subset.size() - 1);
        }

    }


    public static void main(String[] args) {

        subset("abc");

        System.out.println("Using single array for result");

        subsetSpaceOptimised("abc");

        System.out.println("Sorted subsets with no duplicates");

        List<Integer> input = Arrays.asList(1, 2, 2);
        List<List<Integer>> result = subsetsInAscendingOrderWithoutDuplicates(input);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

}
