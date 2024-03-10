package Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReducedArraySizeToHalf {

    private static int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <arr.length; i++) {
            int cur = 0;
            if(map.containsKey(arr[i])) {
                cur = map.get(arr[i]);
            }
            map.put(arr[i], cur + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.size(), Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        int minSize = (arr.length + 1)/ 2;
        int curSize = 0;
        int minSetSize = 0;
        while(curSize < minSize) {
            int freq = pq.poll();
            curSize = curSize + freq;
            minSetSize++;
        }

        return minSetSize;
    }

    public static void main(String[] args)
    {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr));
    }
}
