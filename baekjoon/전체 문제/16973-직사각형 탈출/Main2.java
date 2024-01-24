import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;

    private static boolean[][] array;
    private static int[][] visited;

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

        visited = new int[N][M];

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
        visited[startY][startX] = 1;

        queue.offer(new Vertex(startY, startX));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.y == endY && currentVertex.x == endX) {
                return visited[currentVertex.y][currentVertex.x] - 1;
            }

            up(currentVertex);
            down(currentVertex);
            left(currentVertex);
            right(currentVertex);
        }

        return -1;
    }

    private static void up(Vertex currentVertex) {
        int nextY = currentVertex.y - 1;

        if (nextY < 0) {
            return;
        }

        for (int i = currentVertex.x; i < currentVertex.x + W; i++) {
            if (i >= M || array[nextY][i]) {
                return;
            }
        }

        if (visited[nextY][currentVertex.x] != 0) {
            return;
        }

        visited[currentVertex.y - 1][currentVertex.x] = visited[currentVertex.y][currentVertex.x] + 1;

        queue.offer(new Vertex(currentVertex.y - 1, currentVertex.x));
    }

    private static void down(Vertex currentVertex) {
        int nextY = currentVertex.y + H;

        if (nextY >= N) {
            return;
        }

        for (int i = currentVertex.x; i < currentVertex.x + W; i++) {
            if (i >= M || array[nextY][i]) {
                return;
            }
        }

        if (visited[nextY][currentVertex.x] != 0) {
            return;
        }

        visited[currentVertex.y + 1][currentVertex.x] = visited[currentVertex.y][currentVertex.x] + 1;

        queue.offer(new Vertex(currentVertex.y + 1, currentVertex.x));
    }

    private static void left(Vertex currentVertex) {
        int nextX = currentVertex.x - 1;

        if (nextX < 0) {
            return;
        }

        for (int i = currentVertex.y; i < currentVertex.y + H; i++) {
            if (i >= N || array[i][nextX]) {
                return;
            }
        }

        if (visited[currentVertex.y][nextX] != 0) {
            return;
        }

        visited[currentVertex.y][currentVertex.x - 1] = visited[currentVertex.y][currentVertex.x] + 1;

        queue.offer(new Vertex(currentVertex.y, currentVertex.x - 1));
    }

    private static void right(Vertex currentVertex) {
        int nextX = currentVertex.x + W;

        if (nextX >= M) {
            return;
        }

        for (int i = currentVertex.y; i < currentVertex.y + H; i++) {
            if (i >= N || array[i][nextX]) {
                return;
            }
        }

        if (visited[currentVertex.y][nextX] != 0) {
            return;
        }

        visited[currentVertex.y][currentVertex.x + 1] = visited[currentVertex.y][currentVertex.x] + 1;

        queue.offer(new Vertex(currentVertex.y, currentVertex.x + 1));
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
