package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kWeakestRows {

    static class Pair {
        int idx, strength;
        Pair(int idx, int[] arr) {
            this.idx = idx;
            this.strength = getStrength(arr);
        }

        private int getStrength(int[] arr) {
            int strength = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 0) break;;
                strength += arr[i];
            }
            return strength;
        }
    }

    private static void kWeakestRows(int[][] mat, int m, int n, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.strength > o2.strength) return -1;
                if(o1.strength == o2.strength && o1.idx > o2.idx) return -1;
                if(o1.strength == o2.strength && o1.idx == o2.idx) return 0;
                return 1;
            }
        });

        for(int i = 0; i < k; i++) {
            pq.add(new Pair(i, mat[i]));
        }

        for(int i = k; i < mat.length; i++) {
            Pair pair = new Pair(i, mat[i]);
            Pair top = pq.peek();
            if(pair.strength < top.strength || ((pair.strength == top.strength) && (pair.idx < top.idx))) {
                pq.poll();
                pq.add(pair);
            }
        }

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            System.out.print(pair.idx + ", ");
        }

    }

    public static void main(String[] args)
    {
        int m = 4, n = 4;
        int[][] mat = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };
        int k = 2;
        kWeakestRows(mat, m, n, k);
    }
}
