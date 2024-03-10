package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class InterleaveTwoHalvesOfQueue {

    private static void interleaveQueue(Queue<Integer> queue) {
        int mid = queue.size() / 2;

        Queue<Integer> temp = new LinkedList<>();

        for(int i = 0; i < mid; i++) {
            temp.add(queue.poll());
        }
        while(!temp.isEmpty()) {
            queue.add(temp.poll());
            int front = queue.poll();
            queue.add(front);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        interleaveQueue(queue);
        for(Integer i : queue) {
            System.out.print(i + " ");
        }
    }
}
