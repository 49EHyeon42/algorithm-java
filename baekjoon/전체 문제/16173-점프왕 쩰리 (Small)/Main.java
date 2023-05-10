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

    private static int[][] graph;
    private static boolean[][] visit;

    private static String bfs() {
        // [0] = Y, [1] = X
        Queue<int[]> queue = new LinkedList<>();

        visit[0][0] = true;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cc = queue.poll(); // cc = current coordinate

            // 오른쪽 이동
            if (isPossible(cc[0], cc[1] + graph[cc[0]][cc[1]]) &&
                    !visit[cc[0]][cc[1] + graph[cc[0]][cc[1]]]) {
                int nextY = cc[0];
                int nextX = cc[1] + graph[cc[0]][cc[1]];

                if (nextY == N - 1 && nextX == N - 1) {
                    return "HaruHaru";
                }

                visit[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX});
            }

            // 아래쪽 이동
            if (isPossible(cc[0] + graph[cc[0]][cc[1]], cc[1]) &&
                    !visit[cc[0] + graph[cc[0]][cc[1]]][cc[1]]) {
                int nextY = cc[0] + graph[cc[0]][cc[1]];
                int nextX = cc[1];

                if (nextY == N - 1 && nextX == N - 1) {
                    return "HaruHaru";
                }

                visit[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX});
            }
        }

        return "Hing";
    }

    private static boolean isPossible(int y, int x) {
        return y < N && x < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs());
        bw.flush();

        br.close();
        bw.close();
    }
}
