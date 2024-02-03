import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx1 = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static final int[][] dyx2 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int K;
    private static int H;
    private static int W;

    private static boolean[][] array;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        array = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                if (st.nextToken().charAt(0) == '1') {
                    array[i][j] = true;
                }
            }
        }

        visited = new boolean[K + 1][H][W];

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        visited[0][0][0] = true;

        queue.offer(new Vertex(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.y == H - 1 && currentVertex.x == W - 1) {
                return currentVertex.weight;
            }

            int nextWeight = currentVertex.weight + 1;

            if (currentVertex.horseMove < K) {
                int nextHorseMove = currentVertex.horseMove + 1;

                for (int i = 0; i < 8; i++) {
                    int nextY = currentVertex.y + dyx1[i][0];
                    int nextX = currentVertex.x + dyx1[i][1];

                    if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W) {
                        continue;
                    }

                    if (array[nextY][nextX]) {
                        continue;
                    }

                    if (visited[nextHorseMove][nextY][nextX]) {
                        continue;
                    }

                    visited[nextHorseMove][nextY][nextX] = true;

                    queue.offer(new Vertex(nextY, nextX, nextHorseMove, nextWeight));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx2[i][0];
                int nextX = currentVertex.x + dyx2[i][1];

                if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W) {
                    continue;
                }

                if (array[nextY][nextX]) {
                    continue;
                }

                if (visited[currentVertex.horseMove][nextY][nextX]) {
                    continue;
                }

                visited[currentVertex.horseMove][nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX, currentVertex.horseMove, nextWeight));
            }
        }

        return -1;
    }

    private static class Vertex {

        final int y;
        final int x;
        final int horseMove;
        final int weight;

        Vertex(int y, int x, int horseMove, int weight) {
            this.y = y;
            this.x = x;
            this.horseMove = horseMove;
            this.weight = weight;
        }
    }
}
