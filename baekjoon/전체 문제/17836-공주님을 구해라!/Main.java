import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;
    private static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        array = new int[N + 1][M + 1];

        // [0] = y, [1] = x
        int[] gram = new int[2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

                if (array[i][j] == 2) {
                    gram[0] = i;
                    gram[1] = j;
                }
            }
        }

        int weight = bfs(N, M);
        int weightWithGram = bfs(gram[0], gram[1]);

        if (weightWithGram != 0) {
            weightWithGram += N - gram[0] + M - gram[1];
        }

        if (weight != 0 && weightWithGram != 0) {
            weight = Math.min(weight, weightWithGram);
        } else if (weight == 0) {
            weight = weightWithGram;
        }

        bw.write(weight == 0 || T < weight ? "Fail" : Integer.toString(weight));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int endY, int endX) {
        queue.clear();

        int[][] visited = new int[N + 1][M + 1];
        visited[1][1] = 1;

        queue.offer(new Vertex(1, 1));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.y == endY && currentVertex.x == endX) {
                return visited[endY][endX] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dy[i];
                int nextX = currentVertex.x + dx[i];

                if (nextY < 1 || nextY > N || nextX < 1 || nextX > M) {
                    continue;
                }

                if (array[nextY][nextX] == 1) {
                    continue;
                }

                if (visited[nextY][nextX] != 0) {
                    continue;
                }

                visited[nextY][nextX] = visited[currentVertex.y][currentVertex.x] + 1;

                queue.offer(new Vertex(nextY, nextX));
            }
        }

        return 0;
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
