import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    private static final Queue<Vertex> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;

    private static boolean[][] array;

    private static Coordinate start;
    private static Coordinate end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        start = new Coordinate(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        st = new StringTokenizer(br.readLine());
        end = new Coordinate(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    array[i][j] = true;
                }
            }
        }

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        int[][][] visited = new int[2][N][M];

        visited[0][start.y][start.x] = 1;

        queue.offer(new Vertex(start.y, start.x, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.y == end.y && currentVertex.x == end.x) {
                return visited[currentVertex.isBreak][currentVertex.y][currentVertex.x] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (array[nextY][nextX] && currentVertex.isBreak == 0) {
                    visited[1][nextY][nextX] = visited[currentVertex.isBreak][currentVertex.y][currentVertex.x] + 1;

                    queue.offer(new Vertex(nextY, nextX, 1));
                }

                if (!array[nextY][nextX] && visited[currentVertex.isBreak][nextY][nextX] == 0) {
                    visited[currentVertex.isBreak][nextY][nextX] = visited[currentVertex.isBreak][currentVertex.y][currentVertex.x] + 1;

                    queue.offer(new Vertex(nextY, nextX, currentVertex.isBreak));
                }
            }
        }

        return -1;
    }

    private static class Coordinate {

        final int y;
        final int x;

        Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Vertex {

        final int y;
        final int x;
        final int isBreak; // 0 = false, 1 = true, 배열에 사용하기 위해 boolean 대신 int 사용

        Vertex(int y, int x, int isBreak) {
            this.y = y;
            this.x = x;
            this.isBreak = isBreak;
        }
    }
}
