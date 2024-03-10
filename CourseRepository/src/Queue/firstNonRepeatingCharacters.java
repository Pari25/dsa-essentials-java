package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class firstNonRepeatingCharacters {

    private static String getFirstNonRepeating(String s) {

        StringBuilder sb = new StringBuilder("");
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
                queue.add(arr[i]);
            }


            while(!queue.isEmpty()) {
                char first = queue.peek();
                if(map.get(first) > 1) {
                    queue.poll();
                } else {
                    break;
                }
            }

            Character next = (queue.isEmpty()) ? '0' : queue.peek();
            sb.append(next);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "aabc";
        String ans = getFirstNonRepeating(A);
        System.out.print(ans);
    }
}
