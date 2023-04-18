import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int n, int[][] wires) {
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }

        int answer = n;

        for (int[] wire : wires) {
            int wire1 = wire[0];
            int wire2 = wire[1];

            graph[wire1][wire2] = false;
            graph[wire2][wire1] = false;

            answer = Math.min(answer, Math.abs(n - 2 * bfs(graph)));

            graph[wire1][wire2] = true;
            graph[wire2][wire1] = true;
        }

        return answer;
    }

    private int bfs(boolean[][] graph) {
        int visitedCount = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];

        queue.offer(1);
        isVisited[1] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            visitedCount++;

            for (int i = 1; i < graph[currentVertex].length; i++) {
                if (!isVisited[i] && graph[currentVertex][i]) {
                    queue.offer(i);
                    isVisited[currentVertex] = true;
                }
            }
        }

        return visitedCount;
    }
}
