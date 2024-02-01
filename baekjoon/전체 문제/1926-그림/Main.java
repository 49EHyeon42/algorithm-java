import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int n;
    private static int m;

    private static boolean[][] array;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                if (st.nextToken().charAt(0) == '1') {
                    array[i][j] = true;
                }
            }
        }

        visited = new boolean[n][m];

        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] && !visited[i][j]) {
                    count++;

                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        bw.write(count + "\n" + max);
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int y, int x) {
        int count = 0;

        visited[y][x] = true;

        queue.offer(new Vertex(y, x));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            count++;

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }

                if (!array[nextY][nextX]) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX));
            }
        }

        return count;
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
