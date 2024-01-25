import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;

    private static boolean[][] visited;
    private static int[][] prefixSumArray;

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

        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        prefixSumArray = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    prefixSumArray[i][j] = array[i][j];
                } else if (i == 0) {
                    prefixSumArray[i][j] = array[i][j] + prefixSumArray[i][j - 1];
                } else if (j == 0) {
                    prefixSumArray[i][j] = array[i][j] + prefixSumArray[i - 1][j];
                } else {
                    prefixSumArray[i][j] = array[i][j] + prefixSumArray[i - 1][j] + prefixSumArray[i][j - 1] - prefixSumArray[i - 1][j - 1];
                }
            }
        }

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

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                int nextY2 = nextY + H - 1;
                int nextX2 = nextX + W - 1;

                if (nextY2 >= N || nextX2 >= M) {
                    continue;
                }

                if (getNumberOfWalls(nextY, nextX, nextY2, nextX2) != 0) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX, currentVertex.weight + 1));
            }
        }

        return -1;
    }

    private static int getNumberOfWalls(int y1, int x1, int y2, int x2) {
        if (y1 == 0 && x1 == 0) {
            return prefixSumArray[y2][x2];
        } else if (y1 == 0) {
            return prefixSumArray[y2][x2] - prefixSumArray[y2][x1 - 1];
        } else if (x1 == 0) {
            return prefixSumArray[y2][x2] - prefixSumArray[y1 - 1][x2];
        }

        return prefixSumArray[y2][x2] - prefixSumArray[y1 - 1][x2] - prefixSumArray[y2][x1 - 1] + prefixSumArray[y1 - 1][x1 - 1];
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
