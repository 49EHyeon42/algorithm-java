import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;
    private static int[][] array;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 1) {
                    continue;
                }

                if (visited[i][j]) {
                    continue;
                }

                bfs(i, j);

                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs(int y, int x) {
        visited[y][x] = true;

        queue.offer(new Vertex(y, x));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY == -1) {
                    nextY = N - 1;
                } else if (nextY == N) {
                    nextY = 0;
                }

                if (nextX == -1) {
                    nextX = M - 1;
                } else if (nextX == M) {
                    nextX = 0;
                }

                if (array[nextY][nextX] == 1) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX));
            }
        }
    }

    private static class Vertex {

        final int y;
        final int x;

        Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
