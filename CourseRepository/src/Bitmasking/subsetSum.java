package Bitmasking;

import java.util.BitSet;

/**
 * Given an array and N number of queries, where in each query
 * you have to check whether a subset whose sum is equal to given number exists in the array or not.
 * **/
public class subsetSum {

    // Maximum allowed query value
    static final int MAXSUM = 10000;
    private static boolean[] subsetSum(int[] arr, int[] query) {
        BitSet bitSet = new BitSet(MAXSUM);
        bitSet.set(0);
        for(int i = 0; i < arr.length; i++) {

            for(int j = MAXSUM - 1 - arr[i]; j >= 0; j--) {
                if(bitSet.get(j)) {
                    bitSet.set(j + arr[i]);
                }
            }
        }

        boolean[] result = new boolean[query.length];
        for(int i = 0; i < query.length; i++) {
            if(query[i] >=  MAXSUM) {
                result[i] = false;
            }
            result[i] = bitSet.get(query[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, 5};
        int[] query = {8, 7};

        int n = arr.length;
        int nq = query.length;
        boolean[] isPresent = subsetSum(arr, query);
        for(int i = 0; i < isPresent.length; i++) {
            System.out.print(isPresent[i] + ", ");
        }
    }
}
