import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int n;

    private static int[][] graph;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대 경로
        dp = new int[n][n];

        int maxWeight = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxWeight = Math.max(maxWeight, dfs(i, j));
            }
        }

        bw.write(Integer.toString(maxWeight));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dfs(int y, int x) { // 재귀
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        dp[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dyx[i][0];
            int nextX = x + dyx[i][1];

            if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                continue;
            }

            if (graph[y][x] >= graph[nextY][nextX]) {
                continue;
            }

            dp[y][x] = Math.max(dp[y][x], dfs(nextY, nextX) + 1);
        }

        return dp[y][x];
    }
}
