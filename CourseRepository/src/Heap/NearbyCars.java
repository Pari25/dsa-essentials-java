package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NearbyCars {

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     This is the most optimised approach.
     We create a max heap of only k elements. [O(K) time].
     Then we iterate through remaining (n - k) elements and remove the top element if a smaller element is
     found in the remaining array. O[(n -k) * logk]
     At last, we'll have smallest k elements remaining in the heap. O[klogk]
     Time complexity: O[k + (n -k) * logk + klogk]
     **/
    private static void kClosestPoints(int[] x, int[] y, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int dis1 = (o1.x * o1.x) + (o1.y * o1.y);
                int dist2 = (o2.x * o2.x) + (o2.y * o2.y);
                if(dis1 > dist2) {
                    return -1;
                } else if(dis1 < dist2) {
                    return 1;
                }
                return 0;
            }
        });

        for(int i = 0; i < k; i++) {
            pq.add(new Pair(x[i], y[i]));
        }

        for(int i = k; i < x.length; i++) {
            Pair top = pq.peek();
            int topDist = (top.x * top.x) + (top.y * top.y);

            int curDist = (x[i] * x[i]) + (y[i] * y[i]);
            if(topDist > curDist) {
                pq.poll();
                pq.add(new Pair(x[i], y[i]));
            }
        }

        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            System.out.println(top.x + "," +  top.y);
        }

    }

    public static void main(String[] args)
    {
        // x coordinate of points
        int x[] = { 1, -2, 3};
        // y coordinate of points
        int y[] = { 3, 2, 3};
        int K = 2;

        int n = x.length;

        kClosestPoints(x, y, K);
    }
}
