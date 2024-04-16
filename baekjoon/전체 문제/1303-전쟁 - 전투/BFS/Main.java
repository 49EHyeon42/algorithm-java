import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Vertex> queue = new LinkedList<>();

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;

    private static boolean[][] graph;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // false = 아군, true = 적군
        graph = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String string = br.readLine();

            for (int j = 0; j < N; j++) {
                if (string.charAt(j) == 'B') {
                    graph[i][j] = true;
                }
            }
        }

        int friend = 0;
        int enemy = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (graph[i][j]) { // 적군
                    enemy += bfs(true, i, j);
                } else { // 아군
                    friend += bfs(false, i, j);
                }
            }
        }

        bw.write(friend + " " + enemy);
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(boolean color, int startY, int startX) {
        int count = 0;

        visited[startY][startX] = true;

        queue.offer(new Vertex(startY, startX));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            count++;

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= M || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (graph[nextY][nextX] != color) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX));
            }
        }

        return count * count;
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
