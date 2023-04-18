import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        bfs(graph, visited, distance);

        int max = distance[2];
        for (int i = 3; i < distance.length; i++) {
            if (max < distance[i]) {
                max = distance[i];
            }
        }

        int answer = 0;
        for (int i = 2; i < distance.length; i++) {
            if (max == distance[i]) {
                answer++;
            }
        }

        return answer;
    }

    private void bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (!visited[nextVertex]) {
                    queue.offer(nextVertex);
                    visited[nextVertex] = true;
                    distance[nextVertex] = distance[currentVertex] + 1;
                }
            }
        }
    }
}
