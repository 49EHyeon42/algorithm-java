import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static final Queue<Coordinate> queue = new ArrayDeque<>();

    private static int N;
    private static int M;

    private static int[][] beforeArray;
    private static int[][] afterArray;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        beforeArray = new int[N][M];
        afterArray = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                beforeArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                afterArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        bw.write(solution());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution() {
        boolean shot = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!shot && beforeArray[i][j] != afterArray[i][j] && !visited[i][j]) {
                    bfs(i, j, beforeArray[i][j], afterArray[i][j]);

                    shot = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (beforeArray[i][j] != afterArray[i][j]) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    private static void bfs(int y, int x, int beforeVirus, int afterVirus) {
        visited[y][x] = true;

        queue.offer(new Coordinate(y, x));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            beforeArray[currentCoordinate.y][currentCoordinate.x] = afterVirus;

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (beforeVirus != beforeArray[nextY][nextX]) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Coordinate(nextY, nextX));
            }
        }
    }

    private static class Coordinate {

        final int y;
        final int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
