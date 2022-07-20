import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// dp(top-down) + dfs
public class Main {

    private static final int[] DY = new int[]{1, -1, 0, 0};
    private static final int[] DX = new int[]{0, 0, 1, -1};

    private static int length, width;
    private static int[][] matrix, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        matrix = new int[length][width];
        dp = new int[length][width];

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(Integer.toString(dfs(0, 0)));

        bw.flush();
        bw.close();
    }

    private static int dfs(int y, int x) {
        if (y == length - 1 && x == width - 1) {
            return 1;
        }

        if (dp[y][x] == -1) {
            dp[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (isPossible(ny, nx) && matrix[ny][nx] < matrix[y][x]) {
                    dp[y][x] += dfs(ny, nx);
                }
            }
        }

        return dp[y][x];
    }

    private static boolean isPossible(int y, int x) {
        return y >= 0 && x >= 0 && y < length && x < width;
    }
}
