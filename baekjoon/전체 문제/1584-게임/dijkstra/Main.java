import java.io.*;
import java.util.*;

public class Main {

    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int[][] map;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[500 + 1][500 + 1];
        visited = new int[500 + 1][500 + 1];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if (y1 > y2) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if (y1 > y2) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    map[j][k] = Integer.MIN_VALUE;
                }
            }
        }

        for (int i = 0; i <= 500; i++) {
            for (int j = 0; j <= 500; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        int minWeight = dijkstra();

        bw.write(Integer.toString(minWeight == Integer.MAX_VALUE ? -1 : minWeight));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra() {
        visited[0][0] = 0;

        pq.offer(new Vertex(0, 0, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= 501 || nextX < 0 || nextX >= 501) {
                    continue;
                }

                if (map[nextY][nextX] == Integer.MIN_VALUE) {
                    continue;
                }

                int nextWeight = currentVertex.weight + map[nextY][nextX];

                if (nextWeight >= visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = nextWeight;

                pq.offer(new Vertex(nextY, nextX, nextWeight));
            }
        }

        return visited[500][500];
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
