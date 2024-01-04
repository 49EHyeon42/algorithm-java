import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Vertex> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;
    private static int[][] array;

    private static int maxWeight = -1;
    private static int result = 0;

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 0) {
                    continue;
                }

                bfs(i, j);
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs(int startY, int startX) {
        boolean[][] visited = new boolean[N][M];

        visited[startY][startX] = true;

        queue.offer(new Vertex(startY, startX, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.weight > maxWeight) {
                maxWeight = currentVertex.weight;

                result = array[startY][startX] + array[currentVertex.y][currentVertex.x];
            } else if (currentVertex.weight == maxWeight && result < array[startY][startX] + array[currentVertex.y][currentVertex.x]) {
                result = array[startY][startX] + array[currentVertex.y][currentVertex.x];
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (array[nextY][nextX] == 0) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX, currentVertex.weight + 1));
            }
        }
    }

    private static class Vertex {

        final int y;
        final int x;
        final int weight;

        Vertex(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
