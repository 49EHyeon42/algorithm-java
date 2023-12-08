import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;
    private static int[][] array;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (array[y][x] == 0 || visited[y][x]) {
                    continue;
                }

                if (bfs(y, x)) {
                    count++;
                }
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean bfs(int startY, int startX) {
        boolean result = true;

        visited[startY][startX] = true;

        queue.offer(new Vertex(startY, startX));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextY = currentVertex.y + dy[i];
                int nextX = currentVertex.x + dx[i];

                if (nextY < 1 || nextY > N || nextX < 1 || nextX > M) {
                    continue;
                }

                if (array[currentVertex.y][currentVertex.x] < array[nextY][nextX]) {
                    result = false;
                }

                if (array[currentVertex.y][currentVertex.x] != array[nextY][nextX]) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX));
            }
        }

        return result;
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
