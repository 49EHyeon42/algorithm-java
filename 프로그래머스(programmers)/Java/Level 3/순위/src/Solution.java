import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int[] vertex : results) {
            graph1.get(vertex[0]).add(vertex[1]);
            graph2.get(vertex[1]).add(vertex[0]);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] isVisited1 = new boolean[n + 1];
            boolean[] isVisited2 = new boolean[n + 1];

            if (bfs(graph1, isVisited1, i) + bfs(graph2, isVisited2, i) == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int startVertex) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(startVertex);
        visited[startVertex] = true;

        int count = 0;
        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (!visited[nextVertex]) {
                    count++;

                    priorityQueue.offer(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }

        return count;
    }
}
