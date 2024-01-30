import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;

    private static boolean[][] array;

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
                if (st.nextToken().equals("1")) {
                    array[i][j] = true;
                }
            }
        }

        int time = 0;

        while (bfs()) {
            time++;
        }

        bw.write(Integer.toString(time));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean bfs() {
        boolean melted = false;

        // -1 = 방문, 0 = 방문 X, etc = 치즈 면적
        int[][] visited = new int[N][M];

        visited[0][0] = -1;

        queue.offer(new Vertex(0, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (visited[nextY][nextX] == -1) {
                    continue;
                }

                if (array[nextY][nextX]) { // 치즈
                    visited[nextY][nextX]++;

                    if (visited[nextY][nextX] > 1) {
                        melted = true;

                        visited[nextY][nextX] = -1;

                        array[nextY][nextX] = false; // 치즈에서 빈칸으로 변경
                    }
                } else { // 빈칸
                    visited[nextY][nextX] = -1;

                    queue.offer(new Vertex(nextY, nextX));
                }
            }
        }

        return melted;
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
