import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static int[][] graph;
    // isBreak == 0 ? 벽 통과 X : 벽 통과 O
    private static int[][][] visited; // break, y, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Character.getNumericValue(string.charAt(j));
            }
        }

        bw.write(Integer.toString(bfs()));

        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0});

        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int isBreak = queue.peek()[0];
            int y = queue.peek()[1];
            int x = queue.peek()[2];
            queue.poll();

            // 최단 거리 return
            if (y == N - 1 && x == M - 1) {
                return visited[isBreak][y][x];
            }

            for (int i = 0; i < 4; i++) {
                int currentY = y + dy[i];
                int currentX = x + dx[i];

                if (isPossibleLength(currentY, currentX)) {
                    if (graph[currentY][currentX] == 1 && isBreak == 0) {
                        visited[isBreak + 1][currentY][currentX] = visited[isBreak][y][x] + 1;
                        queue.offer(new int[]{isBreak + 1, currentY, currentX});
                    }

                    if (graph[currentY][currentX] == 0
                        && visited[isBreak][currentY][currentX] == 0) {
                        visited[isBreak][currentY][currentX] = visited[isBreak][y][x] + 1;
                        queue.offer(new int[]{isBreak, currentY, currentX});
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isPossibleLength(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
