import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;
    private static int K;

    private static boolean[][] array;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                if (string.charAt(j) == '1') {
                    array[i][j] = true;
                }
            }
        }

        visited = new boolean[K + 1][N][M];

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        visited[0][0][0] = true;

        queue.offer(new Vertex(0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.y == N - 1 && currentVertex.x == M - 1) {
                return currentVertex.weight;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (array[nextY][nextX]) {
                    int nextCrush = currentVertex.crush + 1;

                    if (nextCrush > K) {
                        continue;
                    }

                    if (visited[nextCrush][nextY][nextX]) {
                        continue;
                    }

                    visited[nextCrush][nextY][nextX] = true;

                    queue.offer(new Vertex(nextY, nextX, nextCrush, currentVertex.weight + 1));
                } else {
                    if (visited[currentVertex.crush][nextY][nextX]) {
                        continue;
                    }

                    visited[currentVertex.crush][nextY][nextX] = true;

                    queue.offer(new Vertex(nextY, nextX, currentVertex.crush, currentVertex.weight + 1));
                }
            }
        }

        return -1;
    }

    private static class Vertex {

        final int y;
        final int x;
        final int crush;
        final int weight;

        Vertex(int y, int x, int crush, int weight) {
            this.y = y;
            this.x = x;
            this.crush = crush;
            this.weight = weight;
        }
    }
}
