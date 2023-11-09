import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] graph = new String[n];

        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine();
        }

        int[][] dijkstra = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dijkstra[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra[0][0] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex(0, 0, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dy[i];
                int nextX = currentVertex.x + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
                    continue;
                }

                int weight = currentVertex.weight;

                if (graph[nextY].charAt(nextX) == '0') {
                    weight++;
                }

                if (dijkstra[nextY][nextX] > weight) {
                    dijkstra[nextY][nextX] = weight;

                    pq.offer(new Vertex(nextY, nextX, dijkstra[nextY][nextX]));
                }
            }
        }

        bw.write(Integer.toString(dijkstra[n - 1][n - 1]));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Vertex {

        final int y;
        final int x;
        final int weight;

        Vertex(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
