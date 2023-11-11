import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, 0};
    private static final int[] dx = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dijkstra = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dijkstra[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra[0][0] = 0;

        PriorityQueue<Coordinate> pq = new PriorityQueue<>(Comparator.comparingInt(Coordinate -> Coordinate.weight));

        pq.offer(new Coordinate(0, 0, 0));

        int result = 0;

        while (!pq.isEmpty()) {
            Coordinate currentCoordinate = pq.poll();

            // 시간 초과 방지
            if (dijkstra[currentCoordinate.y][currentCoordinate.x] < currentCoordinate.weight) {
                continue;
            }

            if (currentCoordinate.y == n - 1 && currentCoordinate.x == n - 1) {
                result = currentCoordinate.weight;
                break;
            }

            for (int i = 0; i < 2; i++) {
                int nextY = currentCoordinate.y + dy[i];
                int nextX = currentCoordinate.x + dx[i];

                if (nextY >= n || nextX >= n) {
                    continue;
                }

                int weight = 0;

                while (graph[currentCoordinate.y][currentCoordinate.x] + weight <= graph[nextY][nextX]) {
                    weight++;
                }

                if (dijkstra[nextY][nextX] > dijkstra[currentCoordinate.y][currentCoordinate.x] + weight) {
                    dijkstra[nextY][nextX] = dijkstra[currentCoordinate.y][currentCoordinate.x] + weight;

                    pq.offer(new Coordinate(nextY, nextX, currentCoordinate.weight + weight));
                }
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Coordinate {

        final int y;
        final int x;
        final int weight;

        Coordinate(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
