import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int N;
    private static int M;

    private static char[][] graph;
    private static boolean[][] visited;

    private static Coordinate startCoordinate;

    private static int bfs() {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(startCoordinate);
        visited[startCoordinate.y][startCoordinate.x] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (graph[currentCoordinate.y][currentCoordinate.x] == 'P') {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dy[i];
                int nextX = currentCoordinate.x + dx[i];

                if (isPossible(nextY, nextX) && graph[nextY][nextX] != 'X'
                        && !visited[nextY][nextX]) {
                    queue.offer(new Coordinate(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }

        return count;
    }

    private static boolean isPossible(int y, int x) {
        return 0 <= y && 0 <= x && y < N && x < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                char c = string.charAt(j);

                if (c == 'I') {
                    startCoordinate = new Coordinate(i, j);
                }

                graph[i][j] = string.charAt(j);
            }
        }

        int count = bfs();

        bw.write(count == 0 ? "TT" : Integer.toString(count));
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
