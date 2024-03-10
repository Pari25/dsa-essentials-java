package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class sortQueueWithoutExtraSpace {

    private static void sortQueue(Queue<Integer> queue) {
        if(queue.isEmpty() || queue.size() == 1) return;

        int front = queue.peek(), max = -1;
        int sorted = 0;
        int n = queue.size();

        while(sorted != n) {
            if(front == queue.peek()) {
                if(max != -1) queue.add(max);
                sorted = 0;
                int a = queue.poll();
                int b = queue.poll();
                if(a <= b) {
                    sorted++;
                    front = a;
                    queue.add(a);
                    max = b;
                } else {
                    front = b;
                    queue.add(b);
                    max = a;
                }
            } else {
                if(queue.peek() <= max) {
                    queue.add(queue.poll());
                } else {
                    sorted++;
                    queue.add(max);
                    max = queue.poll();
                }
            }
            if(sorted == n - 1) {
                queue.add(max);
                sorted++;
            }
        }
    }

    //Refer G4g solution. That is better.
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(11, 5, 4, 21));
        sortQueue(queue);
        for(Integer i : queue) {
            System.out.print(i + " ");
        }
    }
}
