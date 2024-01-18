import java.io.*;
import java.util.*;

public class Main {

    private static final Set<Vertex> viruses = new HashSet<>();
    private static final Queue<Vertex> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;

    private static int[][] array;

    private static int defaultSize;

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int wallCount = 3;

        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());

                if (v == 1) {
                    wallCount++;
                } else if (v == 2) {
                    viruses.add(new Vertex(i, j));
                }

                array[i][j] = v;
            }
        }

        defaultSize = N * M - wallCount;

        backtracking(0);

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth) {
        if (depth == 3) {
            result = Math.max(result, bfs());

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] != 0) {
                    continue;
                }

                array[i][j] = 1;
                backtracking(depth + 1);
                array[i][j] = 0;
            }
        }
    }

    private static int bfs() {
        int virusCount = 0;

        boolean[][] visited = new boolean[N][M];

        for (Vertex virus : viruses) {
            visited[virus.y][virus.x] = true;

            queue.offer(new Vertex(virus.y, virus.x));
        }

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            virusCount++;

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (array[nextY][nextX] != 0) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX));
            }
        }

        return defaultSize - virusCount;
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
