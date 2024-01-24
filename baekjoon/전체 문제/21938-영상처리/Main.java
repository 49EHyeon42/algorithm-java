import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Coordinate> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;

    private static boolean[][] array;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int sum = 0;

                for (int k = 0; k < 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }

                temp[i][j] = sum / 3;
            }
        }

        int T = Integer.parseInt(br.readLine());

        array = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] >= T) {
                    array[i][j] = true;
                }
            }
        }

        visited = new boolean[N][M];

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] && !visited[i][j]) {
                    count++;

                    bfs(i, j);
                }
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs(int y, int x) {
        visited[y][x] = true;

        queue.offer(new Coordinate(y, x));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (!array[nextY][nextX]) {
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

        Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
