import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final static int[] dy = {1, -1, 0, 0};
    private final static int[] dx = {0, 0, -1, 1};

    private static int n;
    private static int m;

    private static boolean[][] graph;
    private static int[][] visited;

    private static void bfs(Coordinate startCoordinate) {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(startCoordinate);

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dy[i];
                int nextX = currentCoordinate.x + dx[i];

                if (!(isPossible(nextY, nextX) && graph[nextY][nextX] && visited[nextY][nextX] == -1)) {
                    continue;
                }

                visited[nextY][nextX] = visited[currentCoordinate.y][currentCoordinate.x] + 1;

                queue.offer(new Coordinate(nextY, nextX));
            }
        }
    }

    private static boolean isPossible(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new boolean[n][m];
        visited = new int[n][m];

        Coordinate startCoordinate = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value > 0) {
                    graph[i][j] = true;

                    if (value == 2) {
                        visited[i][j] = 0;

                        startCoordinate = new Coordinate(i, j);

                        continue;
                    }
                }

                visited[i][j] = -1;
            }
        }

        bfs(startCoordinate);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(graph[i][j] ? visited[i][j] : 0).append(' ');
            }

            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Coordinate {

        private final int y;
        private final int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
