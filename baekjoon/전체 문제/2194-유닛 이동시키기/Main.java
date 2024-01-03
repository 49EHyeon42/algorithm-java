import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Vertex> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;
    private static int A;
    private static int B;
    private static boolean[][] array;
    private static boolean[][] visited;
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
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        array = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            array[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken()) - 1;
        startX = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
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

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY + A - 1 >= N || nextX < 0 || nextX + B - 1 >= M) {
                    continue;
                }

                if (!canMove(nextY, nextX)) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX, currentVertex.weight + 1));
            }
        }

        return -1;
    }

    private static boolean canMove(int y, int x) {
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (array[y + i][x + j]) {
                    return false;
                }
            }
        }

        return true;
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
