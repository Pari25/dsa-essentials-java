package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allPathsFromSrcToTarget {

    private static List<List<Integer>> getAllPaths(List<List<Integer>> input, int src, int dest) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        boolean[] visited = new boolean[input.size()];
        getAllPathsHelper(result, subset, input, visited, src, dest);

        return result;
    }

    private static void getAllPathsHelper(List<List<Integer>> result, List<Integer> subset, List<List<Integer>> input, boolean[] visited, int src, int dest) {

        subset.add(src);
        visited[src] = true;
        if(src == dest) {
            result.add(new ArrayList<>(subset));
        }
        for(Integer child : input.get(src)) {
            if(!visited[child]) {
                getAllPathsHelper(result, subset, input, visited, child, dest);
            }
        }

        if(!subset.isEmpty()) {
            visited[src] = false;
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<Integer>> input  = new ArrayList<>(4);
        input.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        input.add(new ArrayList<>(Arrays.asList(3)));
        input.add(new ArrayList<>(Arrays.asList(0, 1)));
        input.add(new ArrayList<>());

        List<List<Integer>> result = getAllPaths(input, 2, 3);
        for(int i = 0; i < result.size(); i++) {
            for(Integer j : result.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
