import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;

        String[] graph = new String[N];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
        }

        int[][] dijkstra = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dijkstra[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra[startY][startX] = 1;

        int weight = 1;

        PriorityQueue<Coordinate> pq = new PriorityQueue<>(Comparator.comparingInt(coordinate -> coordinate.weight));
        pq.offer(new Coordinate(startY, startX, weight));

        while (!pq.isEmpty()) {
            Coordinate currentCoordinate = pq.poll();

            if (currentCoordinate.y == endY && currentCoordinate.x == endX) {
                weight = currentCoordinate.weight;
                break;
            }

            if (dijkstra[currentCoordinate.y][currentCoordinate.x] < currentCoordinate.weight) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dy[i];
                int nextX = currentCoordinate.x + dx[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                int nextWeight = dijkstra[currentCoordinate.y][currentCoordinate.x];

                if (graph[nextY].charAt(nextX) == '1') {
                    nextWeight++;
                }

                if (dijkstra[nextY][nextX] > nextWeight) {
                    dijkstra[nextY][nextX] = nextWeight;

                    pq.offer(new Coordinate(nextY, nextX, dijkstra[nextY][nextX]));
                }
            }
        }

        bw.write(Integer.toString(weight));
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
