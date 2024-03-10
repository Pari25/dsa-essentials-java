package _2DArrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private static List<List<Integer>> generatePascalTriangle(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<Integer>(i + 1);
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    subList.add(1);
                } else {
                    List<Integer> prev = result.get(i - 1);
                    subList.add(prev.get(j - 1) + prev.get(j));
                }
            }
            result.add(subList);
        }

        return result;

    }

    public static void main(String[] args) {
        List<List<Integer>> result = generatePascalTriangle(5);
        for(List<Integer> list : result) {
            System.out.println();
            for(Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
