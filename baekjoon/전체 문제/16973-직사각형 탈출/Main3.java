import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {

    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;

    private static boolean[][] array;
    private static boolean[][] visited;

    private static int H;
    private static int W;
    private static int startY;
    private static int startX;
    private static int endY;
    private static int endX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    array[i][j] = true;
                }
            }
        }

        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken()) - 1;
        startX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;
        endX = Integer.parseInt(st.nextToken()) - 1;

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        visited[startY][startX] = true;

        queue.offer(new Vertex(startY, startX, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.y == endY && currentVertex.x == endX) {
                return currentVertex.weight;
            }

            // 상
            boolean flag = true;

            int nextY = currentVertex.y - 1;

            if (nextY >= 0 && !visited[nextY][currentVertex.x]) {
                for (int i = currentVertex.x; i < currentVertex.x + W; i++) {
                    if (i >= M || array[nextY][i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    visited[currentVertex.y - 1][currentVertex.x] = true;

                    queue.offer(new Vertex(currentVertex.y - 1, currentVertex.x, currentVertex.weight + 1));
                }
            }

            // 하
            flag = true;

            nextY = currentVertex.y + H;

            if (nextY < N && !visited[nextY][currentVertex.x]) {
                for (int i = currentVertex.x; i < currentVertex.x + W; i++) {
                    if (i >= M || array[nextY][i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    visited[currentVertex.y + 1][currentVertex.x] = true;

                    queue.offer(new Vertex(currentVertex.y + 1, currentVertex.x, currentVertex.weight + 1));
                }
            }

            // 좌
            flag = true;

            int nextX = currentVertex.x - 1;

            if (nextX >= 0 && !visited[currentVertex.y][nextX]) {
                for (int i = currentVertex.y; i < currentVertex.y + H; i++) {
                    if (i >= N || array[i][nextX]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    visited[currentVertex.y][currentVertex.x - 1] = true;

                    queue.offer(new Vertex(currentVertex.y, currentVertex.x - 1, currentVertex.weight + 1));
                }
            }

            // 우
            flag = true;

            nextX = currentVertex.x + W;

            if (nextX < M && !visited[currentVertex.y][nextX]) {
                for (int i = currentVertex.y; i < currentVertex.y + H; i++) {
                    if (i >= N || array[i][nextX]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    visited[currentVertex.y][currentVertex.x + 1] = true;

                    queue.offer(new Vertex(currentVertex.y, currentVertex.x + 1, currentVertex.weight + 1));
                }
            }
        }

        return -1;
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
