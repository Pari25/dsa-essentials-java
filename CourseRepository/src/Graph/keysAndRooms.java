package Graph;

import java.util.*;

public class keysAndRooms {




    private static boolean visitAlRooms(List<List<Integer>> rooms, int n) {

        boolean[] visited = new boolean[n];

        bfs(rooms, visited, 0);

        for(int i = 0; i < n; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }

    private static void bfs(List<List<Integer>> rooms, boolean[] visited, int src) {
        Queue<Integer> q = new PriorityQueue(rooms.size());
        q.add(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for(Integer child : rooms.get(cur)) {
                if(!visited[child]) {
                    q.add(child);
                    visited[child] = true;
                }
            }
        }

    }

    public static void main(String[] args) {

        int n = 4;
        List<List<Integer>> rooms  = new ArrayList<>(4);
        rooms.add(new ArrayList<>(Arrays.asList(1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(3)));
        rooms.add(new ArrayList<>());

        System.out.println(visitAlRooms(rooms, n));

    }
}
