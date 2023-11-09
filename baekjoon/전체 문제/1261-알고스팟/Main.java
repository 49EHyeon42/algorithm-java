import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] graph = new String[M];

        for (int i = 0; i < M; i++) {
            graph[i] = br.readLine();
        }

        int[][] dijkstra = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
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

                if (nextY < 0 || nextX < 0 || nextY >= M || nextX >= N) {
                    continue;
                }

                int weight = currentVertex.weight;

                if (graph[nextY].charAt(nextX) == '1') {
                    weight++;
                }

                if (dijkstra[nextY][nextX] > weight) {
                    dijkstra[nextY][nextX] = weight;

                    pq.offer(new Vertex(nextY, nextX, dijkstra[nextY][nextX]));
                }
            }
        }

        bw.write(Integer.toString(dijkstra[M - 1][N - 1]));
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
