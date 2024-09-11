import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int M;
    private static int N;

    private static int maxY;
    private static int maxX;

    private static int[][] array;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maxY = M - 1;
        maxX = N - 1;

        array = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(Integer.toString(dfs(0, 0)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dfs(int currentY, int currentX) {
        if (currentY == maxY && currentX == maxX) {
            return 1;
        }

        if (dp[currentY][currentX] != -1) {
            return dp[currentY][currentX];
        }

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nextY = currentY + dyx[i][0];
            int nextX = currentX + dyx[i][1];

            if (nextY < 0 || nextY >= M || nextX < 0 || nextX >= N) {
                continue;
            }

            if (array[currentY][currentX] <= array[nextY][nextX]) {
                continue;
            }

            count += dfs(nextY, nextX);
        }

        dp[currentY][currentX] = count;

        return dp[currentY][currentX];
    }
}
