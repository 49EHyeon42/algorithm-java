import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    private static int N;

    private static int[][] graph;
    private static boolean[][] visit;

    private static final Queue<int[]> queue = new LinkedList<>();

    private static void bfs(int height, int y, int x) {
        queue.clear();

        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = coordinate[0] + dy[i];
                int nextX = coordinate[1] + dx[i];

                if (isPossible(nextY, nextX) && height < graph[nextY][nextX]
                        && !visit[nextY][nextX]) {
                    visit[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX});
                }
            }
        }
    }

    private static boolean isPossible(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;

        for (int height = 0; height <= 100; height++) {
            int count = 0;
            visit = new boolean[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (height < graph[y][x] && !visit[y][x]) {
                        count++;
                        bfs(height, y, x);
                    }
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        bw.write(Integer.toString(maxCount));
        bw.flush();

        br.close();
        bw.close();
    }
}
