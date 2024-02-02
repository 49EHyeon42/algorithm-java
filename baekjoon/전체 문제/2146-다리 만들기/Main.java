import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();
    private static final Queue<Vertex2> queue2 = new ArrayDeque<>();

    private static int N;

    private static int[][] array;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        int label = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == 1 && !visited[i][j]) {
                    bfs(label, i, j);

                    label++;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 2; i <= label; i++) {
            min = Math.min(min, bfs2(i));
        }

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs(int island, int y, int x) {
        visited[y][x] = true;

        queue.offer(new Vertex(y, x));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            array[currentVertex.y][currentVertex.x] = island;

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (array[nextY][nextX] != 1) {
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

    private static int bfs2(int label) {
        int min = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == label) {
                    visited[i][j] = true;

                    queue2.offer(new Vertex2(i, j, 0));
                }
            }
        }

        while (!queue2.isEmpty()) {
            Vertex2 currentVertex = queue2.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                if (array[nextY][nextX] == 0) {
                    visited[nextY][nextX] = true;

                    queue2.offer(new Vertex2(nextY, nextX, currentVertex.weight + 1));
                } else if (array[nextY][nextX] != label) {
                    min = Math.min(min, currentVertex.weight);
                }
            }
        }

        return min;
    }

    private static class Vertex {

        final int y;
        final int x;

        Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Vertex2 {

        final int y;
        final int x;
        final int weight;

        Vertex2(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
